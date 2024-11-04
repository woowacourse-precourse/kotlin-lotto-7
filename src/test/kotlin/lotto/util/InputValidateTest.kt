package lotto.util

import lotto.model.Lotto
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows

class InputValidateTest {

    @Test
    fun `checkPrice 돈을 안내면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputValidate.checkPrice("", null)
        }
    }

    @Test
    fun `checkPrice 문자를 입력하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputValidate.checkPrice("text", null)
        }
    }

    @Test
    fun `checkPrice 1000원보다 적은 돈을 내면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputValidate.checkPrice("900", 900)
        }
    }


    @Test
    fun `checkMyBonus 값을 입력하지 않으면 예외가 발생한다`() {
        val lotto = Lotto(listOf(1,2,3,4,5,6))
        assertThrows<IllegalArgumentException> {
            InputValidate.checkMyBonus("", null, lotto)
        }
    }

    @Test
    fun `checkMyBonus 문자를 입력하면 예외가 발생한다`() {
        val lotto = Lotto(listOf(1,2,3,4,5,6))
        assertThrows<IllegalArgumentException> {
            InputValidate.checkMyBonus("text", null, lotto)
        }
    }

    @Test
    fun `checkMyBonus 1과 45사이의 값이 아니면 예외가 발생한다`() {
        val lotto = Lotto(listOf(1,2,3,4,5,6))
        assertThrows<IllegalArgumentException> {
            InputValidate.checkMyBonus("900", 900, lotto)
        }
    }

    @Test
    fun `checkMyBonus 보너스 번호와 당첨번호가 겹치면 예외가 발생한다`() {
        val lotto = Lotto(listOf(1,2,3,4,5,6))
        assertThrows<IllegalArgumentException> {
            InputValidate.checkMyBonus("3", 3, lotto)
        }
    }
}