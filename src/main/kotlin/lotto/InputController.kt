package lotto

class InputController(
    private val inputView: InputView,
    private val inputValidator: InputValidator
) {

    fun getValidPurchaseAmount(): Int {
        while (true) {
            try {
                val input = inputView.getPurchaseAmount()
                return inputValidator.validatePurchaseAmount(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun getValidWinningNumbers(): List<Int> {
        while (true) {
            try {
                val input = inputView.getWinningNumbers()
                return inputValidator.validateWinningNumbers(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun getValidBonusNumber(): Int {
        while (true) {
            try {
                val input = inputView.getBonusNumber()
                return inputValidator.validateBonusNumber(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}