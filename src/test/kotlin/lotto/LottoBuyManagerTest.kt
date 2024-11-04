package lotto

import lotto.manager.LottoBuyManager
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoBuyManagerTest {

    private val lottoBuyManager = LottoBuyManager()

    @Test
    fun `구입 금액을 부호가 없는 숫자로 입력하지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            lottoBuyManager.validateMoneyInput("100j")
        }
    }

    @Test
    fun `구입 금액을 1000원 미만으로 입력하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            lottoBuyManager.validateMoneyInput("900")
        }
    }

    @Test
    fun `구입 금액을 1000원 단위로 입력하지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            lottoBuyManager.validateMoneyInput("1500")
        }
    }
}