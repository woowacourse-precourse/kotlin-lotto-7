package lotto.app

import lotto.domain.validator.delegate.common.CommonErrorDelegate
import lotto.domain.validator.delegate.common.CommonErrorDelegator
import lotto.domain.validator.delegate.input.InputErrorDelegate
import lotto.domain.validator.delegate.input.InputErrorDelegator
import lotto.domain.validator.InputValidator
import lotto.presentation.view.View
import lotto.presentation.vm.LottoViewModel
import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange
import lotto.data.LottoDataSource
import lotto.domain.calculator.Calculate
import lotto.domain.calculator.Calculator
import lotto.domain.enums.LottoSetting.LOTTO_SIZE
import lotto.domain.enums.LottoSetting.LOTTO_MAX
import lotto.domain.enums.LottoSetting.LOTTO_MIN
import lotto.domain.printer.Printer
import lotto.domain.validator.InputValidate
import java.util.TreeSet

class DependencyInjector {

    fun injectView() {
        val viewModel = injectLottoViewModel()
        val printer = injectPrinter()
        View(printer, viewModel)
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
    private fun injectPrinter(): Printer = Printer()
    private fun injectCommonErrorDelegate(): CommonErrorDelegate = CommonErrorDelegator()
    private fun injectInputErrorDelegate(): InputErrorDelegate = InputErrorDelegator()
}