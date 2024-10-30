package lotto

import delegate.common.CommonErrorDelegator
import delegate.input.InputErrorDelegator
import view.InputView

fun main() {
    val commonErrorDelegator = CommonErrorDelegator()
    val inputErrorDelegate = InputErrorDelegator()
    InputView(commonErrorDelegator, inputErrorDelegate)

}