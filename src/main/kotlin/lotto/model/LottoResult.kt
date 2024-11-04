package lotto.model

class LottoResult(private val result: Map<Rank, Int>) {
    fun getTotalAmount(): Int {
        var totalAmount = 0
        result.forEach { (rank, count) -> totalAmount += rank.winningAmount * count }
        return totalAmount
    }

    fun getCount(rank: Rank): Int {
        return result.getOrDefault(rank, 0)
    }
}
