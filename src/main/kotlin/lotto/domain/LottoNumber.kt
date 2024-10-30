package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.constants.LottoConstants.LOTTO_NUMBER_RANGE
import lotto.constants.LottoConstants.MAX_LOTTO_NUMBER
import lotto.constants.LottoConstants.MIN_LOTTO_NUMBER

fun getLottoNumbers(): List<Int> =
    Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_RANGE)