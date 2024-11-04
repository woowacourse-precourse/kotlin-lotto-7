package lotto.model

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottosTest {

    @Nested
    @DisplayName("정상 테스트")
    inner class ValidLottosTests {
        @Test
        fun `buyLottos 메서드는 올바른 개수의 Lottos를 생성해야 한다`() {
            val lottos = Lottos()
            val price = 5000  // 로또 5개 구매 가격
            val expectedNumbers = listOf(
                listOf(1, 2, 3, 4, 5, 6),
                listOf(7, 8, 9, 10, 11, 12),
                listOf(13, 14, 15, 16, 17, 18),
                listOf(19, 20, 21, 22, 23, 24),
                listOf(25, 26, 27, 28, 29, 30)
            )
            assertRandomUniqueNumbersInRangeTest(
                {
                    lottos.buyLottos(price)
                    assertEquals(5, lottos.size())

                    lottos.getLottos().forEachIndexed { index, lotto ->
                        val generatedNumbers = lotto.get()
                        assertEquals(expectedNumbers[index], generatedNumbers)
                        assertTrue(generatedNumbers.size == 6)
                        assertTrue(generatedNumbers.all { it in 1..45 })
                    }
                },
                expectedNumbers[0],
                *expectedNumbers.subList(1, expectedNumbers.size).toTypedArray()

            )
        }
    }

}