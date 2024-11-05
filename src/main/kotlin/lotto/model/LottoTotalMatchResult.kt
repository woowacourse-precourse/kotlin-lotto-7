package lotto.model

data class LottoTotalMatchResult(
    var prizeCount1: Int = 0,
    var prizeCount2: Int = 0,
    var prizeCount3: Int = 0,
    var prizeCount4: Int = 0,
    var prizeCount5: Int = 0
) {
    private fun getPrize1(): Int = prizeCount1 * 2000000000
    private fun getPrize2(): Int = prizeCount2 * 30000000
    private fun getPrize3(): Int = prizeCount3 * 1500000
    private fun getPrize4(): Int = prizeCount4 * 50000
    private fun getPrize5(): Int = prizeCount5 * 5000
    fun getTotalPrize(): Float = (getPrize1() + getPrize2() + getPrize3() + getPrize4() + getPrize5()).toFloat()
}