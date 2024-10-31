package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
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
    fun `로또 번호의 범위가 1이상 45이하가 아니면 예외가 발생한다`() {
        val lottoMachine = LottoMachine()

        assertRandomUniqueNumbersInRangeTest({
            assertThrows<IllegalArgumentException> {
                lottoMachine.createLotto()
            }
        }, listOf(1, 2, 333, 4, 6,7))

        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 22222, 3, 4, 5, 6))
        }
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
}
