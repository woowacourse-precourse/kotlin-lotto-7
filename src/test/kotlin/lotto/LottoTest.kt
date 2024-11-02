package lotto

import lotto.data.Lotto
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 테스트가 통과하도록 프로덕션 코드 구현
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @DisplayName("로또 번호에 1 ~ 45 범위를 벗어난 번호가 있는 경우")
    @ParameterizedTest
    @MethodSource("rangeOfOutNumbers")
    fun lottoNumbersOutOfRange(numbers: List<Int>) {
        assertThrows<IllegalArgumentException> { Lotto(numbers) }
    }

    @DisplayName("로또 번호가 오름차순으로 정렬되어 있지 않은 경우")
    @ParameterizedTest
    @MethodSource("sortOfNotNumbers")
    fun lottoNumbersNotSort(numbers: List<Int>) {
        assertThrows<IllegalArgumentException> { Lotto(numbers) }
    }

    companion object {
        @JvmStatic
        fun rangeOfOutNumbers(): Stream<List<Int>> = Stream.of(
            listOf(0, 5, 10, 15, 20, 25),
            listOf(1, 5, 10, 15, 20, 46),
            listOf(-1, 5, 10, 15, 20, 25)
        )

        @JvmStatic
        fun sortOfNotNumbers(): Stream<List<Int>> = Stream.of(
            listOf(1, 2, 3, 4, 6, 5),
            listOf(45, 40, 35, 30, 20, 10),
            listOf(41, 10, 43, 21, 35, 26)
        )
    }
}
