package lotto

import lotto.data.Client
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("구입 금액 테스트 케이스")
class ClientTest {
    @DisplayName("숫자가 아닌 다른 문자를 포함한 경우")
    @ParameterizedTest
    @ValueSource(strings = ["\n", "\t", "abcd", "1,000", "+35000", "-45000", "10000.0", "천원", "일만", "십억?"])
    fun amountContainsNonNumber(input: String) {
        val result = assertThrows<IllegalArgumentException> { Client(input) }
        assertEquals(result.message, "[ERROR] 숫자로만 입력해주세요.")
    }

    @DisplayName("0으로 시작하는 경우")
    @ParameterizedTest
    @ValueSource(strings = ["001000", "01000", "025000"])
    fun amountStartZero(input: String) {
        val result = assertThrows<IllegalArgumentException> { Client(input) }
        assertEquals(result.message, "[ERROR] 10000 과 같은 형태로 입력해주세요.")
    }

    @DisplayName("구입 금액을 입력하지 않은 경우")
    @ParameterizedTest
    @EmptySource
    fun amountEmpty(input: String) {
        val result = assertThrows<IllegalArgumentException> { Client(input) }
        assertEquals(result.message, "[ERROR] 구입 금액이 입력되지 않았습니다. 구입 금액을 입력해주세요.")
    }

    @DisplayName("구입 금액이 1,000원 단위가 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = ["1500", "3500", "12100", "99001"])
    fun amountUnit(input: String) {
        val result = assertThrows<IllegalArgumentException> { Client(input) }
        assertEquals(result.message, "[ERROR] 1,000원 단위로만 구매 가능합니다.")
    }

    @DisplayName("구매 할 수 있는 범위 내 금액이 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = ["0", "101000", "10000000000000000000000"])
    fun amountRange(input: String) {
        val result = assertThrows<IllegalArgumentException> { Client(input) }
        assertEquals(result.message, "[ERROR] 1,000원 ~ 100,000원 이내로만 구매 가능합니다.")
    }
}