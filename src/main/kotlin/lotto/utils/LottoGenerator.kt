package lotto.utils

import camp.nextstep.edu.missionutils.Randoms
import lotto.constants.Constants
import lotto.model.Lotto

class LottoGenerator {
    fun getLotto(): Lotto {
        return Lotto(generateLotto().sorted())
    }

    private fun generateLotto() = Randoms.pickUniqueNumbersInRange(
        Constants.LOTTO_RANGE_START,
        Constants.LOTTO_RANGE_END,
        Constants.LOTTO_SIZE
    )
}