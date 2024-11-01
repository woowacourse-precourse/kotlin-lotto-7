package lotto

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

    }

    fun getNumberOfLotto(): Int {
        var money: String
        while (true) {
            money = input.getMoney()
            if (inputValidator.isValidMoney(money)) break
        }
        return lottoGenerator.getNumberOfLotto(money)
    }

    fun getRandomLotto(numberOfLotto: Int): List<List<Int>> {
        return lottoGenerator.generateLotto(numberOfLotto)
    }

    fun getWinningLotto() {
        var winningNum: String
        while (true) {
            winningNum = input.getWinningNum()
            if (inputValidator.isValidWinningNum(winningNum)) break
        }
        var bonusNum: String
        while (true) {
            bonusNum = input.getBonusNum()
            if (inputValidator.isValidBonusNum(bonusNum, winningNum)) break
        }

    }

}