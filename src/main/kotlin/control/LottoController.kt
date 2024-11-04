package control

import data.Bonus
import data.Lotto
import data.RandomLotto

class LottoController {

    fun play() {
        val randomLotto = RandomLotto(PurchaseAmountValidator().validate())
        val winningNumber = Lotto(WinningNumberValidator().validate())
        val bonusNumber = Bonus(BonusNumberValidator().validate(winningNumber))

        LottoAnalyzer().analyze(
            randomLotto.read,
            winningNumber.read,
            bonusNumber.read
        )
    }
}