package lotto

class InputController(
    private val inputView: InputView,
    private val inputValidator: InputValidator
) {

    fun getValidPurchaseAmount(): Int {
        return getValidInput { inputView.getPurchaseAmount() }
            .let { inputValidator.validatePurchaseAmount(it) }
    }

    fun getValidWinningNumbers(): List<Int> {
        return getValidInput { inputView.getWinningNumbers() }
            .let { inputValidator.validateWinningNumbers(it) }
    }

    fun getValidBonusNumber(winningNumbers: List<Int>): Int {
        return getValidInput { inputView.getBonusNumber() }
            .let { inputValidator.validateBonusNumber(it, winningNumbers) }
    }

    private fun <T> getValidInput(inputProvider: () -> T): T {
        while (true) {
            try {
                return inputProvider()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}