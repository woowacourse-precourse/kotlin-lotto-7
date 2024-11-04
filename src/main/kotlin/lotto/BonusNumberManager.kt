package lotto

import camp.nextstep.edu.missionutils.Console

class BonusNumberManager(private val winningNumbers: List<Int>) {

    var bonusNumber: Int = 0

    fun requestBonusNumber() {
        println(REQUEST_BONUS_NUMBER_MESSAGE)
        val bonusNumberInput = Console.readLine()
        try {
            validateBonusNumberInput(bonusNumberInput)
            println()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            println()
            requestBonusNumber()
        }
    }

    private fun validateBonusNumberInput(bonusNumberInput: String) {
        if (!bonusNumberInput.matches(Regex(REGEX_BONUS_NUMBER_PATTERN))) {
            throw IllegalArgumentException(ERROR_BONUS_NUMBER_INPUT_MESSAGE)
        }

        bonusNumber = bonusNumberInput.toInt()

        if (bonusNumber !in 1..45) {
            throw IllegalArgumentException(ERROR_BONUS_NUMBER_RANGE_MESSAGE)
        }

        if (bonusNumber in winningNumbers) {
            throw IllegalArgumentException(ERROR_BONUS_NUMBER_DUPLICATE_MESSAGE)
        }
    }

    companion object {
        private const val REQUEST_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요."
        private const val REGEX_BONUS_NUMBER_PATTERN = "^[0-9,]+\$"
        private const val ERROR_BONUS_NUMBER_INPUT_MESSAGE = "[ERROR] 보너스 번호 입력은 부호가 없는 숫자만 입력 가능합니다."
        private const val ERROR_BONUS_NUMBER_RANGE_MESSAGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."
        private const val ERROR_BONUS_NUMBER_DUPLICATE_MESSAGE = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."
    }
}