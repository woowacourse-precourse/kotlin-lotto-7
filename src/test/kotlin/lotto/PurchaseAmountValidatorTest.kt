package lotto

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PurchaseAmountValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = [""])
    @DisplayName("로또 구입 금액 - 빈 문자")
    fun `로또 구입 금액에 빈 문자열이 들어오면 예외가 발생한다`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
             PurchaseAmountValidator(purchaseAmount = input).validatePurchaseAmount()
        }

        assert(exception.message == PurchaseAmountErrorType.EMPTY_INPUT.errorMessage)
    }

    @ParameterizedTest
    @ValueSource(strings = ["3.524", "55.61"])
    @DisplayName("로또 구입 금액 - 소수")
    fun `로또 구입 금액에 소수가 들어오면 예외가 발생한다`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            PurchaseAmountValidator(purchaseAmount = input).validatePurchaseAmount()
        }

        assert(exception.message == PurchaseAmountErrorType.NOT_DECIMAL.errorMessage)
    }

    @ParameterizedTest
    @ValueSource(strings = ["829034589023485902348-5-0923458-9023485609-243-5809-234", "!", "가나다라마", "7589403257609348765819034579082347589023475098234758902347509823475"])
    @DisplayName("로또 구입 금액 - 정수가 아닌 것")
    fun `로또 구입 금액에 정수가 아닌 것이 들어오면 예외가 발생한다`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            PurchaseAmountValidator(purchaseAmount = input).validatePurchaseAmount()
        }

        assert(exception.message == PurchaseAmountErrorType.NOT_INTEGER.errorMessage)
    }

    @ParameterizedTest
    @ValueSource(strings = ["0"])
    @DisplayName("로또 구입 금액 - 0")
    fun `로또 구입 금액에 0이 들어오면 예외가 발생한다`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            PurchaseAmountValidator(purchaseAmount = input).validatePurchaseAmount()
        }

        assert(exception.message == PurchaseAmountErrorType.ZERO_AMOUNT.errorMessage)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-151301", "987", "999"])
    @DisplayName("로또 구입 금액 - 1000원미만")
    fun `로또 구입 금액에 1000원 미만이 들어오면 예외가 발생한다`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            PurchaseAmountValidator(purchaseAmount = input).validatePurchaseAmount()
        }

        assert(exception.message == PurchaseAmountErrorType.LESS_THAN_1000.errorMessage)
    }

    @ParameterizedTest
    @ValueSource(strings = ["151301", "1987", "9999"])
    @DisplayName("로또 구입 금액 - 1000원 단위")
    fun `로또 구입 금액에 1000원 단위가 아닌 것이 들어오면 예외가 발생한다`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            PurchaseAmountValidator(purchaseAmount = input).validatePurchaseAmount()
        }

        assert(exception.message == PurchaseAmountErrorType.NOT_UNITS_OF_1000.errorMessage)
    }
}