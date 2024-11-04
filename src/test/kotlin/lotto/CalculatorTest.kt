package lotto

import lotto.domain.calculator.Calculate
import lotto.domain.calculator.Calculator
import lotto.domain.enums.Rank
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class CalculatorTest {
    private lateinit var calculate: Calculate

    @BeforeEach
    fun setUp() {
        calculate = Calculator()
    }

    @ParameterizedTest
    @MethodSource("로또_당첨_금액_계산_테스트_데이터")
    fun `로또 당첨 금액 계산 테스트`(입력값: Map<Rank, Int>, 예측값: String) {
        // when
        val actual = calculate.calculateWinningMoney(입력값)

        // then
        assertEquals(예측값, actual.toString())
    }

    @ParameterizedTest
    @MethodSource("로또_수익률_계산_테스트_데이터")
    fun `로또 수익률 계산 테스트`(당첨금: Long, 구매한_로또_수: Int, 예측값: String) {
        // when
        val actual = calculate.calculateRateOfReturn(
            winningMoney = 당첨금, purchaseLottoCount = 구매한_로또_수
        )

        // then
        assertEquals(예측값, actual)
    }

    companion object {
        @JvmStatic
        fun `로또_당첨_금액_계산_테스트_데이터`() = listOf(
            Arguments.of(
                mapOf(
                    Rank.FIRST to 1,
                    Rank.SECOND to 1,
                    Rank.THIRD to 1,
                    Rank.FOURTH to 1,
                    Rank.FIFTH to 1,
                ),
                "2031555000"
            )
        )

        @JvmStatic
        fun `로또_수익률_계산_테스트_데이터`() = listOf(
            Arguments.of(5000L, 8, "62.5")
        )
    }
}