package lotto.domain.usecase

import lotto.domain.entity.BonusNumber
import lotto.extention.parseToIntOrThrow

class CreateBonusNumberUseCase {
    fun execute(bonusNumberInput: () -> String, winningNumbers: List<Int>): BonusNumber {
        while (true) {
            try {
                val bonusNumber = bonusNumberInput().parseToIntOrThrow()
                return BonusNumber(bonusNumber, winningNumbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}