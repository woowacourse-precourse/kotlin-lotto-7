package domain.validator

import delegate.common.CommonErrorDelegate
import delegate.input.InputErrorDelegate
import domain.enums.Output
import domain.enums.Output.Companion.purchaseFormat
import domain.enums.Process
import util.ext.splitByComma
import util.ext.toMapByEachCount

class InputValidator(
    private val commonErrorDelegator: CommonErrorDelegate,
    private val inputErrorDelegate: InputErrorDelegate
) : InputValidate {

    override fun payValidation(value: String): Pair<String, Int> {
        val process = Process.PAY
        commonErrorDelegator.isEmpty(value)
        commonErrorDelegator.isNumeric(value, process)
        inputErrorDelegate.isThousandWonUnit(value)
        return purchaseFormat(value)
    }

    override fun winningNumberValidation(value: String): List<Int> {
        val process = Process.WINNING_NUMBER
        val winningNumber = value.splitByComma()
        commonErrorDelegator.isEmpty(value)
        inputErrorDelegate.isInvalidInputFormat(value)
        inputErrorDelegate.isInvalidLottoSize(winningNumber)
        inputErrorDelegate.isExceededRange(winningNumber, process)
        inputErrorDelegate.isDuplicated(winningNumber.toMapByEachCount())
        return winningNumber.map { it.toInt() }
    }

    override fun bonusNumberValidation(value: String): Int {
        val process = Process.BONUS_NUMBER
        commonErrorDelegator.isEmpty(value)
        commonErrorDelegator.isNumeric(value, process)
        inputErrorDelegate.isExceededRange(listOf(value), process)
        return value.toInt()
    }
}