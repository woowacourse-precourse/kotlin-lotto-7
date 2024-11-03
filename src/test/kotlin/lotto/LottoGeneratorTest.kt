package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoGeneratorTest {
    private val lottoWinningResultCalculator = LottoWinningResultCalculator()
    private val profitRateCalculator = ProfitRateCalculator()
    private val inputView = InputView()
    private val inputValidator = InputValidator()
    private val inputController = InputController(inputView = inputView, inputValidator = inputValidator)
    private val outputView = OutputView()
    private val lottoGenerator = LottoGenerator()
    val lottoController = LottoController(
        lottoWinningResultCalculator = lottoWinningResultCalculator,
        profitRateCalculator = profitRateCalculator,
        inputController = inputController,
        outputView = outputView,
        lottoGenerator = lottoGenerator
    )

    @Test
    fun 입력_5000원일_때_로또_5장_발행() {
        val input = 5000
        val lottos = lottoController.generateLottos(input)
        assertEquals(5, lottos.size)
    }
}