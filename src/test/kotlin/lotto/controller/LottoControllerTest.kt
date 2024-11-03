package lotto.controller

import lotto.model.LottoCalculator
import lotto.model.LottoMachine
import lotto.model.LottoResult
import lotto.model.Rank
import lotto.util.InputValidator
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.within
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoControllerTest {

    private lateinit var controller: LottoController
    private lateinit var validator: InputValidator
    private lateinit var lottoMachine: LottoMachine
    private lateinit var lottoResult: LottoResult
    private lateinit var lottoCalculator: LottoCalculator

    @BeforeEach
    fun setUp() {
        validator = InputValidator()
        lottoMachine = LottoMachine()
        lottoResult = LottoResult()
        lottoCalculator = LottoCalculator()
        controller = LottoController()
    }

    @Test
    fun `구입 금액이 1000원 단위로 올바르게 계산되는지 테스트`() {
        val price = validator.validatePurchasePrice("3000")
        assertThat(price).isEqualTo(3000)
    }

    @Test
    fun `구입 금액이 유효하지 않으면 null을 반환한다`() {
        val invalidPrice = validator.validatePurchasePrice("1500")
        assertThat(invalidPrice).isNull()
    }

    @Test
    fun `로또 티켓이 지정된 수량만큼 생성된다`() {
        val lottoTickets = lottoMachine.generateLottoTickets(3)
        assertThat(lottoTickets).hasSize(3)
    }

    @Test
    fun `당첨 번호가 유효하지 않으면 null을 반환한다`() {
        val invalidNumbers = validator.validateWinningNumbers("1, 2, 3, 4, 5")
        assertThat(invalidNumbers).isNull()
    }

    @Test
    fun `당첨 번호가 유효하면 숫자 리스트를 반환한다`() {
        val winningNumbers = validator.validateWinningNumbers("1, 2, 3, 4, 5, 6")
        assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `보너스 번호가 유효하지 않으면 null을 반환한다`() {
        val invalidBonus = validator.validateBonusNumber("0", listOf(1, 2, 3, 4, 5, 6))
        assertThat(invalidBonus).isNull()
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복되면 null을 반환한다`() {
        val duplicateBonus = validator.validateBonusNumber("5", listOf(1, 2, 3, 4, 5, 6))
        assertThat(duplicateBonus).isNull()
    }

    @Test
    fun `로또 결과에서 수익률을 올바르게 계산한다`() {
        val results = mapOf(Rank.FIRST to 1, Rank.FIFTH to 2)
        val purchasePrice = 3000
        val calculatedProfitRate = lottoCalculator.calculateProfitRate(results, purchasePrice).toDouble()

        assertThat(calculatedProfitRate).isCloseTo(66666666.7, within(1000.0))
    }
}