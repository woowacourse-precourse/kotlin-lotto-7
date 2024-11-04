package lotto.model

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
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 번호가 최대 번호인 45를 초과하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `로또 번호가 오름차순으로 올바르게 정렬 됐는지 테스트`() {
        val testList = listOf(6,5,4,3,2,1)
        val lotto = Lotto(testList)
        val expectedList = testList.sorted()
        val actualList = lotto.getSortedNumbers()

        assertEquals(expectedList, actualList)
    }
}
