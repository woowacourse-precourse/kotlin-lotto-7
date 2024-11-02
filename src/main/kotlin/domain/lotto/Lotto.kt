package domain.lotto

import domain.enums.Exception
import domain.enums.LottoSetting.LOTTO_MIN
import domain.enums.LottoSetting.LOTTO_MAX
import domain.enums.LottoSetting.LOTTO_SIZE
import domain.enums.Rank
import domain.enums.Rank.Companion.getRank
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
