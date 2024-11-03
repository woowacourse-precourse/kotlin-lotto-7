package app

import domain.validator.delegate.common.CommonErrorDelegate
import domain.validator.delegate.common.CommonErrorDelegator
import domain.validator.delegate.input.InputErrorDelegate
import domain.validator.delegate.input.InputErrorDelegator
import domain.validator.InputValidator
import presentation.view.View
import presentation.vm.LottoViewModel
import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange
import data.LottoDataSource
import domain.calculator.Calculate
import domain.calculator.Calculator
import domain.enums.LottoSetting.LOTTO_SIZE
import domain.enums.LottoSetting.LOTTO_MAX
import domain.enums.LottoSetting.LOTTO_MIN
import domain.validator.InputValidate
import domain.printer.Printer
import java.util.TreeSet

class DependencyInjector {

    fun injectView() {
        val viewModel = injectLottoViewModel()
        val outputView = injectOutPutView()
        View(outputView, viewModel)
    }

    private fun injectInputValidator(): InputValidate {
        val commonErrorDelegator = injectCommonErrorDelegate()
        val inputErrorDelegate = injectInputErrorDelegate()
        return InputValidator(commonErrorDelegator, inputErrorDelegate)
    }

    fun injectLottoDataSource(): LottoDataSource = LottoDataSource {
        TreeSet(
            pickUniqueNumbersInRange(
                LOTTO_MIN.value(),
                LOTTO_MAX.value(),
                LOTTO_SIZE.value()
            )
        )
    }

    private fun injectLottoViewModel(): LottoViewModel {
        val inputValidator = injectInputValidator()
        val lottoFactory = injectLottoDataSource()
        val calculator = injectCalculator()
        return LottoViewModel(inputValidator, calculator, lottoFactory)
    }

    private fun injectCalculator(): Calculate = Calculator()
    private fun injectOutPutView(): Printer = Printer()
    private fun injectCommonErrorDelegate(): CommonErrorDelegate = CommonErrorDelegator()
    private fun injectInputErrorDelegate(): InputErrorDelegate = InputErrorDelegator()
}