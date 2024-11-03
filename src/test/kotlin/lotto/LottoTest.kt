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
    fun `당첨 번호와 보너스 번호를 가지고 몇 등인지 확인할 수 있어야한다`() {
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
}
