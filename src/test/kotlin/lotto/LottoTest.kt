package lotto

import org.junit.jupiter.api.Assertions
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
    fun `로또 번호의 개수가 5개 일치하면 보너스 번호를 확인한다`() {
        val condition = Lotto(listOf(1,2,3,4,5,6)).winConditionCheck(listOf(1,2,3,4,5,7), bonusNumber = 6)
        val expected = WinCondition.SECOND_PRIZE
        Assertions.assertEquals(condition, expected)
    }

    @Test
    fun `로또 번호의 개수가 5개 일치하지 않으면 보너스 번호를 확인하지 않는다`() {
        val condition = Lotto(listOf(1,2,3,4,5,6)).winConditionCheck(listOf(1,2,3,4,10,11), bonusNumber = 5)
        val expected = WinCondition.FOURTH_PRIZE
        Assertions.assertEquals(condition, expected)
    }
}
