package lotto

import org.assertj.core.util.Objects
import org.junit.jupiter.api.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource

class LottoTest {

    @Test
    fun `로또 발행 오류 테스트`() {
        assertDoesNotThrow {
            for (i in 1 until 10000) {
                Lotto(getLotto())
            }
        }
    }

    @Test
    fun `로또 판별 테스트`() {
        assertDoesNotThrow {
            var expected = Price.FIRST
            var winningLotto = listOf(1,2,3,4,5,6)
            var actual = Lotto(winningLotto).determineWith(mutableListOf(1,2,3,4,5,6), 7)
            require(actual==expected)

            expected = Price.SECOND
            winningLotto = listOf(1,2,3,4,5,7)
            actual = Lotto(winningLotto).determineWith(mutableListOf(1,2,3,4,5,6), 7)
            require(actual==expected)

            expected = Price.THIRD
            winningLotto = listOf(1,2,3,4,5,15)
            actual = Lotto(winningLotto).determineWith(mutableListOf(1,2,3,4,5,6), 7)
            require(actual==expected)

            expected = Price.FOURTH
            winningLotto = listOf(11,2,3,4,5,15)
            actual = Lotto(winningLotto).determineWith(mutableListOf(1,2,3,4,5,6), 7)
            require(actual==expected)

            expected = Price.FIFTH
            winningLotto = listOf(11,2,3,4,25,15)
            actual = Lotto(winningLotto).determineWith(mutableListOf(1,2,3,4,5,6), 7)
            require(actual==expected)
        }
    }

    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호 중 하나라도 1부터 45까지의 범위를 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(-1, 46, 0, -1, 5, 6, 7))
        }
    }

    // TODO: 테스트가 통과하도록 프로덕션 코드 구현
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

}
