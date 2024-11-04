package lotto.domain.usecase

import camp.nextstep.edu.missionutils.Randoms
import lotto.common.LOTTO_NUMBERS_SIZE
import lotto.common.MAX_LOTTO_NUMBER
import lotto.common.MIN_LOTTO_NUMBER
import lotto.domain.entity.Lotto

class CreateLottoUseCase {
    fun execute(): Lotto {
        val lottoNumbers = Randoms
            .pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBERS_SIZE)
            .sorted()
        return Lotto(lottoNumbers)
    }
}