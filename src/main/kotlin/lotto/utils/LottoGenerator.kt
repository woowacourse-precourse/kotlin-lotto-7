package lotto.utils

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto

class LottoGenerator {
    fun getLotto(): Lotto {
        return Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted())
    }
}