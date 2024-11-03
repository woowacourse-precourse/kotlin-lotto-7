package controller

import model.Lotto
import model.LottoMachine
import model.WinningLotto
import view.InputView
import view.OutputView

/* LottoController 설계
* 1. 구입 금액 입력
* 2. 구매 개수 출력
* 3. 로또 번호 생성
* 4. 로또 번호 출력
* 5. 당첨 번호 입력
* 6. 보너스 번호 입력
* 7. 당첨 통계 계산
* 8. 당첨 결과 출력
*
* */
class LottoController {

    fun playLottoGame() {
        val money = InputView.getMoney()
        val lottoCount = money / DECIMAL

        val lottoes = LottoMachine.issueLottoes(lottoCount)

        OutputView.printLotto(lottoCount, lottoes)

        val winningLotto = getWinningLotto()

    }

    private fun getWinningLotto(): WinningLotto {
        val winningNumbers = InputView.getWinningNumbers()

        val bonusNumber = InputView.getBonusNumber(winningNumbers)

        return WinningLotto(
            Lotto(winningNumbers), bonusNumber)
    }


    companion object {
        const val DECIMAL = 1000
    }

}