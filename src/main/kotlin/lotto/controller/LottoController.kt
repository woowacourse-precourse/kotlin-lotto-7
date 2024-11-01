package lotto.controller

import lotto.model.*
import lotto.util.InputValidator.validateInputIsNotEmpty
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
) {

    fun run() {
        val purchaseAmount = receivePurchaseAmount()
        val lottos = purchaseLotto(purchaseAmount)
        outputView.printPurchasedLottoCount(lottos.size)
        outputView.printPurchasedLottoNumbers(lottos.map { it.getLottoNumbers() })

        val winningNumber = receiveWinningNumber()
        val bonusNumber = receiveBonusNumber(winningNumber.getWinningNumbers())
    }

    private fun receivePurchaseAmount(): PurchaseAmount {
        while (true) {
            try {
                val rawPurchaseAmount = inputView.receivePurchaseAmount()
                validateInputIsNotEmpty(rawPurchaseAmount)

                val purchaseAmount = PurchaseAmount()
                purchaseAmount.setPurchaseAmount(rawPurchaseAmount)

                return purchaseAmount
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun purchaseLotto(purchaseAmount: PurchaseAmount): List<Lotto> {
        val lottoMachine = LottoMachine()
        val lottos = lottoMachine.issueLottos(purchaseAmount.getPurchaseAmount())

        return lottos
    }

    private fun receiveWinningNumber(): WinningNumber {
        while (true) {
            try {
                val rawWinningNumber = inputView.receiveWinningNumbers()
                validateInputIsNotEmpty(rawWinningNumber)

                val winningNumber = WinningNumber()
                winningNumber.setWinningNumbers(rawWinningNumber)

                return winningNumber
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun receiveBonusNumber(winningNumbers: List<Int>): BonusNumber {
        while (true) {
            try {
                val rawBonusNumber = inputView.receiveBonusNumber()
                validateInputIsNotEmpty(rawBonusNumber)

                val bonusNumber = BonusNumber()
                bonusNumber.setBonusNumber(rawBonusNumber, winningNumbers)

                return bonusNumber
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}