package lotto

import lotto.domain.Lotto
import lotto.domain.Rank
import lotto.domain.WinningLotto
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
    fun `로또 번호의 숫자가 1부터 45 사이가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `보너스 번호의 숫자가 1부터 45 사이가 아니면 예외가 발생한다`() {
         assertThrows<IllegalArgumentException> {
             WinningLotto(listOf(1,2,3,4,5,6),46)
         }
    }

    @Test
    fun `입력받은 로또 번호와 보너스 번호가 중복되면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1,2,3,4,5,6),6)
        }
    }

    @Test
    fun `입력받은 로또 번호가 6개 일치하면 1등`() {
        val rank = Rank.valueOfMatchCount(6, false)
        assertEquals(Rank.FIRST, rank)
    }

    @Test
    fun `입력받은 로또 번호가 5개 일치하고 보너스 번호 일치하면 2등`() {
        val rank = Rank.valueOfMatchCount(5, true)
        assertEquals(Rank.SECOND, rank)
    }

    @Test
    fun `입력받은 로또 번호가 5개 일치하면 3등`() {
        val rank = Rank.valueOfMatchCount(5, false)
        assertEquals(Rank.THIRD, rank)
    }

    @Test
    fun `입력받은 로또 번호가 3개 미만 일치하면 NONE`() {
        val rank = Rank.valueOfMatchCount(2, false)
        assertEquals(Rank.NONE, rank)
    }


    // TODO: 추가 기능 구현에 따른 테스트 코드 작성

}
