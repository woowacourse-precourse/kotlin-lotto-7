package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows


class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개이고 모두 유효한 범위 내에 있을 경우 아무 일도 일어나지 않음`() {
        // act, assert
        assertDoesNotThrow { Lotto(listOf(1, 2, 3, 4, 5, 6)) }
    }

    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        // act, assert
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호의 개수가 6개 미만일 경우 예외 발생`() {
        // act, assert
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        // act, assert
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `유효한 로또 번호 범위 외의 숫자가 존재할 경우 예외 발생`() {
        // act, assert
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `toString은 항상 오름차순의 로또 번호 문자열을 반환`() {
        // arrange
        val lotto = Lotto(listOf(6, 5, 4, 3, 2, 1))

        // act
        val result = lotto.toString()

        // assert
        val expectedResult = "[1, 2, 3, 4, 5, 6]"
        assertThat(result).isEqualTo(expectedResult)
    }
}
