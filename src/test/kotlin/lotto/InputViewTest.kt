package lotto

import lotto.utils.PurchaseAmount
import lotto.view.InputView
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class InputViewTest {

    private val inputView = InputView()

    @Test
    fun `구입 금액이 1000원 단위로 입력되면 성공`() {
        val amount = 5000
        assertDoesNotThrow {
            inputView.validatePurchaseAmount(amount)
        }
    }

    @Test
    fun `구입 금액이 1000원 단위가 아니면 예외 발생`() {
        val amount = 5500
        assertThrows<IllegalArgumentException> {
            inputView.validatePurchaseAmount(amount)
        }
    }

    @Test
    fun `구입 금액이 최소 금액보다 작으면 예외 발생`() {
        val amount = PurchaseAmount.MIN_PURCHASE_AMOUNT.value - 1000
        assertThrows<IllegalArgumentException> {
            inputView.validatePurchaseAmount(amount)
        }
    }

    @Test
    fun `구입 금액이 최대 금액보다 크면 예외 발생`() {
        val amount = PurchaseAmount.MAX_PURCHASE_AMOUNT.value + 1000
        assertThrows<IllegalArgumentException> {
            inputView.validatePurchaseAmount(amount)
        }
    }

    @Test
    fun `올바른 당첨 번호 입력 시 성공`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        assertDoesNotThrow {
            inputView.validateWinningNumbers(winningNumbers)
        }
    }

    @Test
    fun `당첨 번호 개수가 부족할 때 예외 발생`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5)
        assertThrows<IllegalArgumentException> {
            inputView.validateWinningNumbers(winningNumbers)
        }
    }

    @Test
    fun `당첨 번호가 유효한 범위를 벗어날 때 예외 발생`() {
        val winningNumbers = listOf(0, 2, 3, 4, 5, 6)
        assertThrows<IllegalArgumentException> {
            inputView.validateWinningNumbers(winningNumbers)
        }
    }

    @Test
    fun `당첨 번호에 중복된 번호가 포함되면 예외 발생`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 5)
        assertThrows<IllegalArgumentException> {
            inputView.validateWinningNumbers(winningNumbers)
        }
    }

    @Test
    fun `올바른 보너스 번호가 입력될 때 성공`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        assertDoesNotThrow {
            inputView.validateBonusNumber(bonusNumber, winningNumbers)
        }
    }

    @Test
    fun `보너스 번호가 유효한 범위를 벗어날 때 예외 발생`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 46
        assertThrows<IllegalArgumentException> {
            inputView.validateBonusNumber(bonusNumber, winningNumbers)
        }
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복될 때 예외 발생`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 6
        assertThrows<IllegalArgumentException> {
            inputView.validateBonusNumber(bonusNumber, winningNumbers)
        }
    }
}