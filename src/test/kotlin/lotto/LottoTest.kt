package lotto

import lotto.domain.Lotto
import lotto.domain.Rank
import lotto.domain.WinningLotto
import lotto.util.Constants
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
        assertEquals(Constants.ERROR_INVALID_LOTTO_NUMBERS_SIZE, exception.message)
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
        assertEquals(Constants.ERROR_DUPLICATE_NUMBER, exception.message)
    }

    @Test
    fun `로또 번호의 숫자가 1부터 45 사이가 아니면 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
        assertEquals(Constants.ERROR_NUMBER_OUT_OF_RANGE, exception.message)
    }

    @Test
    fun `보너스 번호의 숫자가 1부터 45 사이가 아니면 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 6), 46)
        }
        assertEquals(Constants.ERROR_NUMBER_OUT_OF_RANGE, exception.message)
    }

    @Test
    fun `입력받은 로또 번호와 보너스 번호가 중복되면 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 6), 6)
        }
        assertEquals(Constants.ERROR_BONUS_NUMBER_DUPLICATE, exception.message)
    }

    @Test
    fun `입력받은 로또 번호가 6개 일치하면 1등`() {
        val rank = Rank.findBy(6, false)
        assertEquals(Rank.FIRST, rank)
    }

    @Test
    fun `입력받은 로또 번호가 5개 일치하고 보너스 번호 일치하면 2등`() {
        val rank = Rank.findBy(5, true)
        assertEquals(Rank.SECOND, rank)
    }

    @Test
    fun `입력받은 로또 번호가 5개 일치하면 3등`() {
        val rank = Rank.findBy(5, false)
        assertEquals(Rank.THIRD, rank)
    }

    @Test
    fun `입력받은 로또 번호가 3개 미만 일치하면 NONE`() {
        val rank = Rank.findBy(2, false)
        assertEquals(Rank.NONE, rank)
    }


    // TODO: 추가 기능 구현에 따른 테스트 코드 작성

}
