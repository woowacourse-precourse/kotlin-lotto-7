package lotto.domain.usecase

import lotto.domain.entity.BonusNumber
import lotto.extention.parseToIntOrThrow

class CreateBonusNumberUseCase {
    fun execute(bonusNumberInput: () -> String, numbers: List<Int>): BonusNumber {
        while (true) {
            try {
                val bonusNumber = bonusNumberInput().parseToIntOrThrow()
                return BonusNumber(bonusNumber, numbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}