package lotto

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
    fun `로또 번호가 1~45 사이의 숫자가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 55))
        }
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @Test
    fun `5개의 번호가 일치하면 일치 개수가 5여야 한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val matchCount = lotto.getMatchCount(winningLotto)

        assertThat(matchCount).isEqualTo(5)
    }

    @Test
    fun `0개의 번호가 일치하면 일치 개수가 0여야 한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningLotto = Lotto(listOf(10, 11, 12, 13, 14, 15))
        val matchCount = lotto.getMatchCount(winningLotto)

        assertThat(matchCount).isEqualTo(0)
    }

    @Test
    fun `로또가 보너스 번호를 포함하면 true를 반환한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val containBonus = lotto.containBonusNum(4)

        assertThat(containBonus).isTrue
    }
    @Test
    fun `로또가 보너스 번호를 포함하지 않으면 false를 반환한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val containBonus = lotto.containBonusNum(9)

        assertThat(containBonus).isFalse
    }
}
