package lotto.model.lotto

import lotto.model.message.ErrorMessage

class BonusLotto(numbers: List<Int>, private val bonusNumber: Int) : Lotto(numbers) {

    init {
        require(bonusNumber in 1..45) { ErrorMessage.INPUT_1_TO_45.message }
        require(bonusNumber !in numbers) { ErrorMessage.INPUT_DUPLICATION_Bouns.message }
    }
}
