package lotto.model

class LottoResult(private val result: Map<Rank, Int>) {
    fun calculateProfit(purchaseAmount: PurchaseAmount): Double {
        var totalAmount = 0
        result.forEach { (rank, count) -> totalAmount += rank.winningAmount * count }
        return purchaseAmount.getProfit(totalAmount)
    }
}
