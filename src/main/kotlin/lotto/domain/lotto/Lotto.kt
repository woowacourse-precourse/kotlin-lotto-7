package lotto.domain.lotto

import lotto.domain.enums.Exception
import lotto.domain.enums.LottoSetting.LOTTO_MIN
import lotto.domain.enums.LottoSetting.LOTTO_MAX
import lotto.domain.enums.LottoSetting.LOTTO_SIZE
import lotto.domain.enums.Rank
import lotto.domain.enums.Rank.Companion.getRank
import java.util.TreeSet

class Lotto(
    // 당첨 번호
    private val numbers: List<Int>
) {
    init {
        require(numbers.size == 6) { Exception.INVALID_LOTTO_SIZE }
        require(numbers.distinct().size == LOTTO_SIZE.value()) { Exception.INVALID_DUPLICATED }
        require(numbers.all { it in LOTTO_MIN.value()..LOTTO_MAX.value() }) {
            Exception.EXCEED_INPUT
        }
    }

    fun getMatches(lottoNumbers: TreeSet<Int>, bonusNumber: Int): Rank {
        val matches = numbers.count { lottoNumbers.contains(it) }
        val bonusMatched = lottoNumbers.contains(bonusNumber)
        val rank = getRank(matches, bonusMatched)
        return rank
    }

}
