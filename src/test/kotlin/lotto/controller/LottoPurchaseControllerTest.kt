package lotto.controller

import lotto.model.Lotto
import lotto.model.LottoNumberGenerator
import lotto.model.LottoTicket
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoPurchaseControllerTest {
    private val lottoTicket = LottoTicket()
    private val lottoPurchaseController = LottoPurchaseController(lottoTicket, TestLottoNumberGenerator())

    @Test
    fun `calculateNumberOfPurchase는 구입 금액에 따라 numberOfPurchase를 설정해야 한다`() {
        lottoPurchaseController.calculateNumberOfPurchase(3000)

        assertThat(lottoTicket.numberOfPurchase).isEqualTo(3)
    }

    @Test
    fun `saveUserLottoNumbers는 로또 티켓 개수만큼 번호를 생성하여 저장해야 한다`() {
        lottoTicket.numberOfPurchase = 2
        lottoPurchaseController.saveUserLottoNumbers()

        assertThat(lottoTicket.userLottoNumbers).hasSize(2)
        assertThat(lottoTicket.userLottoNumbers[0].getNumbers()).containsExactly(1, 2, 3, 4, 5, 6)
        assertThat(lottoTicket.userLottoNumbers[1].getNumbers()).containsExactly(1, 2, 3, 4, 5, 6)
    }

    private class TestLottoNumberGenerator : LottoNumberGenerator {
        override fun generateNumbers(): Lotto {
            return Lotto(listOf(1, 2, 3, 4, 5, 6))
        }
    }

}