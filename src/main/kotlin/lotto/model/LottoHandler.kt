package lotto.model

import lotto.util.Constant
import camp.nextstep.edu.missionutils.Randoms

class LottoHandler {
    fun generateRandomNumbers(): List<Int> {
        val numbers = Randoms.pickUniqueNumbersInRange(Constant.LOTTO_NUMBER_MIN, Constant.LOTTO_NUMBER_MAX, Constant.LOTTO_NUMBER_COUNT)
        return numbers
    }
}
