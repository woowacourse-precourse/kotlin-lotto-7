package lotto.controller

import lotto.constants.Constants
import lotto.constants.Exceptions
import lotto.util.Validator
import lotto.util.toIntOrException
import lotto.view.InputView

class LottoController(
    private val inputView: InputView = InputView(),
    private val validator: Validator = Validator()
) {
    private fun getLottoCount(): Int {
        val priceInput = inputView.getPriceInput()
        val tempPrice = priceInput.toIntOrException()

        validator.validatePriceRange(tempPrice)
        validator.validatePriceUnit(tempPrice)

        return tempPrice % Constants.PRICE_UNIT
    }

    private fun getWinningNumbers(): List<Int> {
        val winningNumbersInput = inputView.getWinningNumbersInput()
        val winningNumberList = winningNumbersInput.split(Constants.DELIMITER)

        val tempWinningNumbers = winningNumberList.map {
            val value = it.toIntOrException()
            validator.validateLottoNumberRange(value)
            value
        }

        return tempWinningNumbers
    }

    private fun getBonusNumber(): Int {
        val bonusNumberInput = inputView.getBonusNumberInput()
        val tempBonusNumber = bonusNumberInput.toIntOrException()

        validator.validateLottoNumberRange(tempBonusNumber)

        return tempBonusNumber
    }
}