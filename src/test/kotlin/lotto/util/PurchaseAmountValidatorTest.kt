package lotto.util

import lotto.util.constant.ErrorMessages
import lotto.util.validator.PurchaseAmountValidator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PurchaseAmountValidatorTest {

    @Test
    fun `빈 값이 입력된 경우`() {
        val input = ""
        val exception = assertThrows<IllegalArgumentException> { PurchaseAmountValidator.validatePurchaseAmount(input) }

        assertThat(exception).hasMessage(ErrorMessages.AMOUNT_IS_NOT_EMPTY)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1million", "삼천원", "5.5", "8,000"])
    fun `숫자(정수)가 아닌 경우`(input: String) {
        val exception = assertThrows<IllegalArgumentException> { PurchaseAmountValidator.validatePurchaseAmount(input) }

        assertThat(exception).hasMessage(ErrorMessages.AMOUNT_IS_NUMERIC)
    }

    @ParameterizedTest
    @ValueSource(strings = ["10", "1", "-5", "1001"])
    fun `구입 금액이 천 단위가 아닐 경우`(input: String) {
        val exception = assertThrows<IllegalArgumentException> { PurchaseAmountValidator.validatePurchaseAmount(input) }

        assertThat(exception).hasMessage(ErrorMessages.AMOUNT_IS_MULTIPLE_OF_THOUSAND)
    }


    @ParameterizedTest
    @ValueSource(strings = ["-1000", "2000000000"])
    fun `금액 범위를 넘어간 경우`(input: String) {
        val exception = assertThrows<IllegalArgumentException> { PurchaseAmountValidator.validatePurchaseAmount(input) }

        assertThat(exception).hasMessage(ErrorMessages.OUT_OF_AMOUNT_RANGE)
    }
}