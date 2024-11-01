package lotto

class CreateWinningNumbersUseCase {
    fun execute(numbersInput: () -> String, bonusNumberInput: () -> String): WinningNumbers {
        val numbers = getWinningNumbers(numbersInput)
        val bonusNumber = getBonusNumber(bonusNumberInput, numbers)
        return WinningNumbers(numbers, bonusNumber)
    }

    private fun getWinningNumbers(numbersInput: () -> String): List<Int> {
        while (true) {
            try {
                val input = numbersInput()
                val numbers = parseNumbersInput(input)
                validateNumbers(numbers)
                return numbers
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun parseNumbersInput(input: String): List<Int> {
        return input.split(",").map { numberInput ->
            val number = numberInput.toIntOrNull()
            requireNotNull(number) { "[ERROR] 숫자만 입력해주세요." }
            number
        }
    }

    private fun validateNumbers(numbers: List<Int>) {
        require(numbers.size == 6) { "[ERROR] 당첨 번호는 6개여야 합니다." }
        require(numbers.distinct().size == numbers.size) { "[ERROR] 당첨 번호는 중복되면 안됩니다." }
        numbers.forEach { number ->
            require(number <= 45) { "[ERROR] 당첨 번호는 45보다 작거나 같아야 합니다." }
            require(number >= 1) { "[ERROR] 당첨 번호는 1보다 크거나 같아야 합니다." }
        }
    }

    private fun getBonusNumber(bonusNumberInput: () -> String, numbers: List<Int>): Int {
        while (true) {
            try {
                val input = bonusNumberInput()
                val bonusNumber = parseBonusNumber(input)
                validateBonusNumber(bonusNumber, numbers)
                return bonusNumber
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun parseBonusNumber(input: String): Int {
        val number = input.toIntOrNull()
        requireNotNull(number) { "[ERROR] 숫자만 입력해주세요." }
        return number
    }

    private fun validateBonusNumber(bonusNumber: Int, numbers: List<Int>) {
        require(bonusNumber <= 45) { "[ERROR] 보너스 번호는 45보다 작거나 같아야 합니다." }
        require(bonusNumber >= 1) { "[ERROR] 보너스 번호는 1보다 크거나 같아야 합니다." }
        require(numbers.contains(bonusNumber).not()) { "[ERROR] 보너스 번호는 로또 번호들과 중복되면 안됩니다." }
    }
}
