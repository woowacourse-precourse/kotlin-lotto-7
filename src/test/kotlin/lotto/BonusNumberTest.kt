package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusNumberTest {

    private val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))


    @Test
    fun `보너스 번호에 숫자가 아닌 문자가 입력했을 경우 오류를 출력한다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber("문자",lotto)
        }
    }
}