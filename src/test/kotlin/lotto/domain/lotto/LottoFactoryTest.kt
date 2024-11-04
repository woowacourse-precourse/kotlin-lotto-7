package lotto.domain.lotto

import lotto.domain.numbergenerator.NumberGenerator
import lotto.domain.purchase.Purchase
import lotto.exception.ExceptionCode
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test

class LottoFactoryTest {

    @Test
    fun `buyLottoTicket()는 구매한 금액을 1000으로 나눈 몫만큼 로또 번호를 갖는 로또티켓을 반환한다`() {
        // given
        val purchase = Purchase.valueOf("3000")
        val numberGenerator = object : NumberGenerator {
            override fun generateLottoNumbers(): List<Int> {
                return listOf(1, 3, 5, 7, 9, 11)
            }
        }
        val expected = 3

        // when
        val lottoTicket = LottoFactory.buyLottoTicket(purchase, numberGenerator)

        // then
        assertSame(expected, lottoTicket.count())
    }

    @Test
    fun `getWinningLotto()는 당첨 번호를 갖는 Lotto 객체를 반환한다`() {
        // given
        val input = listOf(1, 2, 3, 4, 5, 6)
        val expected = Lotto(listOf(1, 2, 3, 4, 5, 6))

        // when
        val winningLotto = LottoFactory.getWinningLotto(input)

        // then
        assertEquals(expected.toString(), winningLotto.toString())
    }

    @Test
    fun `getBonusNumber()는 BonusNumber 객체를 반환한다`() {
        // given
        val input = 30
        val expected = 30
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        // when
        val bonusNumber = LottoFactory.getBonusNumber(input, winningLotto)

        // then
        assertSame(expected, bonusNumber.number)
    }

    @Test
    fun `getBonusNumber()는 당첨 번호에 보너스 번호와 동일한 숫자가 존재한다면 예외를 반환한다`() {
        // given
        val input = 7
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val exceptedMessage = ExceptionCode.DUPLICATE_LOTTO_NUMBER.getMessage()

        // when && then
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            LottoFactory.getBonusNumber(input, winningLotto)
        }.withMessage(exceptedMessage)

    }

}