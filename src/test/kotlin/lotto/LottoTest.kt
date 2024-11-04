package lotto

import lotto.controller.MatchingLottoCount
import lotto.model.Lotto
import lotto.model.LottoMatchCount
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

    @Test
    fun `로또 번호의 개수가 6개보다 적으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
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
    fun `로또 번호가 1~45 범위를 벗어나면 에외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 55, 10))
        }
    }

    @Test
    fun `로또 번호와 당첨 번호 카운트 일치하는지 확인 기능`() {
        val lotto = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        val winLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusLotto = 7
        val matchCount = LottoMatchCount.matchLotto(lotto, winLotto, bonusLotto)
        assertEquals(matchCount.keys.toList()[0], MatchingLottoCount.SIX)
    }


    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
}
