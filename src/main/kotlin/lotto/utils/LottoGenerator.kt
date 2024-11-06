package lotto.utils

import camp.nextstep.edu.missionutils.Randoms


object LottoGenerator {

    const val LOTTO_START_INCLUSIVE_NUMBER = 1
    const val LOTTO_END_INCLUSIVE_NUMBER = 45
    const val LOTTO_ONE_SET_SIZE = 6
    /**
     * Lotto 번호 한 세트를 생성한다.
     * [LOTTO_START_INCLUSIVE_NUMBER]~[LOTTO_END_INCLUSIVE_NUMBER] 범위의 정수를
     * 중복없이 [LOTTO_ONE_SET_SIZE]개 만큼 생성한다.
     * * default LOTTO_START_INCLUSIVE_NUMBER = 1
     * * default LOTTO_END_INCLUSIVE_NUMBER = 45
     * * default LOTTO_ONE_SET_SIZE = 6
     * @return 생성된 로또 번호 세트가 들어있는 List
     */
    fun createLotto(): List<Int> {
        val lotto = Randoms.pickUniqueNumbersInRange(
            /* startInclusive = */ LOTTO_START_INCLUSIVE_NUMBER,
            /* endInclusive = */ LOTTO_END_INCLUSIVE_NUMBER,
            /* count = */ LOTTO_ONE_SET_SIZE,
        ).sorted()
        return lotto
    }

    const val LOTTO_MONEY_UNIT = 1000
    const val LOTTO_MONEY_MINIMUM = 1000
    const val LOTTO_MONEY_MAXIMUM = 1000000
    /**
     * 금액당 로또 수량을 계산한다.
     * @return 로또 수량
     */
    fun getLottoCount(money: Int): Int {
        val lottoCount = money / LOTTO_MONEY_UNIT
        return lottoCount
    }

}