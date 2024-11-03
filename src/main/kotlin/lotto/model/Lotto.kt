package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.Constants.MAX_NUMBER
import lotto.utils.Constants.MIN_NUMBER
import lotto.utils.Constants.LOTTO_NUMBER_COUNT
import lotto.utils.ErrorConstants
import javax.swing.UIManager.put

/**
 * 모델은 컨트롤러나 뷰에 의존하면 안된다.
 * 컨트롤러나 뷰의 코드가 있으면 안된다
 */

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { ErrorConstants.LOTTO_NUMBER_COUNT }
        require(numbers.all { it in MIN_NUMBER..MAX_NUMBER }) { ErrorConstants.LOTTO_NUMBER_RANGE }
        require(numbers.distinct().size == LOTTO_NUMBER_COUNT) { ErrorConstants.LOTTO_NUMBER_DUPLICATE }
    }

    fun calculateLottoResults(lottoTickets: List<LottoTicket>, bonusNumber: Int): Map<LottoRank, Int> {

        val rankCounts = mutableMapOf<LottoRank, Int>()
        LottoRank.entries.forEach { rank -> rankCounts[rank] = 0 }

        lottoTickets.forEach{ ticket ->
            val matchCount = ticket.numbers.count { it in numbers }
            val matchBonus = bonusNumber in ticket.numbers
            val rank = LottoRank.getRank(matchCount, matchBonus)
            rankCounts[rank] = rankCounts.getOrDefault(rank, 0) + 1
        }
        return rankCounts
    }


    //fun calculateTotalReturnRate() {}

}
