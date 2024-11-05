package lotto
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {

    @Test
    fun `등수의 개수 추가시 개수가 올바르게 증가`() {
        assertSimpleTest {
            val lottoResult = LottoResult()
            lottoResult.addRank(LottoRank.FIRST)
            lottoResult.addRank(LottoRank.FIRST)
            lottoResult.addRank(LottoRank.SECOND)
            assertThat(lottoResult.countRank(LottoRank.FIRST)).isEqualTo(2)
            assertThat(lottoResult.countRank(LottoRank.SECOND)).isEqualTo(1)

        }
    }

    @Test
    fun `총 상금 올바르게 계산`() {
        assertSimpleTest{
            val lottoResult = LottoResult()
            lottoResult.addRank(LottoRank.FIRST)
            lottoResult.addRank(LottoRank.SECOND)
            lottoResult.addRank(LottoRank.THIRD)
            val totalPrize = lottoResult.calculateTotalPrize()
            assertThat(totalPrize).isEqualTo(2000000000 + 30000000 + 1500000)
        }
    }
}