package lotto.repository

import lotto.domain.BonusNumber
import lotto.domain.Lotto
import lotto.domain.PurchaseAmount
import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.Result

class Repository {
    private var purchaseAmount: PurchaseAmount? = null
    private var winningNumber: Lotto? = null
    private var bonusNumber: BonusNumber? = null

    var lottos: MutableList<Lotto> = mutableListOf()
    var result = Result()

    fun setPurchaseAmount(number: Int) {
        purchaseAmount = PurchaseAmount(number)
    }

    fun setWinningNumber(number: List<Int>) {
        winningNumber = Lotto(number)
    }

    fun setBonusNumber(number: Int) {
        winningNumber?.let {
            bonusNumber = BonusNumber(number, it)
        }
    }

    fun createLottos() {
        val lottoCnt = purchaseAmount!!.getPurchaseAmount() / 1000
        repeat(lottoCnt) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            lottos.add(Lotto(numbers))
        }
    }

    fun winLottery() {
        lottos.forEach { lotto ->
            val count = countCommonElements(lotto.getNumber(), winningNumber!!.getNumber())
            val bonus = checkBonusNumberMatch(lotto.getNumber())
            when {
                count == 3 -> result.match3Count++
                count == 4 -> result.match4Count++
                count == 5 && bonus -> result.match5AndBonusCount
                count == 5 -> result.match5Count++
                count == 6 -> result.match6Count++
            }
        }
        calculateTotalPrice()
        calculateTotalProfit()
    }

    private fun calculateTotalPrice() {
        result.totalPrice = (result.match3Count * PRIZE_3_MATCH) +
                (result.match4Count * PRIZE_4_MATCH) +
                (result.match5Count * PRIZE_5_MATCH) +
                (result.match5AndBonusCount * PRIZE_5_AND_BONUS_MATCH) +
                (result.match6Count * PRIZE_6_MATCH)
    }

    private fun calculateTotalProfit() {
        result.totalProfit = result.totalPrice.toDouble() / purchaseAmount!!.getPurchaseAmount()
    }

    private fun countCommonElements(winningNumber: List<Int>, lotto: List<Int>): Int {
        return winningNumber.intersect(lotto).size
    }

    private fun checkBonusNumberMatch(lotto: List<Int>): Boolean {
        return lotto.contains(bonusNumber!!.getBonusNumber())
    }

    companion object {
        const val PRIZE_3_MATCH = 5_000
        const val PRIZE_4_MATCH = 50_000
        const val PRIZE_5_MATCH = 1_500_000
        const val PRIZE_5_AND_BONUS_MATCH = 30_000_000
        const val PRIZE_6_MATCH = 2_000_000_000
    }
}