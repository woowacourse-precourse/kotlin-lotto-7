package control

import data.Bonus
import data.Lotto
import data.RandomLotto

class LottoController {
    fun play() {
        val randomLotto = RandomLotto(PurchaseAmountValidater().validate())
        val winningNumber = Lotto(WinningNumberValidater().validate())
        val bonusNumber = Bonus(BonusNumberValidater().validate(winningNumber))

        LottoAnalyzer().analyze(
            randomLotto.read,
            winningNumber.read,
            bonusNumber.read
        )
    }
}