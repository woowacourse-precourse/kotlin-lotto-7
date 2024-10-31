package lotto.validator

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PurchaseAmountValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = arrayOf("10a", "ㄱ", "o"))
    fun `숫자가 아닌 문자가 존재하는 경우 예외를 발생시킨다`(input: String) {
        // given
        val expected = "[ERROR] 숫자가 아닌 문자가 존재합니다."

        // when && then
        assertThatRuntimeException().isThrownBy {
            PurchaseAmountValidator.validate(input)
        }.withMessage(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = arrayOf("1010", "999", "100100"))
    fun `구입 금액이 1,000원 단위가 아닌 경우 예외를 발생시킨다`(input: String) {
        // given
        val expected = "[ERROR] 로또 구입 금액은 1,000원 단위로 입력 가능합니다."

        // when && then
        assertThatRuntimeException().isThrownBy {
            PurchaseAmountValidator.validate(input)
        }.withMessage(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = arrayOf("0", "-1000", "101000"))
    fun `구입 금액이 1,000원 ~ 100,000원 범위를 벗어날 경우 예외를 발생시킨다`(input: String) {
        // given
        val expected = "[ERROR] 로또 구입 금액은 1,000원 ~ 100,000원 범위내에서 구입할 수 있습니다."

        // when && then
        assertThatRuntimeException().isThrownBy {
            PurchaseAmountValidator.validate(input)
        }.withMessage(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = arrayOf("1000", "100000", "55000"))
    fun `구입 금액이 모든 조건을 만족할 경우 예외를 반환하지 않는다`(input: String) {
        assertThatNoException().isThrownBy {
            PurchaseAmountValidator.validate(input)
        }
    }

}
