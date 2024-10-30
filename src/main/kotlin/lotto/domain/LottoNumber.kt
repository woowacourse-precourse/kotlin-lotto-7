package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.constants.Constants.LOTTO_NUMBER_RANGE
import lotto.constants.Constants.MAX_LOTTO_NUMBER
import lotto.constants.Constants.MIN_LOTTO_NUMBER

fun getLottoNumbers(): List<Int> =
    Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_RANGE)