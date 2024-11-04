package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoTest {
    @Nested
    @DisplayName("로또 번호 유효성 검증")
    inner class LottoValidation {
        @Test
        fun `로또 번호는 6개여야 한다`() {
            assertThrows<IllegalArgumentException> {
                Lotto(listOf(1, 2, 3, 4, 5))
            }
        }

        @Test
        fun `로또 번호는 중복될 수 없다`() {
            assertThrows<IllegalArgumentException> {
                Lotto(listOf(1, 2, 3, 4, 5, 5))
            }
        }

        @ParameterizedTest
        @ValueSource(ints = [0, 46])
        fun `로또 번호는 1부터 45 사이의 숫자여야 한다`(number: Int) {
            assertThrows<IllegalArgumentException> {
                Lotto(listOf(1, 2, 3, 4, 5, number))
            }
        }

        @Test
        fun `유효한 로또 번호로 로또를 생성할 수 있다`() {
            val numbers = listOf(1, 2, 3, 4, 5, 6)
            val lotto = Lotto(numbers)
            assertThat(lotto.getSortedNumbers()).isEqualTo(numbers)
        }
    }

    @Nested
    @DisplayName("로또 번호 매칭 검증")
    inner class LottoMatching {
        private val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        @Test
        fun `일치하는 번호 개수를 반환한다`() {
            val other = Lotto(listOf(1, 2, 3, 7, 8, 9))
            assertThat(lotto.matchCount(other)).isEqualTo(3)
        }

        @Test
        fun `특정 번호의 포함 여부를 확인한다`() {
            assertThat(lotto.contains(1)).isTrue()
            assertThat(lotto.contains(7)).isFalse()
        }
    }
}
