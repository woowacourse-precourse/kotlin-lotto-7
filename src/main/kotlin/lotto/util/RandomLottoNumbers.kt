package lotto.util

import camp.nextstep.edu.missionutils.Randoms

object RandomLottoNumbers {
    private const val START_NUMBER: Int = 1
    private const val END_NUMBER: Int = 45
    private const val NUMBER_OF_LUCKY_NUMBER: Int = 6

    fun pick(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, NUMBER_OF_LUCKY_NUMBER)
    }
}