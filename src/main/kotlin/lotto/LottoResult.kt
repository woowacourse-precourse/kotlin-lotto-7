package lotto

class LottoResult {

    fun checkAmount(payment: Int): Int {
        InputValidation().checkPayment(payment)

        return (payment / 1000)
    }

    fun calculateRevenueRate(payment: Int, results: List<Int>): Double {
        val revenue = calculateRevenue(results)

        return if (payment == 0) 0.00 else String.format("%.2f", (revenue / payment) * 100).toDouble()
    }

    fun calculateRevenue(results: List<Int>): Double {
        val earningPerRank = listOf(5000, 50000, 1500000, 30000000, 2000000000)

        val totalEarnings = results.zip(earningPerRank).sumOf { (count, earning) -> count * earning }

        return totalEarnings.toDouble()
    }
}