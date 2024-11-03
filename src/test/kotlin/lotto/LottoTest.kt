package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
    private val bonusNumber = 7

    @Test
    fun `getLottoResultAsRank가 올바른 등수를 반환한다`() {
        val firstPrizeTicket = listOf(1, 2, 3, 4, 5, 6)
        val secondPrizeTicket = listOf(1, 2, 3, 4, 5, 7)
        val thirdPrizeTicket = listOf(1, 2, 3, 4, 5, 45)
        val fourthPrizeTicket = listOf(1, 2, 3, 4, 44, 45)
        val fifthPrizeTicket = listOf(1, 2, 3, 43, 44, 45)
        val nonePrizeTicket = listOf(1, 2, 42, 43, 44, 45)
        assertEquals(
            1,
            Lotto(firstPrizeTicket).getLottoResultAsRank(winningNumbers, bonusNumber)
        )
        assertEquals(
            2,
            Lotto(secondPrizeTicket).getLottoResultAsRank(winningNumbers, bonusNumber)
        )
        assertEquals(
            3,
            Lotto(thirdPrizeTicket).getLottoResultAsRank(winningNumbers, bonusNumber)
        )
        assertEquals(
            4,
            Lotto(fourthPrizeTicket).getLottoResultAsRank(winningNumbers, bonusNumber)
        )
        assertEquals(
            5,
            Lotto(fifthPrizeTicket).getLottoResultAsRank(winningNumbers, bonusNumber)
        )
        assertEquals(
            6,
            Lotto(nonePrizeTicket).getLottoResultAsRank(winningNumbers, bonusNumber)
        )
    }

//    @Test
//    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
//        assertThrows<IllegalArgumentException> {
//            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
//        }
//    }
//
//    // TODO: 테스트가 통과하도록 프로덕션 코드 구현
//    @Test
//    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
//        assertThrows<IllegalArgumentException> {
//            Lotto(listOf(1, 2, 3, 4, 5, 5))
//        }
//    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
}
