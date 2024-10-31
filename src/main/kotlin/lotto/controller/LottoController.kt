package lotto.controller

import lotto.model.LottoGenerator
import lotto.view.InputView
import lotto.view.OutputView

/**
 * 컨트롤러는 모델과 뷰에 의존해도 된다.
 * 컨트롤러 내부에 모델과 뷰의 코드가 있을 수 있다.
 */

class LottoController {
    val inputView = InputView()
    val outputView = OutputView()
    val lottoGenerator = LottoGenerator()

    fun start() {
        val purchaseAmount = inputView.getPurchaseAmount() // 금액. 예외 처리 필요. / 1000한 값도 가져야 함
        // 구매 금액에 대한 예외 처리
        // 구매 갯수 출력
        // 구매한 만큼 로또 번호 출력
        val purchaseCount = purchaseAmount


        val winningNumbers = inputView.getWinningNumbers()
        // 당첨 번호에 대한 예외 처리

        val bonusNumber = inputView.getBonusNumber()
        // 보너스 번호에 대한 예외 처리

        // 당첨 통계 출력
        // 당첨 등급 출력
        // 수익률 출력
    }

    fun iteration(count: Int) = lottoGenerator.generate()
}