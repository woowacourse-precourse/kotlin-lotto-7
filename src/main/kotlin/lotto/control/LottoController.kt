package lotto.control

import lotto.data.Bonus
import lotto.data.Lotto
import lotto.data.RandomLotto

class LottoController {

    fun play() {
        //구매 금액 입력 및 무작위 로또 출력
        val randomLotto = RandomLotto(PurchaseAmountValidator().validate())

        //당첨 번호 입력
        val winningNumber = Lotto(WinningNumberValidator().validate())

        //보너스 번호 입력
        val bonusNumber = Bonus(BonusNumberValidator().validate(winningNumber))

        // 당첨 통계 및 수익률 출력
        LottoAnalyzer().analyze(
            randomLotto.read,
            winningNumber.read,
            bonusNumber.read
        )
    }
}