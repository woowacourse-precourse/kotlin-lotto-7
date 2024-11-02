package lotto.domain.usecase

import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.entity.Lotto

class CreateLottoUseCase {
    fun execute(): Lotto {
        val lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(lottoNumbers)
    }
}