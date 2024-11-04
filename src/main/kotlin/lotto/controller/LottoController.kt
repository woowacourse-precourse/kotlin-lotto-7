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
        return inputView.runWithValidation(
            receiveInput = { inputView.receivePurchaseAmount() },
            validateAndSet = { rawAmount ->
                PurchaseAmount().apply { setPurchaseAmount(rawAmount) }
            },
            onError = { errorMessage -> outputView.printExceptionMessage(errorMessage) }
        )
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
        return inputView.runWithValidation(
            receiveInput = { inputView.receiveWinningNumbers() },
            validateAndSet = { rawNumber ->
                WinningNumber().apply { setWinningNumbers(rawNumber) }
            },
            onError = { errorMessage -> outputView.printExceptionMessage(errorMessage) }
        )
    }

    private fun receiveBonusNumber(winningNumbers: List<Int>): BonusNumber {
        return inputView.runWithValidation(
            receiveInput = { inputView.receiveBonusNumber() },
            validateAndSet = { rawBonus ->
                BonusNumber().apply { setBonusNumber(rawBonus, winningNumbers) }
            },
            onError = { errorMessage -> outputView.printExceptionMessage(errorMessage) }
        )
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

    private fun <T> InputView.runWithValidation(
        receiveInput: () -> String,
        validateAndSet: (String) -> T,
        onError: (String) -> Unit
    ): T {
        while (true) {
            try {
                val rawInput = receiveInput()
                validateInputIsNotEmpty(rawInput)
                return validateAndSet(rawInput)
            } catch (e: IllegalArgumentException) {
                onError(e.message ?: "")
            }
        }
    }
}