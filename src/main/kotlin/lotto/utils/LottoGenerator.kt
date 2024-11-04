package lotto.utils

import camp.nextstep.edu.missionutils.Randoms
import lotto.constants.Constants
import lotto.model.Lotto

class LottoGenerator(
    private val rangeStart: Int = Constants.LOTTO_RANGE_START,
    private val rangeEnd: Int = Constants.LOTTO_RANGE_END,
    private val size: Int = Constants.LOTTO_SIZE
) {
    fun getLotto(): Lotto {
        return Lotto(generateLotto().sorted())
    }

    private fun generateLotto() = Randoms.pickUniqueNumbersInRange(rangeStart, rangeEnd, size)
}