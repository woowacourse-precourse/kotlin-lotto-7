package lotto.utils

import camp.nextstep.edu.missionutils.Randoms
import lotto.global.LOTTO_MAXIMUM_NUMBER
import lotto.global.LOTTO_MINIMUM_NUMBER
import lotto.global.LOTTO_NUMBERS_SIZE
import lotto.model.Lotto

object LottoMachine {

    fun generate(): Lotto {
        val numbers =
            Randoms.pickUniqueNumbersInRange(LOTTO_MINIMUM_NUMBER, LOTTO_MAXIMUM_NUMBER, LOTTO_NUMBERS_SIZE).sorted()
        return Lotto(numbers)
    }
}