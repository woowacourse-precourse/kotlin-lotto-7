package lotto

import lotto.model.Lotto
import lotto.model.PurchaseMoney
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PurchaseMoneyTest {

    @ParameterizedTest
    @ValueSource(strings = ["$21", "오천원", "six", "@@@"])
    fun `구입 금액은 숫자로 입력받아야 한다`(moneyInput : String) {
        assertThrows<IllegalArgumentException> {
            PurchaseMoney(moneyInput)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["100", "200", "300"])
    fun `구입 금액은 1000원 이상이어야 한다`(moneyInput : String) {
        assertThrows<IllegalArgumentException> {
            PurchaseMoney(moneyInput)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1500", "2500", "3500"])
    fun `구입 금액은 1000원 단위이어야 한다`(moneyInput : String) {
        assertThrows<IllegalArgumentException> {
            PurchaseMoney(moneyInput)
        }
    }
}