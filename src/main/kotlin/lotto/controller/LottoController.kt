package lotto.controller

import lotto.model.Lottos
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {

    fun run() {
        val lottoPrice = InputView.inputLottoPrice()
        //구매한 로또들 생성
        val lottos = Lottos()
        lottos.buyLottos(lottoPrice)

        //당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
        val winningNumbers = InputView.inputWinningNumbers()
        val bonusNumber = InputView.inputBonusNumber()

        //구매한 로또들 출력
        OutputView.printLottoNumbers(lottos.getLottos().map { it.get() })


    }
}