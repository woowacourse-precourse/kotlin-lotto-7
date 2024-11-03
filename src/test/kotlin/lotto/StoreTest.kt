package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertDoesNotThrow

class StoreTest {
    val lotto = Store.generateLotto()
    @Test
    fun `생성한 로또가 예외를 발생시키지는 않는지 검사한다`() {
        assertDoesNotThrow {
            lotto
        }
    }

}