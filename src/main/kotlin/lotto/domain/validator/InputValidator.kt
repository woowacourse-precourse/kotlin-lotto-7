package lotto.domain.validator

import lotto.domain.validator.delegate.common.CommonErrorDelegate
import lotto.domain.validator.delegate.input.InputErrorDelegate
import lotto.domain.enums.Process
import lotto.domain.util.ext.mapToInt
import lotto.domain.util.ext.splitByComma
import lotto.domain.util.ext.toMapByEachCount

class InputValidator(
    private val commonErrorDelegator: CommonErrorDelegate,
    private val inputErrorDelegate: InputErrorDelegate
) : InputValidate {

    override fun payValidation(value: String) {
        val process = Process.PAY
        commonValidation(value, process)
        inputErrorDelegate.isThousandWonUnit(value)
    }

    override fun winningNumberValidation(value: String): List<Int> {
        val process = Process.WINNING_NUMBER
        val winningNumber = value.splitByComma()
        commonErrorDelegator.isEmpty(value)
        inputErrorDelegate.isInvalidInputFormat(value)
        inputErrorDelegate.isInvalidLottoSize(winningNumber)
        inputErrorDelegate.isExceededRange(winningNumber, process)
        inputErrorDelegate.isDuplicated(winningNumber.toMapByEachCount())
        return winningNumber.mapToInt()
    }

    override fun bonusNumberValidation(value: String): Int {
        val process = Process.BONUS_NUMBER
        commonValidation(value, process)
        inputErrorDelegate.isExceededRange(listOf(value), process)
        return value.toInt()
    }

    override fun commonValidation(value: String, process: Process) {
        commonErrorDelegator.isEmpty(value)
        commonErrorDelegator.isNumeric(value, process)
        commonErrorDelegator.isOverIntMaxValue(value)
    }
}