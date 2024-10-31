package lotto.controller

import lotto.model.Lotto
import lotto.model.Random
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val randomGenerator = Random()

    private var money = NOT_INPUT_MONEY
    private var lotto = mutableListOf<Lotto>()
    private var winLotteryNumber: Lotto?  = null
    private var bonusLotteryNumber = NOT_INPUT_BONUS_LOTTERY_NUMBER


    fun purchaseLotto() {
        money = inputView.printInputMoney()
        generateLotto(money / LOTTO_PRICE)

        outputView.printPurchaseLottoCount(money / LOTTO_PRICE)
        outputView.printPurchaseLotto(lotto)
    }

    fun setLotteryNumber() {
        winLotteryNumber = Lotto(inputView.printInputWinLotteryNumber())
        bonusLotteryNumber = inputView.printInputBonusLotteryNumber()

    }

    private fun generateLotto(count: Int) {
        repeat(count) {
            lotto.add(Lotto(randomGenerator.generateUniqueRandomList()))
        }
    }

    companion object {
        const val NOT_INPUT_MONEY = 0
        const val NOT_INPUT_BONUS_LOTTERY_NUMBER = 0
        const val LOTTO_PRICE = 1_000
    }
}