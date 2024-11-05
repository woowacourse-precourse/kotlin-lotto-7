package lotto

import lotto.util.ValidatorUtil
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoPriceTest {

    @Test
    fun `로또 구입 가격이 숫자로 변환할 수 없는 경우 예외가 발생한다`() {
        val lottoPrice = "1000j"
        assertThrows<IllegalArgumentException> {
            ValidatorUtil.validateTicketsPriceNumber(lottoPrice)
        }
    }

    @Test
    fun `로또 구입 가격이 1,000원 단위가 아닐 경우 예외가 발생한다`() {
        val lottoPrice = 2_600
        assertThrows<IllegalArgumentException> {
            ValidatorUtil.validateTicketsPrice(lottoPrice)
        }
    }

    @Test
    fun `로또 구입 가격이 0원일 경우 예외가 발생한다`() {
        val lottoPrice = 0
        assertThrows<IllegalArgumentException> {
            ValidatorUtil.validateTicketsPriceRange(lottoPrice)
        }
    }

    @Test
    fun `로또 구입 가격이 음수일 경우 예외가 발생한다`() {
        val lottoPrice = -1_000
        assertThrows<IllegalArgumentException> {
            ValidatorUtil.validateTicketsPriceRange(lottoPrice)
        }
    }
}