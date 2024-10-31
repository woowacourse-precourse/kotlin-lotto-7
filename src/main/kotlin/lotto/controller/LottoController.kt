package lotto.controller

import lotto.view.InputView
import lotto.view.OutputView

/**
 * 컨트롤러는 모델과 뷰에 의존해도 된다.
 * 컨트롤러 내부에 모델과 뷰의 코드가 있을 수 있다.
 */

class LottoController {
    val inputView = InputView()
    val outputView = OutputView()

    fun start() {
        val purchaseAmount = inputView.getPurchaseAmount()

        val winningNumbers = inputView.getWinningNumbers()

        val bonusNumber = inputView.getBonusNumber()
    }
}