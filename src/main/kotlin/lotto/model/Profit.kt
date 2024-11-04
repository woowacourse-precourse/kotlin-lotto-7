package lotto.model

class Profit {
    fun calculateProfitPercentage(purchaseAmount: Int): Double {
        val totalMoney = LottoRank.values().sumOf { rank -> rank.count * rank.prize.toDouble() }
        return (totalMoney / purchaseAmount) * 100.0
    }
}