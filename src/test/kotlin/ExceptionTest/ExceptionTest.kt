package ExceptionTest

import Exception.Exception
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ExceptionTest {
    @Test
    fun `사용자가 잘못된 값을 입력한 경우 IllegalArgumentException을 발생시킨다`() {
        assertSimpleTest {
            // given

            // when

            // then
            assertThrows<IllegalArgumentException> {
                Exception.throwException("")
            }
        }
    }
}