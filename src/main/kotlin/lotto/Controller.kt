package lotto

import lotto.model.Lotto
import lotto.model.LottoGenerator
import lotto.model.LottoResult
import lotto.view.InputView
import lotto.validator.*
import lotto.view.OutputView

class Controller {

    val input = InputView()
    val output = OutputView()
    val inputValidator = InputValidator()
    val lottoGenerator = LottoGenerator()

    fun start() {
        //LottoResult 객체 초기화
        LottoResult.reset()

        val money = getMoney()

        val randomLotto = getRandomLotto(money)
        output.displayLotto(randomLotto)

        val winningNum = Lotto(getWinningNum())

        val bonusNum = getBonusNum(winningNum)

        winningNum.getResult(money, bonusNum, randomLotto)
        output.displayResult()
    }

    fun getMoney(): Int {
        var money: String
        while (true) {
            try {
                money = input.getMoney()
                inputValidator.isValidMoney(money)
                return money.replace(",", "").toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun getRandomLotto(money: Int): List<List<Int>> {
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

    fun getBonusNum(winningNum: Lotto): Int {
        var bonusNum: String

        while (true) {
            try {
                bonusNum = input.getBonusNum()
                inputValidator.isValidBonusNum(bonusNum, winningNum.get())
                return bonusNum.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}