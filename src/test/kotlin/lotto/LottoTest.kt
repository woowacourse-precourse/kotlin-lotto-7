package lotto

import lotto.domain.lotto.BonusNumber
import lotto.domain.lotto.Lotto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `현재 로또와 매개변수로 들어온 당첨 로또번호와 보너스 번호를 비교한 정보를 갖는 객체를 반환한다`() {
        // given
        val currentLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningLotto = Lotto(listOf(1, 3, 5, 7, 9, 45))
        val bonusNumber = BonusNumber(6)
        val expectedCorrectCount = 3
        val expectedHasBonusNumber = true

        // when
        val actual = currentLotto.getMatchedInfo(winningLotto, bonusNumber)

        // then
        assertEquals(expectedCorrectCount, actual.correctCount)
        assertEquals(expectedHasBonusNumber, actual.isCorrectBonusNumber)
    }

    @ParameterizedTest
    @CsvSource(value = arrayOf("1,true", "2,true", "3,true", "10,false", "45,false"))
    fun `현재 로또 번호와 중복된 수가 있는지 판별한다`(number: Int, expected: Boolean) {
        // given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        // when
        val actual = lotto.isDuplicateNumber(number)

        // then
        assertSame(expected, actual)
    }

    @Test
    fun `로또는 번호가 정렬된 형태로 숫자를 반환한다`() {
        // given
        val lotto = Lotto(listOf(34, 5, 40, 10, 24, 17))
        val expected = "[5, 10, 17, 24, 34, 40]"

        // when
        val actual = lotto.toString()

        // then
        assertEquals(expected, actual)
    }

}
