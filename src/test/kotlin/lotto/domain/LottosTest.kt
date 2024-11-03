package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottosTest {

    @Test
    fun `구매 수량이 1미만인 경우 예외를 발생한다`() {
        // Given
        val purchaseCount = 0

        // When
        val exception = assertThrows<IllegalArgumentException> {
            Lottos(purchaseCount)
        }

        // Then
        assertThat("로또 구매 수량은 1개 이상이여야 합니다.").isEqualTo(exception.message)
    }

    @Test
    fun `올바른 구매 수량이 주어진 경우 해당 수량만큼 로또를 생성한다`() {
        // Given
        val purchaseCount = 5

        // When
        val lottos = Lottos(purchaseCount).lottos

        // Then
        assertThat(5).isEqualTo(lottos.size)
    }

}
