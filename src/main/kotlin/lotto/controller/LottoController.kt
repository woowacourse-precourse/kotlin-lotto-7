package lotto.controller

import lotto.model.Lotto
import lotto.model.LottoMatchCount
import lotto.model.Random
import lotto.view.InputView
import lotto.view.OutputView
import kotlin.math.round

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val randomGenerator = Random()

    private var money = NOT_INPUT_MONEY_STATE
    private var lottos = mutableListOf<Lotto>()
    private var winLotteryNumber: Lotto? = null
    private var bonusLotteryNumber = NOT_INPUT_BONUS_LOTTERY_NUMBER_STATE

    fun run() {
        purchaseLotto()
        setWinLotteryNumber()
        setBonusLotteryNumber()
        resultStatisticsOfLotto()
    }

    private fun purchaseLotto() {
        try {
            money = inputView.printInputMoney()
            generateLotto(money / LOTTO_PRICE)
            outputView.printPurchaseLottoCount(money / LOTTO_PRICE)
            outputView.printPurchaseLotto(lottos)
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            println(e.message)
            println()
            purchaseLotto()
        }
    }

    private fun setWinLotteryNumber() {
        try {
            val winLotteryNumberList = inputView.printInputWinLotteryNumber()
            winLotteryNumber = Lotto(winLotteryNumberList)
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            println(e.message)
            println()
            setWinLotteryNumber()
        }
    }

    private fun setBonusLotteryNumber() {
        try {
            bonusLotteryNumber =
                inputView.printInputBonusLotteryNumber(winLotteryNumber!!.getNumbers())
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            println(e.message)
            println()
            setBonusLotteryNumber()
        }
    }

    private fun resultStatisticsOfLotto() {
        val matchCount = LottoMatchCount.matchLotto(lottos, winLotteryNumber, bonusLotteryNumber)
        val profit = calculateProfit(matchCount)
        val amountOfProfit = calculateAmountOfProfit(profit)
        outputView.printWinStatistics(matchCount)
        outputView.printAmountOfProfit(amountOfProfit)
    }

    private fun generateLotto(count: Int) {
        repeat(count) {
            lottos.add(Lotto(randomGenerator.generateUniqueRandomList()))
        }
    }

    private fun calculateProfit(matchLottoCount: Map<MatchingLottoCount, Int>): Long {
        var profit = 0L

        for ((key, value) in matchLottoCount) {
            profit += when (key) {
                MatchingLottoCount.THREE -> value * MatchingLottoCount.THREE.price
                MatchingLottoCount.FOUR -> value * MatchingLottoCount.FOUR.price
                MatchingLottoCount.FIVE -> value * MatchingLottoCount.FIVE.price
                MatchingLottoCount.FIVE_BONUS -> value * MatchingLottoCount.FIVE_BONUS.price
                MatchingLottoCount.SIX -> value * MatchingLottoCount.SIX.price
            }
        }
        return profit
    }

    private fun calculateAmountOfProfit(profit: Long): Float =
        round((profit.toFloat() / money) * 1000) / 10


    companion object {
        const val NOT_INPUT_MONEY_STATE = 0
        const val NOT_INPUT_BONUS_LOTTERY_NUMBER_STATE = 0
        const val LOTTO_PRICE = 1_000
    }
}

enum class MatchingLottoCount(val price: Int, val prefix: String) {
    THREE(5_000, "3개 일치 (5,000원) -"),
    FOUR(50_000, "4개 일치 (50,000원) -"),
    FIVE(1_500_000, "5개 일치 (1,500,000원) -"),
    FIVE_BONUS(30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) -"),
    SIX(2_000_000_000, "6개 일치 (2,000,000,000원) -"),
}