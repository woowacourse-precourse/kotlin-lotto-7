package lotto.domain.usecase

import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.entity.Lotto
import lotto.domain.validator.LottoNumberValidator

class CreateLottoUseCase(
    private val lottoNumbersValidator: LottoNumberValidator = LottoNumberValidator(),
) {
    fun execute(): Lotto {
        val lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        lottoNumbersValidator.validateLottoNumbers(lottoNumbers)
        return Lotto(lottoNumbers)
    }
}