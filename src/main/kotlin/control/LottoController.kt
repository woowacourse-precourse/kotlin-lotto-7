package control

import lotto.*
import view.Output

class LottoController {

    private var amount = 0
    private lateinit var winningNumber: List<Int>
    private var bonusNumber = 0
    private lateinit var randomLottoNumber: List<List<Int>>

    fun play() {
        input(true)
        control(true)
        output(true)
        input(false)
        control(false)
        output(false)
    }

    private fun input(boolean: Boolean) {
        if (boolean) {
            amount = PurchaseAmountValidator().validate()
        }
        if (!boolean) {
            winningNumber = WinningNumberValidator().validate()
            bonusNumber = BonusNumberValidator().validate(this.winningNumber)
        }
    }

    private fun control(boolean: Boolean) {
        if (boolean) {
            randomLottoNumber = RandomLottoGenerator().lottoPurchase(this.amount)
        }
        if (!boolean) {
            LottoStatistic().confirmWinning(
                this.randomLottoNumber,
                this.winningNumber,
                this.bonusNumber
            )
        }
    }

    private fun output(boolean: Boolean) {
        if (boolean) {
            Output().lottoPurchase(this.amount)
            Output().randomLottoList(this.randomLottoNumber)
        }
        if (!boolean) {
            Output().winningStatistics(this.amount)
        }
    }
}