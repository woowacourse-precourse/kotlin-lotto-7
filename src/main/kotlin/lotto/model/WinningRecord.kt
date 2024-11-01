package lotto.model

class WinningRecord {
    fun createRecord(lottoResults: List<LottoRank>): List<Int> {
        val counts = lottoResults.groupingBy { it.rank }.eachCount()
        val labels = LottoRank.Rank.entries

        return labels.map { label ->
            counts.getOrDefault(label, 0)
        }
    }
}