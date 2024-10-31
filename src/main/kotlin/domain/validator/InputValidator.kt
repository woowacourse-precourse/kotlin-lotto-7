package domain.validator

import delegate.common.CommonErrorDelegate
import delegate.input.InputErrorDelegate
import domain.enums.Output
import domain.enums.Process

class InputValidator(
    private val commonErrorDelegator: CommonErrorDelegate,
    private val inputErrorDelegate: InputErrorDelegate
) {

    fun payValidation(value: String): Pair<String, Int> {
        val process = Process.PAY
        commonErrorDelegator.isEmpty(value)
        commonErrorDelegator.isNumeric(value, process)
        inputErrorDelegate.isThousandWonUnit(value)
        return Output.getPurchase(value)
    }
    fun winningNumberValidation(value: String): List<Int> {
        val process = Process.WINNING_NUMBER
        val winningNumber = value.splitByComma()
        commonErrorDelegator.isEmpty(value)
        inputErrorDelegate.isInvalidInputFormat(value)
        inputErrorDelegate.isInvalidLottoSize(winningNumber)
        inputErrorDelegate.isExceededRange(winningNumber, process)
        inputErrorDelegate.isDuplicated(winningNumber.toMapByEachCount())
        return winningNumber.map { it.toInt() }
    }

    fun bonusNumberValidation(value: String): Int {
        val process = Process.BONUS_NUMBER
        commonErrorDelegator.isEmpty(value)
        commonErrorDelegator.isNumeric(value, process)
        inputErrorDelegate.isExceededRange(listOf(value), process)
        return value.toInt()
    }
}