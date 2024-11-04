package lotto.domain.usecase

import lotto.domain.entity.BonusNumber
import lotto.domain.entity.WinningNumbers
import lotto.extention.parseToIntOrThrow

class CreateBonusNumberUseCase {
    fun execute(bonusNumberInput: () -> String, winningNumbers: WinningNumbers): BonusNumber {
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