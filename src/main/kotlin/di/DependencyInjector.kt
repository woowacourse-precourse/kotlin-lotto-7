package di

import domain.validator.delegate.common.CommonErrorDelegate
import domain.validator.delegate.common.CommonErrorDelegator
import domain.validator.delegate.input.InputErrorDelegate
import domain.validator.delegate.input.InputErrorDelegator
import domain.validator.InputValidator
import view.MainView
import vm.LottoViewModel
import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange
import datasource.LottoDataSource
import domain.calculator.Calculate
import domain.calculator.Calculator
import domain.enums.LottoSetting.LOTTO_SIZE
import domain.enums.LottoSetting.LOTTO_MAX
import domain.enums.LottoSetting.LOTTO_MIN
import domain.validator.InputValidate
import view.InputView
import view.OutputView
import java.util.TreeSet

class DependencyInjector {

    fun injectView() {
        val viewModel = injectLottoViewModel()
        val inputView = injectInputView()
        val outputView = injectOutPutView()
        MainView(inputView, outputView, viewModel)
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
    private fun injectInputView(): InputView = InputView()
    private fun injectOutPutView(): OutputView = OutputView()
    private fun injectCommonErrorDelegate(): CommonErrorDelegate = CommonErrorDelegator()
    private fun injectInputErrorDelegate(): InputErrorDelegate = InputErrorDelegator()
}