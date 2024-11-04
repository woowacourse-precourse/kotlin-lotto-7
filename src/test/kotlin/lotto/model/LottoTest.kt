package lotto.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

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

    @Test
    fun `로또 번호에 중복된 숫자가 없으면 예외가 발생하지 않는다`() {
        Lotto(listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `로또에 특정 번호가 포함 되어 있으면 True를 반환한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.contain(6)).isTrue()
    }

    @Test
    fun `로또에 특정 번호가 포함 되어 있지 않으면 False를 반환한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.contain(7)).isFalse()
    }

    @Test
    fun `로또 번호가 일치하는 개수를 반환한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val target = Lotto(listOf(1, 2, 3, 4, 5, 7))
        assertThat(lotto.countMatching(target)).isEqualTo(5)
    }
}
