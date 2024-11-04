package lotto

import lotto.validation.InputValidation

class Lotto(private val numbers: List<Int>) {
    private val validator = InputValidation()

    init {
        validator.lottoNumbers(numbers)
    }

    // TODO: 추가 기능 구현
}
