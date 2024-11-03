package lotto

class LottoController(
    private val lottoWinningResultCalculator: LottoWinningResultCalculator,
    private val profitRateCalculator: ProfitRateCalculator,
    private val inputController: InputController,
    private val outputView: OutputView,
    val lottoGenerator: LottoGenerator
) {
    fun run() {
        // 유효한 구입 금액 입력 받기
        val purchaseAmount = inputController.getValidPurchaseAmount()

        // 구입 금액에 맞춰 로또를 생성
        val purchasedLottos = generateLottos(purchaseAmount)
        outputView.printLottoNumbers(purchasedLottos)

        // 유효한 당첨 번호 및 보너스 번호 입력 받기
        val winningNumbers = inputController.getValidWinningNumbers()
        val bonusNumber = inputController.getValidBonusNumber(winningNumbers)

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