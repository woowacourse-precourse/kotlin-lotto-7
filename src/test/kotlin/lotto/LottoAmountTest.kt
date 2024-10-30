package lotto

import lotto.data.LottoAmount
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("구입 금액 테스트 케이스")
class LottoAmountTest {
    @DisplayName("숫자가 아닌 다른 문자를 포함한 경우")
    @ParameterizedTest
    @ValueSource(strings = ["abcd", "1,000", "+35000", "-45000", "10000.0", "천원", "일만", "십억?"])
    fun amountContainsNonNumber(input: String) {
        assertThrows<IllegalArgumentException> { LottoAmount(input) }
    }

    @DisplayName("0으로 시작하는 경우")
    @ParameterizedTest
    @ValueSource(strings = ["001000", "01000", "02500"])
    fun amountStartZero(input: String) {
        assertThrows<IllegalArgumentException> { LottoAmount(input) }
    }

    @DisplayName("구입 금액을 입력하지 않은 경우")
    @ParameterizedTest
    @ValueSource(strings = ["\n", "\t"])
    @EmptySource
    fun amountEmpty(input: String) {
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