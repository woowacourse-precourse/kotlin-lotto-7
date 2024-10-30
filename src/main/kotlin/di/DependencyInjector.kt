package di

import delegate.common.CommonErrorDelegate
import delegate.common.CommonErrorDelegator
import delegate.input.InputErrorDelegate
import delegate.input.InputErrorDelegator
import domain.validator.InputValidator

class DependencyInjector {
    fun injectInputValidator(): InputValidator {
        val commonErrorDelegator = CommonErrorDelegator()
        val inputErrorDelegate = InputErrorDelegator()
        return InputValidator(commonErrorDelegator, inputErrorDelegate)
    }
    fun injectCommonErrorDelegate(): CommonErrorDelegate = CommonErrorDelegator()
    fun injectInputErrorDelegate(): InputErrorDelegate = InputErrorDelegator()
}