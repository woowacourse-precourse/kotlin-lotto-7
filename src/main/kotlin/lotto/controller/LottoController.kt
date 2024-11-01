package lotto.controller

import lotto.model.Lotto
import lotto.utils.Constants.LOTTO_PRICE
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
        // TODO: purchaseAmount 예외처리 위치 변경하기

        val purchaseCount = getPurchaseCount(purchaseAmount)
        outputView.showPurchasedLottoCount(purchaseCount)

        // 구매한 만큼 로또 번호 출력
        val LottoList = Lotto.generate()
        println(LottoList)

        getWinningNumbers()

        // 당첨 번호에 대한 예외 처리

        val bonusNumber = inputView.getBonusNumber()
        // 보너스 번호에 대한 예외 처리

        // 당첨 통계 출력
        outputView.showWinningStatisticsMessage()

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
                println(e.message)
            }
        }
    }

    fun iteration(count: Int) = repeat(count) { Lotto.generate() }

//    fun addLottoTicket(tickets: List<Int>) = tickets.add????

    fun getPurchaseCount(purchaseAmount: Int): Int = purchaseAmount / LOTTO_PRICE
}