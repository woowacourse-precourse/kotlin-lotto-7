package lotto.domain.winning

import lotto.domain.rank.LottoRank
import java.util.*

private const val INIT = 0

class WinningStatistics(
    private val winningStatistics: EnumMap<LottoRank, Int> = EnumMap(LottoRank::class.java),
) {
    init {
        LottoRank.entries.forEach {
            winningStatistics[it] = INIT
        }
    }

    fun update(lottoRank: LottoRank) {
        winningStatistics[lottoRank] = winningStatistics.getOrDefault(lottoRank, INIT) + 1
    }

    fun calculateProfit(): Long {
        var sum = INIT.toLong()
        for ((lottoRank, count) in winningStatistics) {
            sum += lottoRank.calculatePrice(count)
        }
        return sum
    }

    fun showStatus(): String {
        return buildString {
            LottoRank.entries.reversed().forEach { lottoRank ->
                if (lottoRank != LottoRank.NONE) {
                    appendLine(winningStatistics[lottoRank]?.let { count -> lottoRank.toStatistics(count) })
                }
            }
        }.trimEnd()
    }
}