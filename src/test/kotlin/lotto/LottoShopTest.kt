package lotto

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class LottoShopTest {
    @Test
    fun `살 로또의 개수를 입력하면 그 숫자만큼 로또를 발행한다`() {
        val lottos = LottoShop().sellLotto(5)
        Assertions.assertEquals(5, lottos.size)
    }
}