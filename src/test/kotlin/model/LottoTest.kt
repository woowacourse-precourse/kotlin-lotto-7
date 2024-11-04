package model

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
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
    fun `로또 번호는 오름차순으로 관리한다`() {
        assertSimpleTest {
            // given
            val lotto = Lotto(listOf(6, 5, 4, 3, 2, 1))

            // when
            val sortedLotto = lotto.getLottoTicket().split(",")
                .map { it.trim().toInt() }

            // then
            assertThat(sortedLotto).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
        }
    }
}
