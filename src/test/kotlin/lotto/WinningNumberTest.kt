package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumberTest {

    @Test
    fun `당첨 번호에 문자를 입력했을 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber("a,s,d,f,z,x")
        }
    }

    @Test
    fun `당첨 번호에 빈 값이 있을 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber("1,2,3,,5,6")
        }
    }
}