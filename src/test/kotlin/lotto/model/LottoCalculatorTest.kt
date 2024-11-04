package lotto.model

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import lotto.utils.Constants
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

    @Test
    fun `calculateProfitRate 메서드는 올바른 수익률을 계산해야 한다`() {
        // given: 각 랭크의 결과 맵을 설정
        val result = mutableMapOf(
            LottoRank.FIRST to 1, // 1등 1개
            LottoRank.SECOND to 0,
            LottoRank.THIRD to 0,
            LottoRank.FOURTH to 0,
            LottoRank.FIFTH to 0,
            LottoRank.NONE to 0
        )

        // when: calculateProfitRate 메서드 호출
        val profitRate = LottoCalculator.calculateProfitRate(result)

        // then: 수익률이 예상과 일치하는지 검증
        val totalLottoPrize = LottoRank.FIRST.prize.toDouble()
        val totalSpent = result.values.sum() * Constants.LOTTO_PRICE
        val expectedProfitRate = (totalLottoPrize / totalSpent) * 100

        assertEquals(expectedProfitRate, profitRate, 0.1) // 소수점 첫째 자리까지 비교
    }

    @Test
    fun `calculateProfitRate는 구매 금액이 0일 때 0%의 수익률을 반환해야 한다`() {
        // given: 빈 결과 맵
        val result = mutableMapOf(
            LottoRank.FIRST to 0,
            LottoRank.SECOND to 0,
            LottoRank.THIRD to 0,
            LottoRank.FOURTH to 0,
            LottoRank.FIFTH to 0,
            LottoRank.NONE to 0
        )

        // when: calculateProfitRate 메서드 호출
        val profitRate = LottoCalculator.calculateProfitRate(result)

        // then: 구매 금액이 0일 때 수익률은 0%이어야 함
        assertEquals(0.0, profitRate, 0.1)
    }

    @Test
    fun `calculateProfitRate는 구매 금액이 0보다 클 때 당첨된 로또가 없으면 0%의 수익률을 반환해야 한다`() {
        // given: 빈 결과 맵
        val result = mutableMapOf(
            LottoRank.FIRST to 0,
            LottoRank.SECOND to 0,
            LottoRank.THIRD to 0,
            LottoRank.FOURTH to 0,
            LottoRank.FIFTH to 0,
            LottoRank.NONE to 10
        )

        // when: calculateProfitRate 메서드 호출
        val profitRate = LottoCalculator.calculateProfitRate(result)

        // then: 구매 금액이 0일 때 수익률은 0%이어야 함
        assertEquals(0.0, profitRate, 0.1)
    }

}