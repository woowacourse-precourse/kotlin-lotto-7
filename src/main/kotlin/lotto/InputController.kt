package lotto

class InputController(
    private val inputView: InputView,
    private val inputValidator: InputValidator
) {

    fun getValidPurchaseAmount(): Int {
        return getValidInput(
            inputProvider = { inputView.getPurchaseAmount() },
            validator = { amount -> inputValidator.validatePurchaseAmount(amount) }
        )
    }

    fun getValidWinningNumbers(): List<Int> {
        return getValidInput(
            inputProvider = { inputView.getWinningNumbers() },
            validator = { numbers -> inputValidator.validateWinningNumbers(numbers) }
        )
    }

    fun getValidBonusNumber(winningNumbers: List<Int>): Int {
        return getValidInput(
            inputProvider = { inputView.getBonusNumber() },
            validator = { bonus ->
                inputValidator.validateBonusNumber(bonus, winningNumbers)
            }
        )
    }

    private fun <I, O> getValidInput(inputProvider: () -> I, validator: (I) -> O): O {
        while (true) {
            try {
                val input = inputProvider()
                return validator(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}