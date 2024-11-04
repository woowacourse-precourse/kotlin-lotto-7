package lotto.app

import lotto.data.datasource.LottoDataSource
import lotto.data.datasource.LottoDataSourceImpl
import lotto.data.repository.LottoRepositoryImpl
import lotto.domain.calculator.Calculate
import lotto.domain.calculator.Calculator
import lotto.domain.printer.Printer
import lotto.domain.validator.InputValidate
import lotto.domain.validator.InputValidator
import lotto.domain.validator.delegate.common.CommonErrorDelegate
import lotto.domain.validator.delegate.common.CommonErrorDelegator
import lotto.domain.validator.delegate.input.InputErrorDelegate
import lotto.domain.validator.delegate.input.InputErrorDelegator
import lotto.presentation.view.View
import lotto.presentation.vm.LottoViewModel

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

    private fun injectLottoViewModel(): LottoViewModel {
        val inputValidator = injectInputValidator()
        val calculator = injectCalculator()
        val lottoRepository = injectLottoRepository()
        return LottoViewModel(inputValidator, calculator, lottoRepository)
    }

    private fun injectLottoRepository(): LottoRepositoryImpl {
        val lottoDataSource = injectLottoDataSource()
        return LottoRepositoryImpl(lottoDataSource)
    }

    fun injectLottoDataSource(): LottoDataSource = LottoDataSourceImpl()
    private fun injectCalculator(): Calculate = Calculator()
    private fun injectPrinter(): Printer = Printer()
    private fun injectCommonErrorDelegate(): CommonErrorDelegate = CommonErrorDelegator()
    private fun injectInputErrorDelegate(): InputErrorDelegate = InputErrorDelegator()
}