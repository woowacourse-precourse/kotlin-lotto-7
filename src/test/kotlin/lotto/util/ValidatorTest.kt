package lotto.util

import lotto.model.Lotto
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows

class ValidatorTest {

    private val validator = Validator()

    @Test
    fun `금액 입력이 유효할 때 예외가 발생하지 않는다`() {
        assertDoesNotThrow {
            validator.validateMoneyInput("1000")
            validator.validateMoneyInput("5000")
        }
    }

    @Test
    fun `금액 입력이 숫자가 아닐 때 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            validator.validateMoneyInput("abcd")
        }
        assertEquals("[ERROR] 입력은 숫자여야 합니다.", exception.message)
    }

    @Test
    fun `금액 입력이 천 단위가 아닐 때 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            validator.validateMoneyInput("1500")
        }
        assertEquals("[ERROR] 돈은 천 단위 숫자여야 합니다.", exception.message)
    }

    @Test
    fun `금액 입력이 0일 때 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            validator.validateMoneyInput("0")
        }
        assertEquals("[ERROR] 돈은 주셔야 합니다.", exception.message)
    }

    @Test
    fun `로또 당첨 번호 입력 형식이 올바르면 예외가 발생하지 않는다`() {
        assertDoesNotThrow {
            validator.validateWinningNumberInput("1,2,3,4,5,6")
        }
    }

    @Test
    fun `로또 당첨 번호 입력 형식이 올바르지 않으면 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            validator.validateWinningNumberInput("1,2,3,4,5")
        }
        assertEquals("[ERROR] 로또 입력 형식이 맞지 않습니다.", exception.message)
    }

    @Test
    fun `보너스 번호가 유효하면 예외가 발생하지 않는다`() {
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertDoesNotThrow {
            validator.validateBonusNumberInput("7", winningLotto)
        }
    }

    @Test
    fun `보너스 번호가 숫자가 아니면 예외가 발생한다`() {
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val exception = assertThrows<IllegalArgumentException> {
            validator.validateBonusNumberInput("a", winningLotto)
        }
        assertEquals("[ERROR] 입력은 숫자여야 합니다.", exception.message)
    }

    @Test
    fun `보너스 번호가 범위를 벗어나면 예외가 발생한다`() {
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val exception = assertThrows<IllegalArgumentException> {
            validator.validateBonusNumberInput("46", winningLotto)
        }
        assertEquals("[ERROR] 로또 번호의 범위는 1 ~ 45 입니다.", exception.message)
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복되면 예외가 발생한다`() {
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val exception = assertThrows<IllegalArgumentException> {
            validator.validateBonusNumberInput("3", winningLotto)
        }
        assertEquals("[ERROR] 로또 번호와 중복됩니다.", exception.message)
    }
}