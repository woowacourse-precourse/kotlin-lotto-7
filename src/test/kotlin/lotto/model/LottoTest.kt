package lotto.model

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 테스트가 통과하도록 프로덕션 코드 구현
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 번호가 1~45 값을 벗어나면 예외가 발생한다`() {
        assertThatThrownBy { Lotto(listOf(0, 10, 20, 30, 40 ,50)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ERROR_MESSAGE)
    }

    // TODO: 문자, 공백, 소수, 구분자가 다를 경우

    // TODO: Test코드에서 중복해서 사용하므로 Constans 파일 만들어 보기
    companion object {
        private const val ERROR_MESSAGE: String = "[ERROR]"
    }
}
