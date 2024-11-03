package lotto

import lotto.model.Lotto
import lotto.model.LottoRank
import lotto.model.LottoTicket
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {

    private val lotto = Lotto(listOf(1,2,3,4,5,6))

    @Test
    fun `로또 번호의 개수가 6개가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 번호가 1~45 값을 벗어나면 예외가 발생한다`() {
        assertThatThrownBy { Lotto(listOf(0, 10, 20, 30, 40 ,45)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] 로또 번호는 1에서 45 사이 정수 값을 입력해주세요.")

        assertThatThrownBy { Lotto(listOf(1, 10, 20, 30, 40 ,50)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] 로또 번호는 1에서 45 사이 정수 값을 입력해주세요.")
    }

    @Test
    fun `로또 당첨 결과 계산 테스트`() {
        val lottoTickets = listOf(
            LottoTicket(listOf(1, 2, 3, 4, 5, 6)),
            LottoTicket(listOf(1, 2, 3, 4, 5, 7)),
            LottoTicket(listOf(1, 2, 3, 4, 8, 9)),
            LottoTicket(listOf(1, 2, 3, 8, 9, 10))
        )
        val bonusNumber = 7
        val result = lotto.calculateLottoResults(lottoTickets, bonusNumber)

        assertThat(result[LottoRank.FIRST]).isEqualTo(1)
        assertThat(result[LottoRank.SECOND]).isEqualTo(1)
        assertThat(result[LottoRank.FOURTH]).isEqualTo(1)
        assertThat(result[LottoRank.FIFTH]).isEqualTo(1)
        assertThat(result[LottoRank.NONE]).isEqualTo(0)
    }
}
