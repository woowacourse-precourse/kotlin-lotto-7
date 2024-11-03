package lotto.controller

import lotto.model.Lotto
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

    fun purchaseLotto() {
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

    fun setWinLotteryNumber() {
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

    fun setBonusLotteryNumber() {
        try {
            bonusLotteryNumber = inputView.printInputBonusLotteryNumber(winLotteryNumber!!.getNumbers())
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            println(e.message)
            println()
            setBonusLotteryNumber()
        }
    }

    fun resultLotto() {
        val matchCount = matchLotto()
        val profit = calculateProfit(matchCount)
        val amountOfProfit = calculateAmountOfProfit(profit)
        outputView.printWinStatistics(matchCount, amountOfProfit)
    }

    private fun generateLotto(count: Int) {
        repeat(count) {
            lottos.add(Lotto(randomGenerator.generateUniqueRandomList()))
        }
    }

    private fun matchLotto(): Map<MatchingLottoCount, Int> {
        val matchLottoNumber = MutableList(lottos.size) { 0 to false }
        for ((ind, lotto) in lottos.withIndex()) {
            matchLottoNumber[ind] = winLotteryNumber?.let {
                lotto.getMatchCount(it) to lotto.isMatchBonusNumber(bonusLotteryNumber)
            }!!
        }

        val matchLottoCount = mutableMapOf<MatchingLottoCount, Int>()
        for (i in matchLottoNumber) {
            increaseMatchCount(matchLottoCount, i.first + isMatchBonusNumber(i.second), i.second)
        }

        return matchLottoCount
    }

    private fun increaseMatchCount(
        matchLottoCount: MutableMap<MatchingLottoCount, Int>,
        matchCount: Int,
        isMatchBonus: Boolean,
    ) {
        when (matchCount) {
            3 -> matchLottoCount[MatchingLottoCount.THREE] = (matchLottoCount[MatchingLottoCount.THREE] ?: 0) + 1
            4 -> matchLottoCount[MatchingLottoCount.FOUR] = (matchLottoCount[MatchingLottoCount.FOUR] ?: 0) + 1
            5 -> matchLottoCount[MatchingLottoCount.FIVE] = (matchLottoCount[MatchingLottoCount.FIVE] ?: 0) + 1
            6 -> {
                if (isMatchBonus) {
                    matchLottoCount[MatchingLottoCount.FIVE_BONUS] = (matchLottoCount[MatchingLottoCount.FIVE_BONUS] ?: 0) + 1
                    return
                }
                matchLottoCount[MatchingLottoCount.SIX] = (matchLottoCount[MatchingLottoCount.SIX] ?: 0) + 1
            }
        }
    }


    private fun isMatchBonusNumber(isMatchBonusCount: Boolean): Int {
        if (isMatchBonusCount) return 1
        return 0
    }

    private fun calculateProfit(matchLottoCount: Map<MatchingLottoCount, Int>): Long {
        var profit = 0L

        for ((key, value) in matchLottoCount) {
            profit += when (key) {
                MatchingLottoCount.THREE -> value * PRIZE_MONEY_3MATCH
                MatchingLottoCount.FOUR -> value * PRIZE_MONEY_4MATCH
                MatchingLottoCount.FIVE -> value * PRIZE_MONEY_5MATCH
                MatchingLottoCount.FIVE_BONUS -> value * PRIZE_MONEY_5MATCH_BONUS
                MatchingLottoCount.SIX -> value * PRIZE_MONEY_6MATCH
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
        const val PRIZE_MONEY_6MATCH = 2_000_000_000
        const val PRIZE_MONEY_5MATCH_BONUS = 30_000_000
        const val PRIZE_MONEY_5MATCH = 1_500_000
        const val PRIZE_MONEY_4MATCH = 50_000
        const val PRIZE_MONEY_3MATCH = 5_000

    }
}

enum class MatchingLottoCount {
    THREE,
    FOUR,
    FIVE,
    FIVE_BONUS,
    SIX,
}