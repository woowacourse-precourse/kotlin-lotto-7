package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import lotto.domain.LottoRank
import lotto.domain.LottoWinningInfo
import lotto.domain.Money
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.math.round

class LottoServiceTest : NsTest() {
    private lateinit var lottoService: LottoService

    @BeforeEach
    fun setup() {
        lottoService = LottoService()
    }

    @ParameterizedTest
    @ValueSource(ints = [1_000, 2_000, 23_000, 1_030_000])
    fun `입력한 비용 만큼 로또를 발행한다`(value: Int) {
        val money = Money(value)
        lottoService.issueLottos(money)

        val lottoCount = lottoService.lottos.size
        assertEquals(lottoCount, money.amount / LOTTO_PRICE)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 100, 999, 1100, 3_321_341])
    fun `잘못된 비용이 입력되면 예외가 발생한다`(value: Int) {
        val money = Money(value)

        assertThrows<IllegalArgumentException> {
            lottoService.issueLottos(money)
        }
    }

    @Test
    fun `수익률 계산에 성공한다 - 큰 값`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                val money = Money(3_000)
                lottoService.issueLottos(money)
                val winningInfo = LottoWinningInfo(listOf(1, 2, 3, 4, 5, 6))
                winningInfo.bonusNumber = 7

                val resultROI = lottoService.getRatOfReturn(winningInfo)
                var expectedROI =
                    ((LottoRank.FIRST.prize + LottoRank.SECOND.prize + LottoRank.THIRD.prize) / 3_000.0) * 100
                expectedROI = round(expectedROI * 10) / 10

                assertEquals(resultROI, expectedROI)
            },
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 7),
            listOf(1, 2, 3, 4, 5, 10)
        )
    }

    @Test
    fun `수익률 계산에 성공한다 - 작은 값`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                val money = Money(8_000)
                lottoService.issueLottos(money)
                val winningInfo = LottoWinningInfo(listOf(1, 2, 3, 4, 5, 6))
                winningInfo.bonusNumber = 7

                val resultROI = lottoService.getRatOfReturn(winningInfo)
                var expectedROI = (LottoRank.FIFTH.prize / money.amount.toDouble()) * 100
                expectedROI = round(expectedROI * 10) / 10

                assertEquals(resultROI, expectedROI)
            },
            listOf(8, 21, 23, 41, 42, 43),
            listOf(3, 5, 11, 16, 32, 38),
            listOf(7, 11, 16, 35, 36, 44),
            listOf(1, 8, 11, 31, 41, 42),
            listOf(13, 14, 16, 38, 42, 45),
            listOf(7, 11, 30, 40, 42, 43),
            listOf(2, 13, 22, 32, 38, 45),
            listOf(1, 3, 5, 14, 22, 45)
        )
    }

    override fun runMain() {
    }

    companion object {
        const val LOTTO_PRICE = 1_000
    }
}
