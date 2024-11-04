package lotto.controller

import lotto.model.LottoCalculator
import lotto.model.Lottos
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {

    fun run() {
        val lottoPrice = InputView.inputLottoPrice()
        val lottos = Lottos()
        lottos.buyLottos(lottoPrice) //구매한 로또들 생성

        val winningNumbers = InputView.inputWinningNumbers() // 당첨 번호를 입력
        val bonusNumber = InputView.inputBonusNumber(winningNumbers) // 보너스 번호를 입력

        OutputView.printLottoNumbers(lottos.getLottos().map { it.get() })  // 구매한 로또들 출력

        val result = LottoCalculator.calculate(lottos, winningNumbers, bonusNumber) //로또 시뮬레이션
        OutputView.printLottoResult(result)   // 당첨 통계 출력

        val profitRate = LottoCalculator.calculateProfitRate(result)     // 수익률 계산
        OutputView.printProfitRate(profitRate) // 수익률 출력
    }
}