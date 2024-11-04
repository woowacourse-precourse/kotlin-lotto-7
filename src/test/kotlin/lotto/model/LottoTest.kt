package lotto.model

import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class LottoTest {
    private lateinit var lotto: Lotto

    @ParameterizedTest
    @MethodSource("provideNumbersTest")
    fun `6개의 번호가 아닌 경우 예외가 발생한다`(testNumbers: List<Int>) {
        assertThrows<IllegalArgumentException> {
            lotto = Lotto(testNumbers)
        }
    }

    @Test
    fun `중복된 숫자를 가질 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            val testNumbers = listOf(1,2,3,4,5,1)
            lotto = Lotto(testNumbers)
        }
    }

    companion object {
        @JvmStatic
        fun provideNumbersTest(): List<List<Int>> {
            return listOf(
                listOf(1,2,3,4,5),
                listOf(1,2,3,4,5,6,7)
            )
        }
    }
}