package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.assertj.core.api.Assertions.assertThat

class StoreTest {
    val lotto = Store.generateLotto()
    @Test
    fun `생성한 로또가 예외를 발생시키지는 않는지 검사한다`() {
        assertDoesNotThrow {
            lotto
        }
    }

    @Test
    fun `2000원 냈을 때 로또 2개를 반환하는지 검사한다`() {
        assertThat(Store.buyLotto(2000)).hasSize(2)
    }

}