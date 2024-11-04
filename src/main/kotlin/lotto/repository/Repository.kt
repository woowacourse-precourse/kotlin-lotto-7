package lotto.repository

import lotto.domain.BonusNumber
import lotto.domain.Lotto
import lotto.domain.PurchaseAmount
import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.Result
import lotto.domain.WinningRank

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
            val rank = WinningRank.findByMatch(count, bonus)

            when (rank) {
                WinningRank.THREE_MATCH -> result.match3Count++
                WinningRank.FOUR_MATCH -> result.match4Count++
                WinningRank.FIVE_MATCH -> result.match5Count++
                WinningRank.FIVE_MATCH_WITH_BONUS -> result.match5AndBonusCount++
                WinningRank.SIX_MATCH -> result.match6Count++
                WinningRank.NO_MATCH -> {} // 아무것도 하지 않음
            }
        }
        calculateTotalPrice()
        calculateTotalProfit()
    }

    private fun calculateTotalPrice() {
        result.totalPrice = result.match3Count * WinningRank.THREE_MATCH.prize +
                result.match4Count * WinningRank.FOUR_MATCH.prize +
                result.match5Count * WinningRank.FIVE_MATCH.prize +
                result.match5AndBonusCount * WinningRank.FIVE_MATCH_WITH_BONUS.prize +
                result.match6Count * WinningRank.SIX_MATCH.prize
    }

    private fun calculateTotalProfit() {
        result.totalProfit = result.totalPrice.toDouble() / purchaseAmount!!.getPurchaseAmount() * 100
    }

    private fun countCommonElements(winningNumber: List<Int>, lotto: List<Int>): Int {
        return winningNumber.intersect(lotto).size
    }

    private fun checkBonusNumberMatch(lotto: List<Int>): Boolean {
        return lotto.contains(bonusNumber!!.getBonusNumber())
    }
}