package lotto

fun main() {
    val inputView = InputView()
    val inputValidator = InputValidator()
    val inputController = InputController(inputView = inputView, inputValidator = inputValidator)
    val outputView = OutputView()
    val lottoGenerator = LottoGenerator()
    val lottoWinningResultCalculator = LottoWinningResultCalculator()
    val profitRateCalculator = ProfitRateCalculator()
    val lottoController = LottoController(
        inputController = inputController,
        lottoWinningResultCalculator = lottoWinningResultCalculator,
        profitRateCalculator = profitRateCalculator,
        outputView = outputView,
        lottoGenerator = lottoGenerator
    )
    lottoController.run()
}
