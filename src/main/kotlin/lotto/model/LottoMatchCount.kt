package lotto.model

import lotto.controller.MatchingLottoCount

// 구입한 로또중 당첨된 로또의 개수를 갖고 있는 클래스
object LottoMatchCount {
    private var matchCount: MutableMap<MatchingLottoCount, Int> = mutableMapOf()

    fun increaseCount(c: MatchingLottoCount) {
        matchCount[c] = (matchCount[c] ?: 0) + 1
    }

    fun getMatchCount() = matchCount.toMap()
}