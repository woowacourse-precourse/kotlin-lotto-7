package lotto.controller

import lotto.model.*
import lotto.util.InputValidator.validateInputIsNotEmpty
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
    private val lottoMachine: LottoMachine = LottoMachine()
) {
    fun run() {
        val purchaseAmount = receivePurchaseAmount()
        val lottos = purchaseLotto(purchaseAmount)
        displayLottoInformation(lottos)

        val winningInfo = receiveWinningInformation()
        val lottoResults = determineLottoRanks(lottos, winningInfo)

        displayLottoResults(lottoResults, purchaseAmount)
    }

    private fun displayLottoInformation(lottos: List<Lotto>) {
        outputView.printPurchasedLottoCount(lottos.size)
        outputView.printPurchasedLottoNumbers(lottos.map { it.getLottoNumbers() })
    }

    private fun displayLottoResults(
        lottoResults: List<LottoRank>,
        purchaseAmount: PurchaseAmount
    ) {
        val winningRecord = createWinningRecord(lottoResults)
        outputView.printLottoResult(winningRecord)

        val profitRate = calculateProfitRate(lottoResults, purchaseAmount.getPurchaseAmount())
        outputView.printProfitRate(profitRate)
    }

    private fun receivePurchaseAmount(): PurchaseAmount {
        while (true) {
            try {
                val rawPurchaseAmount = inputView.receivePurchaseAmount()
                validateInputIsNotEmpty(rawPurchaseAmount)
                return PurchaseAmount().apply {
                    setPurchaseAmount(rawPurchaseAmount)
                }
            } catch (e: IllegalArgumentException) {
                outputView.printExceptionMessage(e.message ?: "")
            }
        }
    }

    private fun purchaseLotto(purchaseAmount: PurchaseAmount): List<Lotto> {
        return lottoMachine.issueLottos(purchaseAmount.getPurchaseAmount())
    }

    private fun receiveWinningInformation(): WinningInformation {
        val winningNumber = receiveWinningNumber()
        val bonusNumber = receiveBonusNumber(winningNumber.getWinningNumbers())
        return WinningInformation(winningNumber, bonusNumber)
    }

    private fun receiveWinningNumber(): WinningNumber {
        while (true) {
            try {
                val rawWinningNumber = inputView.receiveWinningNumbers()
                validateInputIsNotEmpty(rawWinningNumber)
                return WinningNumber().apply {
                    setWinningNumbers(rawWinningNumber)
                }
            } catch (e: IllegalArgumentException) {
                outputView.printExceptionMessage(e.message ?: "")
            }
        }
    }

    private fun receiveBonusNumber(winningNumbers: List<Int>): BonusNumber {
        while (true) {
            try {
                val rawBonusNumber = inputView.receiveBonusNumber()
                validateInputIsNotEmpty(rawBonusNumber)
                return BonusNumber().apply {
                    setBonusNumber(rawBonusNumber, winningNumbers)
                }
            } catch (e: IllegalArgumentException) {
                outputView.printExceptionMessage(e.message ?: "")
            }
        }
    }

    private fun determineLottoRanks(
        lottos: List<Lotto>,
        winningInfo: WinningInformation
    ): List<LottoRank> {
        return lottoMachine.determineLottoRanks(
            lottos,
            winningInfo.winningNumber.getWinningNumbers(),
            winningInfo.bonusNumber.getBonusNumber()
        )
    }

    private fun createWinningRecord(lottoResults: List<LottoRank>): List<Int> {
        return WinningRecord().createRecord(lottoResults)
    }

    private fun calculateProfitRate(
        lottoResults: List<LottoRank>,
        purchaseAmount: Int
    ): Double {
        return WinningRecord().calculatorProfitRate(lottoResults, purchaseAmount)
    }
}