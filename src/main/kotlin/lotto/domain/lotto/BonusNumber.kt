package lotto.domain.lotto

import lotto.validator.BonusNumberValidator

class BonusNumber(val number: Int) {
    init {
        BonusNumberValidator.validate(number)
    }
}