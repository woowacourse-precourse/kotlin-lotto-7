package lotto

import lotto.domain.entity.Lotto
import lotto.domain.entity.Lotto.Companion.toLottoNumbers
import lotto.domain.entity.WinningLotto
import lotto.service.LottoService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import kotlin.math.exp

class LottoServiceTest {
    private val service = LottoService()

    @BeforeEach
    fun `로또 당첨 현황 초기화`() {
        WinningLotto.entries.forEach { it.amount = 0 }
    }

    @ParameterizedTest
    @ValueSource(ints = [1000])
    @DisplayName("하나 구매한 로또 번호 개수가 6개인지 확인")
    fun `로또 구매 개수 확인 테스트`(money: Int) {
        val lotto = service.purchaseLottos(money).first()
        assertThat(lotto.getNumbers().size).isEqualTo(6)
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "1000,1",
            "5000,5",
            "8000,8"
        ]
    )
    @DisplayName("금액에 따라 로또 구매 수량이 맞는지 확인")
    fun `로또 구매 수량 확인 테스트`(money: Int, amount: Int) {
        assertThat(service.purchaseLottos(money).size).isEqualTo(amount)
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "1,2,3,10,11,12:Three",
            "1,2,3,4,11,22:Four",
            "1,2,3,4,6,19:Five",
            "1,2,3,4,5,7:FiveBonus",
            "1,2,3,4,5,6:Six"
        ], delimiter = ':'
    )
    @DisplayName("당첨 로또 현황 업데이트 확인")
    fun `당첨 로또 현황 업데이트 확인 테스트`(comparingLottoNumbers: String, matchGrade: String) {
        val winLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7
        val comparingLottos = listOf(comparingLottoNumbers.split(',').map { it.toInt() }.toLottoNumbers())
        service.matchAllLotto(winLotto, comparingLottos, bonusNumber)

        val winningLottoAmount = WinningLotto.valueOf(matchGrade).amount
        assertThat(winningLottoAmount).isEqualTo(1)
    }

    @ParameterizedTest
    @CsvSource(
        value = ["1,2,3,11,12,13:1,2,3,4,5,7:1,2,3,4,5,6"], delimiter = ':'
    )
    @DisplayName("당첨 로또 수령 금액 확인")
    fun `당첨 로또 수령 금액 확인 테스트`(lotto1: String, lotto2: String, lotto3: String) {
        val winLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7
        val comparingLottos = mutableListOf<Lotto>()
        comparingLottos += lotto1.split(',').map { it.toInt() }.toLottoNumbers()
        comparingLottos += lotto2.split(',').map { it.toInt() }.toLottoNumbers()
        comparingLottos += lotto3.split(',').map { it.toInt() }.toLottoNumbers()

        service.matchAllLotto(winLotto, comparingLottos, bonusNumber)

        val rewardMoney = service.getResultMoney()
        val expectedReward =
            WinningLotto.Three.rewardPrice + WinningLotto.FiveBonus.rewardPrice + WinningLotto.Six.rewardPrice
        assertThat(rewardMoney).isEqualTo(expectedReward)
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "1000,10000,1000.0",
            "10000,0,0.0",
            "5000,5000,100.0"
        ]
    )
    @DisplayName("수익률 계산 확인")
    fun `당첨 로또 수령 금액 확인 테스트`(input: Int, output: Int, expected: String) {
        assertThat(service.getProfitRate(input, output)).isEqualTo(expected)
    }
}