package lotto

class LottoController(
    private val lottoWinningResultCalculator: LottoWinningResultCalculator,
    private val profitRateCalculator: ProfitRateCalculator,
    private val inputController: InputController,
    private val outputView: OutputView,
    val lottoGenerator: LottoGenerator
) {
    fun run() {
        val purchaseAmount = inputController.getValidPurchaseAmount()
        val purchasedLottos = generateAndPrintLottos(purchaseAmount)
        val winningNumbers = inputController.getValidWinningNumbers()
        val bonusNumber = inputController.getValidBonusNumber(winningNumbers)

        calculateAndPrintResults(
            purchasedLottos = purchasedLottos,
            purchaseAmount = purchaseAmount,
            winningNumbers = winningNumbers,
            bonusNumber = bonusNumber
        )

    }

    fun generateAndPrintLottos(purchaseAmount: Int): List<Lotto> {
        // 구입 금액에 맞춰 로또를 생성
        val purchasedLottos = generateLottos(purchaseAmount)

        //결과 출력
        outputView.printLottoNumbers(purchasedLottos)
        return purchasedLottos
    }

    fun calculateAndPrintResults(
        purchasedLottos: List<Lotto>,
        purchaseAmount: Int,
        winningNumbers: List<Int>,
        bonusNumber: Int
    ) {
        // 로또 당첨 결과 및 수익률 계산
        val results = lottoWinningResultCalculator.calculateResults(purchasedLottos, winningNumbers, bonusNumber)
        val profitRate = profitRateCalculator.calculateProfitRate(results, purchaseAmount)

        // 결과 출력
        outputView.printResult(results, profitRate)
    }

    fun generateLottos(purchaseAmount: Int): List<Lotto> {
        val count = purchaseAmount / 1000
        return List(count) { Lotto(lottoGenerator.generateLotto()) }
    }
}