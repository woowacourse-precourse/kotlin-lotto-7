package lotto

import lotto.model.Processor
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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
    fun `당첨 번호 중 45 초과인 숫자가 있을 때`() {
        assertThrows<IllegalArgumentException> {
            Processor.winningNumSplit("1,2,3,4,5,46")
        }
    }

    @Test
    fun `당첨 번호 중 1 미만인 숫자가 있을 때`() {
        assertThrows<IllegalArgumentException> {
            Processor.winningNumSplit("0,1,2,3,4,5")
        }
    }
}
