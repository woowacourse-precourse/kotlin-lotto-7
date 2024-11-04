package lotto.domain.numberGenerator

import camp.nextstep.edu.missionutils.Randoms

private const val LOTTO_NUMBER_LOWER_BOUND = 1
private const val LOTTO_NUMBER_UPPER_BOUND = 45
private const val LOTTO_NUMBER_COUNT = 6

class RandomNumberGenerator : NumberGenerator {
    override fun generateLottoNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_LOWER_BOUND,
            LOTTO_NUMBER_UPPER_BOUND, LOTTO_NUMBER_COUNT)
    }
}