package lotto.data.random

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

fun pickLottoNumbers(): List<Int> = Randoms.pickUniqueNumbersInRange(
    Lotto.VALID_LOTTO_NUMBER_RANGE.first,
    Lotto.VALID_LOTTO_NUMBER_RANGE.last,
    Lotto.VALID_LOTTO_NUMBER_LENGTH
)
