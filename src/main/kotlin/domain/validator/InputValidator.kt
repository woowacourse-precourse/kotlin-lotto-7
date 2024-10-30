package domain.validator

import delegate.common.CommonErrorDelegate
import delegate.input.InputErrorDelegate
import domain.enums.Process

class InputValidator(
    private val commonErrorDelegator: CommonErrorDelegate,
    private val inputErrorDelegate: InputErrorDelegate
) {
    operator fun invoke(value: String) {
        payValidation(value)
    }

    private fun payValidation(value: String) {
        val process = Process.PAY
        commonErrorDelegator.isEmpty(value)
        commonErrorDelegator.isNumeric(value, process)
        inputErrorDelegate.isThousandWonUnit(value)
    }
}