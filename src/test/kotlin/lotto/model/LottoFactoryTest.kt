package lotto.model

import lotto.util.constant.LottoRules
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoFactoryTest {

    @Test
    fun `구매금액은 불변성을 유지한다`() {
        val originalPurchaseAmount = 10000
        val lottoFactory = LottoFactory(originalPurchaseAmount)
        val purchaseAmount = lottoFactory.getPurchaseAmount()
        val modifiedPurchaseAmount = purchaseAmount + 5000

        assertEquals(originalPurchaseAmount, lottoFactory.getPurchaseAmount())
    }

    @Test
    fun `구매금액에 따라 로또가 발행된다`() {
        val purchaseAmount = 10000
        val lottoFactory = LottoFactory(purchaseAmount)
        val lotteries = lottoFactory.createLotto()

        val expectedQuantity = purchaseAmount / LottoRules.AMOUNT_UNIT
        val result = lotteries.size

        assertEquals(expectedQuantity, result)
    }

    @Test
    fun `최대금액 10억에 대한 로또 발행`() {
        val purchaseAmount = LottoRules.MAX_AMOUNT
        val lottoFactory = LottoFactory(purchaseAmount)
        val lotteries = lottoFactory.createLotto()

        val expectedQuantity = purchaseAmount / LottoRules.AMOUNT_UNIT
        val result = lotteries.size

        assertEquals(expectedQuantity, result)
    }
}