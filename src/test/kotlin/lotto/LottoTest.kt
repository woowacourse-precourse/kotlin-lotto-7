package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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
    fun `당첨 번호와 로또의 번호가 같을 경우 1등을 확인할 수 있어야한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val rank = lotto.checkRank(listOf(1, 2, 3, 4, 5, 6), 7)
        assertThat(rank).isEqualTo(LottoRank.FIRST)
    }

    @Test
    fun `당첨 번호와 로또의 번호 중 하나가 다르면서 보너스가 맞을 경우 2등인지 확인할 수 있어야한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val rank = lotto.checkRank(listOf(1, 2, 3, 4, 5, 6), 7)
        assertThat(rank).isEqualTo(LottoRank.SECOND)
    }

    @Test
    fun `당첨 번호와 로또의 번호 중 하나가 다르면서 보너스가 틀릴 경우 3등인지 확인할 수 있어야한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val rank = lotto.checkRank(listOf(1, 2, 3, 4, 5, 6), 8)
        assertThat(rank).isEqualTo(LottoRank.THIRD)
    }

    @Test
    fun `당첨 번호와 로또의 번호 중 두개 다르면 4등인지 확인할 수 있어야한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 9, 7))
        val rank = lotto.checkRank(listOf(1, 2, 3, 4, 5, 6), 8)
        assertThat(rank).isEqualTo(LottoRank.FOURTH)
    }

    @Test
    fun `당첨 번호와 로또의 번호 중 세개가 다르면 5등인지 확인할 수 있어야한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 11, 10, 7))
        val rank = lotto.checkRank(listOf(1, 2, 3, 4, 5, 6), 8)
        assertThat(rank).isEqualTo(LottoRank.FIFTH)
    }

    @Test
    fun `당첨 번호와 로또의 번호 중 네개가 다르면 낙첨인지 확인할 수 있어야한다`() {
        val lotto = Lotto(listOf(1, 2, 12, 11, 10, 7))
        val rank = lotto.checkRank(listOf(1, 2, 3, 4, 5, 6), 8)
        assertThat(rank).isEqualTo(LottoRank.LOSE)
    }
}
