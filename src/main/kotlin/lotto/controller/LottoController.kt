package lotto.controller

import lotto.model.Lotto
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
        val purchaseAmount = inputView.getPurchaseAmount()

        // 구매 금액에 대한 예외 처리 -> 예외 처리는 모델에서?
        // 입력 값이 잘못되면 다시 받아야 하니 input에서 -> 함수 처리해서 모델에서?

        // 구매 갯수 출력
        val purchaseCount = getPurchaseCount(purchaseAmount)
        iteration(purchaseCount)

        // 구매한 만큼 로또 번호 출력

        getWinningNumbers()

        // 당첨 번호에 대한 예외 처리

        val bonusNumber = inputView.getBonusNumber()
        // 보너스 번호에 대한 예외 처리

        // 당첨 통계 출력
        // 당첨 등급 출력
        // 수익률 출력
    }

    private fun getWinningNumbers(): List<Int> {
        while (true) {
            try {
                val winningNumbers = inputView.getWinningNumbers()
                Lotto(winningNumbers)
                return winningNumbers
            } catch (e: IllegalArgumentException) {
                println("${e.message}")
            }
        }
    }

    fun iteration(count: Int) = repeat(count) { lottoGenerator.generate() }

    fun getPurchaseCount(purchaseAmount: Int): Int = purchaseAmount / 1000
}