package lotto

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

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @Test
    fun `로또 번호 반환 테스트`() {
        val lottoFactory = dependencyInjector.injectLottoFactory()
        val lotto = lottoFactory()
        repeat(100000) {
            assertEquals(lotto.size, 6)
            assertTrue(lotto.minOrNull() in 1..45)
            assertTrue(lotto.maxOrNull() in 1..45)
            assertTrue(lotto.size == lotto.distinct().size)
        }
    }
}
