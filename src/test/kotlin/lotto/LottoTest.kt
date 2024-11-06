package lotto

import lotto.constants.ErrorMessage
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `예외 테스트-로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
        assertEquals(ErrorMessage.LOTTO_NUMBER_NOT_ONE_SET_SIZE, exception.message)
    }

    @Test
    fun `예외 테스트-로또 번호에 1~45 사이가 아닌 정수가 있으면 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(-1, 0, 3, 4, 5, 50))
        }
        assertEquals(ErrorMessage.LOTTO_NUMBER_NOT_IN_RANGE, exception.message)
    }

    @Test
    fun `예외 테스트-로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
        assertEquals(ErrorMessage.LOTTO_NUMBER_OVERLAP, exception.message)
    }

    @Test
    fun `기능 테스트-6개의 번호가 모두 일치하면 PLACE_1st를 반환한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumber = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val rank = lotto.getWinningRank(winningNumber, bonusNumber)
        assertEquals(WinningRank.PLACE_1st, rank)
    }

    @Test
    fun `기능 테스트-5개의 번호가 일치하고 보너스 번호도 일치하면 PLACE_2nd를 반환한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val winningNumber = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val rank = lotto.getWinningRank(winningNumber, bonusNumber)
        assertEquals(WinningRank.PLACE_2nd, rank)
    }

    @Test
    fun `기능 테스트-5개의 번호가 일치하고 보너스 번호가 일치하지 않으면 PLACE_3rd를 반환한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 10))
        val winningNumber = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val rank = lotto.getWinningRank(winningNumber, bonusNumber)
        assertEquals(WinningRank.PLACE_3rd, rank)
    }

    @Test
    fun `기능 테스트-4개의 번호가 일치하면 PLACE_4th를 반환한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 7, 10))
        val winningNumber = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val rank = lotto.getWinningRank(winningNumber, bonusNumber)
        assertEquals(WinningRank.PLACE_4th, rank)
    }

    @Test
    fun `기능 테스트-3개의 번호가 일치하면 PLACE_5th를 반환한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 7, 8, 10))
        val winningNumber = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val rank = lotto.getWinningRank(winningNumber, bonusNumber)
        assertEquals(WinningRank.PLACE_5th, rank)
    }

    @Test
    fun `기능 테스트-일치하는 번호가 3개 미만이면 PLACE_Fail를 반환한다`() {
        //val lotto = Lotto(listOf(1, 2, 9, 10, 11, 12))
        //val lotto = Lotto(listOf(1, 9, 10, 11, 12, 15))
        val lotto = Lotto(listOf(9, 10, 11, 12, 15, 18))
        val winningNumber = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val rank = lotto.getWinningRank(winningNumber, bonusNumber)
        assertEquals(WinningRank.PLACE_Fail, rank)
    }

}
