package lotto

data class LottoResult(val rankCounts: Map<MatchedCount, Int>, val earningsRate: Float)
