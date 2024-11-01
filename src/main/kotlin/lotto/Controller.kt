package lotto

import lotto.model.Lotto
import lotto.model.LottoGenerator
import lotto.view.InputView
import lotto.validator.*
import lotto.view.OutputView

class Controller {

    val input = InputView()
    val output = OutputView()
    val inputValidator = InputValidator()
    val lottoGenerator = LottoGenerator()

    fun start() {

        val numberOfLotto = getNumberOfLotto()

        val randomLotto = getRandomLotto(numberOfLotto)
        output.displayLotto(numberOfLotto, randomLotto)

        val winningNum = getWinningNum()

    }

    fun getNumberOfLotto(): Int {
        var money: String
        while (true) {
            try {
                money = input.getMoney()
                inputValidator.isValidMoney(money)
                return lottoGenerator.getNumberOfLotto(money)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun getRandomLotto(numberOfLotto: Int): List<List<Int>> {
        return lottoGenerator.generateLotto(numberOfLotto)
    }

    fun getWinningNum(): List<Int> {
        var winningNum: String
        while (true) {
            try {
                winningNum = input.getWinningNum()
                inputValidator.isValidWinningNum(winningNum)
                return winningNum.split(",").map { it.trim().toInt() }
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

}