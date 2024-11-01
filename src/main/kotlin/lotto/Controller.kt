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

        val money = getNumberOfLotto()

        val randomLotto = getRandomLotto(money)
        output.displayLotto(randomLotto)

        val winningNum = getWinningNum()
        val bonusNum = getBonusNum(winningNum)

    }

    fun getNumberOfLotto(): String {
        var money: String
        while (true) {
            try {
                money = input.getMoney()
                inputValidator.isValidMoney(money)
                return money
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun getRandomLotto(money: String): List<List<Int>> {
        return lottoGenerator.generateLotto(money)
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

    fun getBonusNum(winningNum: List<Int>): Int {
        var bonusNum: String

        while (true) {
            try {
                bonusNum = input.getBonusNum()
                inputValidator.isValidBonusNum(bonusNum, winningNum)
                return bonusNum.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}