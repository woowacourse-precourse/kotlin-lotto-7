package lotto.controller

import lotto.constants.Constants.DELIMITER
import lotto.constants.Constants.PRICE_UNIT
import lotto.util.Validator
import lotto.util.safeInputCall
import lotto.util.toIntOrException
import lotto.view.InputView

class LottoController(
    private val inputView: InputView = InputView(),
    private val validator: Validator = Validator()
) {
    private fun getLottoCount(): Int = safeInputCall {
        val priceInput = inputView.getPriceInput()
        val tempPrice = priceInput.toIntOrException()

        validator.validatePriceRange(tempPrice)
        validator.validatePriceUnit(tempPrice)

        tempPrice % PRICE_UNIT
    }

    private fun getWinningNumbers(): List<Int> = safeInputCall {
        val winningNumbersInput = inputView.getWinningNumbersInput()
        val winningNumberList = winningNumbersInput.split(DELIMITER)

        val tempWinningNumbers = winningNumberList.map {
            val value = it.toIntOrException()
            validator.validateLottoNumberRange(value)
            value
        }

        tempWinningNumbers.sorted()
    }

    private fun getBonusNumber(): Int = safeInputCall {
        val bonusNumberInput = inputView.getBonusNumberInput()
        val tempBonusNumber = bonusNumberInput.toIntOrException()

        validator.validateLottoNumberRange(tempBonusNumber)

        tempBonusNumber
    }
}