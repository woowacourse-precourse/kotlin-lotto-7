package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import java.util.*

class LottoTicket(private val numbers: List<Int>) {

    fun getSortedNumbers(): SortedSet<Int> = numbers.toSortedSet()

    companion object {
        fun generate(): LottoTicket {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            return LottoTicket(numbers)
        }
    }
}