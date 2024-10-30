package lotto

import lotto.data.LottoAmount
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("구입 금액 테스트 케이스")
class LottoAmountTest {
    @DisplayName("0으로 시작하지 않는 숫자로만 이루어진 문자열이 아닌 경우")
    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = ["abcd", "\n", "0123", "천원", "01000", "-10000", "+10000", "1,000", "99,000"])
    fun amountFormat(input: String) {
        assertThrows<IllegalArgumentException> { LottoAmount(input) }
    }

    @DisplayName("구입 금액이 1,000원 단위가 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = ["1500", "3500", "12100", "99001"])
    fun amountUnit(input: String) {
        assertThrows<IllegalArgumentException> { LottoAmount(input) }
    }

    @DisplayName("구매 할 수 있는 범위 내 금액이 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = ["0", "101000"])
    fun amountRange(input: String) {
        assertThrows<IllegalArgumentException> { LottoAmount(input) }
    }
}