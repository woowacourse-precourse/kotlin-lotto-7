package lotto.utils

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto

object LottoMachine {
    
    fun generate(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        return Lotto(numbers)
    }
}