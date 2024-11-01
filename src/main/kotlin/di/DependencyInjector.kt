package di

import delegate.common.CommonErrorDelegate
import delegate.common.CommonErrorDelegator
import delegate.input.InputErrorDelegate
import delegate.input.InputErrorDelegator
import domain.validator.InputValidator
import sam.LottoFactory
import view.MainView
import vm.LottoViewModel
import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange
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

    fun injectLottoFactory(): LottoFactory = LottoFactory {
        TreeSet(
            pickUniqueNumbersInRange(
                LOTTO_MIN.value(),
                LOTTO_MAX.value(),
                LOTTO_SIZE.value()
            )
        )
    }

    private fun injectLottoViewModel(): LottoViewModel {
        return LottoViewModel(injectInputValidator(), injectLottoFactory())
    }
    private fun injectInputView(): InputView = InputView()
    private fun injectOutPutView(): OutputView = OutputView()
    private fun injectCommonErrorDelegate(): CommonErrorDelegate = CommonErrorDelegator()
    private fun injectInputErrorDelegate(): InputErrorDelegate = InputErrorDelegator()
}