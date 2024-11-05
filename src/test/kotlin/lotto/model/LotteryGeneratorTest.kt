package lotto.model

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class LotteryGeneratorTest {

    @Test
    fun `금액에 따라 올바른 수의 로또가 생성된다`() {
        val money = 3000
        val expectedLottoCount = money / 1000
        val lotteryGenerator = LotteryGenerator()
        lotteryGenerator.makeLotto(money)
        val lotteries = lotteryGenerator.getLotteries()

        assertEquals(expectedLottoCount, lotteries.size, "로또의 개수가 일치하지 않습니다.")
    }

}