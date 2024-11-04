package lotto.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MoneyTest {
    @Test
    @DisplayName("구매 금액이 최소 금액보다 적은 경우 예외가 발생한다.")
    fun amount_below_minimum_test() {
        assertThrows<IllegalArgumentException> {
            Money(999)
        }
    }

    @Test
    @DisplayName("구매 금액의 단위가 일치하지 않은 경우 예외가 발생한다.")
    fun amount_unit_test() {
        assertThrows<IllegalArgumentException> {
            Money(1001)
        }
    }

    @Test
    @DisplayName("구매 개수는 구매 금액을 로또 금액으로 나눈 것과 일치한다.")
    fun lotto_count_test() {
        val money = Money(5000)
        assertEquals(5000 / Money.LOTTO_PRICE, money.getLottoCount())
    }
}
