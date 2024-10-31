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
    }
}