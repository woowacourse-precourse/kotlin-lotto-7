package lotto.dto

import lotto.domain.LottoRank

class LottoStatistics(val rankCount: Map<LottoRank, Int>, val roi: Double) {
}