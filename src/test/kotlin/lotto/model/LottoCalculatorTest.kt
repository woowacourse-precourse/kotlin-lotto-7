package lotto.model

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoCalculatorTest {

    @Test
    fun `calculate 메서드는 올바른 결과를 반환해야 한다`() {
        val lottos = Lottos()
        val price = 5000 // 로또 5개 구매 가격

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
                val result = LottoCalculator.calculate(lottos, listOf(1, 2, 3, 4, 5, 6), 7)

                // 예상되는 결과 검증
                assertEquals(1, result[LottoRank.FIRST]) // 1등이 1개 있어야 함
                assertEquals(0, result[LottoRank.SECOND])
                assertEquals(0, result[LottoRank.THIRD])
                assertEquals(0, result[LottoRank.FOURTH])
                assertEquals(0, result[LottoRank.FIFTH])
                assertEquals(4, result[LottoRank.NONE]) // 나머지는 전부 NONE이어야 함
            },
            expectedNumbers[0],
            *expectedNumbers.subList(1, expectedNumbers.size).toTypedArray()
        )
    }
}