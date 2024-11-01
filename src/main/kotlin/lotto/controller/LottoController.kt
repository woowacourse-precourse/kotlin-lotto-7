package lotto.controller

import lotto.model.Lotto
import lotto.utils.Constants.LOTTO_PRICE
import lotto.utils.Constants.NEW_LINE
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

        val purchaseLottoList = mutableListOf<List<Int>>()
        repeat(purchaseCount){ purchaseLottoList.add(Lotto.generate()) }
        println(purchaseLottoList.joinToString(NEW_LINE))

        val winningNumbers = getWinningNumbers()
        // TODO: 당첨 번호에 대한 예외 처리

        val bonusNumber = inputView.getBonusNumber()
        // TODO: 보너스 번호에 대한 예외 처리(당첨 번호 오류 + 당첨번호와 중복인지)


        // 당첨 등급 출력
        //outputView.showWinningStatistics()

        // 수익률 출력
        //outputView.showTotalReturnRate()
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

    fun getPurchaseCount(purchaseAmount: Int): Int = purchaseAmount / LOTTO_PRICE
}