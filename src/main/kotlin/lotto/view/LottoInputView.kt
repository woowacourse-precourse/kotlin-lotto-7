package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.ErrorMessage
import lotto.util.LottoConstants
import lotto.util.validator.InputValidator

class LottoInputView {
    fun getPurchasePrice(): Int {
        val trimPurchasePrice = Console.readLine().trim()

        require(InputValidator.isNotEmpty(trimPurchasePrice)) {
            ErrorMessage.NO_WHITESPACE_ALLOWED.getMessage()
        }
        require(InputValidator.isNumber(trimPurchasePrice)) {
            ErrorMessage.INPUT_VALUE_MUST_NUMBER.getMessage()
        }

        val purchasePrice = trimPurchasePrice.toInt()
        return purchasePrice
    }

    fun getWinningNumbers(): List<Int> {
        val trimWinningNumbers = Console.readLine().trim()

        require(InputValidator.isDelimiterValid(trimWinningNumbers, LottoConstants.WINNING_NUMBERS_DELIMITER)) {
            ErrorMessage.MUST_SEPARATE_COMMA.getMessage()
        }
        require(InputValidator.isNotEmpty(trimWinningNumbers)) {
            ErrorMessage.NO_WHITESPACE_ALLOWED.getMessage()
        }

        val winningNumbers =
            trimWinningNumbers
                .split(LottoConstants.WINNING_NUMBERS_DELIMITER)
                .map { it.toInt() }
        return winningNumbers
    }

    fun getBonusNumber(): Int {
        val trimBonusNumber = Console.readLine().trim()

        require(InputValidator.isNotEmpty(trimBonusNumber)) {
            ErrorMessage.INPUT_VALUE_MUST_NUMBER.getMessage()
        }
        require(InputValidator.isNotEmpty(trimBonusNumber)) {
            ErrorMessage.NO_WHITESPACE_ALLOWED.getMessage()
        }

        val bonusNumber = trimBonusNumber.toInt()
        return bonusNumber
    }
}