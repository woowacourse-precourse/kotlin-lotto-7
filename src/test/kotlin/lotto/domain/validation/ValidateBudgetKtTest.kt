package lotto.domain.validation

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class ValidateBudgetKtTest {
    @Test
    fun `1000원으로 나누어 떨어지는 금액 검증시 아무 일도 일어나지 않음`() {
        // act, assert
        assertDoesNotThrow { validateBudget(VALID_BUDGET) }
    }

    @Test
    fun `1000원으로 나누어 떨어지지 않는 금액 검증시 예외 발생`() {
        // act, assert
        assertThrows<IllegalArgumentException> { validateBudget(INVALID_BUDGET) }
    }

    @Test
    fun `구입 금액으로 음수를 입력시 예외 발생`() {
        // act, assert
        assertThrows<IllegalArgumentException> { validateBudget(NEGATIVE_BUDGET) }
    }

    @Test
    fun `구입 금액으로 0을 입력시 예외 발생`() {
        // act, assert
        assertThrows<IllegalArgumentException> { validateBudget(ZERO_BUDGET) }
    }

    companion object {
        private const val VALID_BUDGET = 7_000
        private const val INVALID_BUDGET = 7_001
        private const val NEGATIVE_BUDGET = -2_000
        private const val ZERO_BUDGET = 0
    }
}
