package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.Constants.LOTTO_NUMBER_COUNT
import lotto.utils.Constants.MAX_NUMBER
import lotto.utils.Constants.MIN_NUMBER

data class LottoTicket(val numbers: List<Int>) {

    companion object {
        fun generate(): LottoTicket {
            val generateNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBER_COUNT).sorted()
            return LottoTicket(generateNumbers)
        }
    }
}