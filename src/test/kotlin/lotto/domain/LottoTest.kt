package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
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
    fun `로또 생성에 성공한다`() {
        Lotto(listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `로또 번호에 너무 큰 값이 들어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 66))
        }
    }

    @Test
    fun `로또 번호에 너무 작은 값이 들어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, -2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `로또 번호가 6개 미만이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `로또가 예외 없이 생성된다`() {
        Lotto.create()
    }

    @Test
    fun `로또 번호가 6개 같으면 1등을 반환한다`() {
        val lottoWinningInfo = LottoWinningInfo(listOf(1, 2, 3, 4, 5, 6), 7)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val result = lotto.getLottoRank(lottoWinningInfo)
        assertEquals(result, LottoRank.FIRST)
    }

    @Test
    fun `로또 번호가 5개 같고 보너스 번호가 같으면 2등을 반환한다`() {
        val lottoWinningInfo = LottoWinningInfo(listOf(1, 2, 3, 4, 5, 9), 7)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))

        val result = lotto.getLottoRank(lottoWinningInfo)
        assertEquals(result, LottoRank.SECOND)
    }

    @Test
    fun `로또 번호가 5개 같으면 3등을 반환한다`() {
        val lottoWinningInfo = LottoWinningInfo(listOf(1, 2, 3, 4, 5, 9), 7)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val result = lotto.getLottoRank(lottoWinningInfo)
        assertEquals(result, LottoRank.THIRD)
    }

    @Test
    fun `로또 번호가 4개 같으면 4등을 반환한다`() {
        val lottoWinningInfo = LottoWinningInfo(listOf(1, 2, 3, 4, 8, 9), 6)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val result = lotto.getLottoRank(lottoWinningInfo)
        assertEquals(result, LottoRank.FOURTH)
    }

    @Test
    fun `로또 번호가 3개 같으면 5등을 반환한다`() {
        val lottoWinningInfo = LottoWinningInfo(listOf(1, 2, 3, 8, 9, 10), 6)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val result = lotto.getLottoRank(lottoWinningInfo)
        assertEquals(result, LottoRank.FIFTH)
    }

    @Test
    fun `같은 로또 번호가 2개면 없음 등급을 반환한다`() {
        val lottoWinningInfo = LottoWinningInfo(listOf(1, 2, 12, 11, 10, 9), 6)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val result = lotto.getLottoRank(lottoWinningInfo)
        assertEquals(result, LottoRank.NONE)
    }

    @Test
    fun `같은 로또 번호가 1개면 없음 등급을 반환한다`() {
        val lottoWinningInfo = LottoWinningInfo(listOf(1, 13, 12, 11, 10, 9), 6)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val result = lotto.getLottoRank(lottoWinningInfo)
        assertEquals(result, LottoRank.NONE)
    }

    @Test
    fun `같은 로또 번호가 0개면 없음 등급을 반환한다`() {
        val lottoWinningInfo = LottoWinningInfo(listOf(14, 13, 12, 11, 10, 9), 6)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val result = lotto.getLottoRank(lottoWinningInfo)
        assertEquals(result, LottoRank.NONE)
    }
}
