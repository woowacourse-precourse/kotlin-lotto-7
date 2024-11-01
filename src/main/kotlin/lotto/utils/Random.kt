package lotto.utils

import camp.nextstep.edu.missionutils.Randoms

object Random {
    private const val MIN_NUMBER = 1
    private const val MAX_NUMBER = 45
    private const val CRATE_NUMBER_COUNT = 6

    fun crateLottoNumbers() = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, CRATE_NUMBER_COUNT).sorted()

}