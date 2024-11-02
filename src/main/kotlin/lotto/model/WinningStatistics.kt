package lotto.model

class WinningStatistics {
    private var _matchCountStatistics = mutableListOf(0, 0, 0, 0, 0, 0)
    val matchCountStatistics
        get() = _matchCountStatistics

    fun addMatchCountStatistics(index: Int) {
        _matchCountStatistics[index]++
    }

    private var _totalPrize = 0
    val totalPrize
        get() = _totalPrize

    fun addTotalPrize(prize: Int) {
        _totalPrize += prize
    }

}