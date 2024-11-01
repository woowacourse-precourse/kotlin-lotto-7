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
    private var lottos = mutableListOf<Lotto>()
    private var winLotteryNumber: Lotto? = null
    private var bonusLotteryNumber = NOT_INPUT_BONUS_LOTTERY_NUMBER

    fun purchaseLotto() {
        money = inputView.printInputMoney()
        generateLotto(money / LOTTO_PRICE)
        outputView.printPurchaseLottoCount(money / LOTTO_PRICE)
        outputView.printPurchaseLotto(lottos)
    }

    fun setLotteryNumber() {
        winLotteryNumber = Lotto(inputView.printInputWinLotteryNumber())
        bonusLotteryNumber = inputView.printInputBonusLotteryNumber()

    }

    fun resultLotto() {
        val matchCount = matchLotto()
        outputView.printWinStatistics(matchCount)
    }

    private fun generateLotto(count: Int) {
        repeat(count) {
            lottos.add(Lotto(randomGenerator.generateUniqueRandomList()))
        }
    }

    private fun matchLotto(): Map<MatchingLottoCount, Int> {
        val matchLottoNumber = MutableList(lottos.size) { 0 to false }
        for ((ind, lotto) in lottos.withIndex()) {
            matchLottoNumber[ind] = winLotteryNumber?.let { lotto.getMatchCount(it) to lotto.isMatchBonusNumber(bonusLotteryNumber)}!!
        }

        val matchLottoCount = mutableMapOf<MatchingLottoCount, Int>()
        for (i in matchLottoNumber) {
            incrementMatchCount(matchLottoCount, i.first + isMatchBonusNumber(i.second), i.second)
        }

        return matchLottoCount
    }

    private fun incrementMatchCount(matchLottoCount: MutableMap<MatchingLottoCount, Int>, matchCount: Int, isMatchBonus: Boolean) {
        when(matchCount) {
            3 -> matchLottoCount[MatchingLottoCount.THREE] = (matchLottoCount[MatchingLottoCount.THREE] ?: 0) + 1
            4 -> matchLottoCount[MatchingLottoCount.FOUR] = (matchLottoCount[MatchingLottoCount.FOUR] ?: 0) + 1
            5 -> matchLottoCount[MatchingLottoCount.FIVE] = (matchLottoCount[MatchingLottoCount.FIVE] ?: 0) + 1
            6 -> {
                if (isMatchBonus) matchLottoCount[MatchingLottoCount.FIVE_BONUS] = (matchLottoCount[MatchingLottoCount.FIVE_BONUS] ?: 0) + 1
                else matchLottoCount[MatchingLottoCount.SIX] = (matchLottoCount[MatchingLottoCount.SIX] ?: 0) + 1
            }
        }
    }

    private fun isMatchBonusNumber(isMatchBonusCount: Boolean): Int {
        if (isMatchBonusCount) return 1
        return 0
    }


    companion object {
        const val NOT_INPUT_MONEY = 0
        const val NOT_INPUT_BONUS_LOTTERY_NUMBER = 0
        const val LOTTO_PRICE = 1_000
    }
}

enum class MatchingLottoCount {
    THREE,
    FOUR,
    FIVE,
    FIVE_BONUS,
    SIX,
}