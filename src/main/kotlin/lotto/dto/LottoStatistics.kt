package lotto.dto

import lotto.domain.LottoRank

data class LottoStatistics(val rankCount: Map<LottoRank, Int>, val roi: Double)
