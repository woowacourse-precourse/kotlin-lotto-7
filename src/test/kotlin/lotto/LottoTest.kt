package lotto

import org.junit.jupiter.api.DisplayName
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
    @DisplayName("Lotto class의 sort 메서드 검증")
    fun `로또 번호가 오름차순으로 정렬된다`() {
        // given
        val lottoTicket: List<Int> = listOf(7,32,45,12,27,1)
        val result: List<Int> = listOf(1,7,12,27,32,45)

        // when
        val sortedLottoTicket = Lotto(lottoTicket).sort()

        // then
        assertThat(sortedLottoTicket).isEqualTo(result)

    }
}
