package lotto

class LottoResult(
    private val lottoList: List<Lotto>,
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int,
) {

    fun getMatchingCount(): List<Int> {
        val lottoResults = mutableListOf<Int>()
        val lottoNumberList = lottoList.toNumberList()
        lottoNumberList.forEach { numbers ->
            // TODO: 리팩토링 필요
            val intersectCount = numbers.intersect(winningNumbers).size
            val bonusCount = numbers.getBonusCount(intersectCount)
            val count = intersectCount + bonusCount
            lottoResults.add(count)
        }
        return lottoResults
    }

    private fun List<Int>.getBonusCount(intersectionCount: Int): Int {
        val isContainBonusNumber = this.contains(bonusNumber)
        if (isContainBonusNumber &&
            intersectionCount == FIVE_MATCHES
        ) {
            return BONUS_NUMBER
        }
        return NOT_BONUS_NUMBER
    }

    companion object {
        private const val FIVE_MATCHES = 5
        private const val BONUS_NUMBER = 1
        private const val NOT_BONUS_NUMBER = 0
    }
}