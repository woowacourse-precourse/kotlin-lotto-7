package lotto.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {

    @Nested
    @DisplayName("예외 테스트")
    inner class InvalidLottoTests {
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
        fun `로또 번호가 1과 45 사이의 숫자가 아닌 경우 예외 처리`() {
            assertThrows<IllegalArgumentException> {
                Lotto(listOf(1, 2, 3, 4, 5, 46))
                Lotto(listOf(0, 2, 3, 4, 5, 6))
            }
        }

        @Test
        fun `로또 번호가 6개가 아니면 예외가 발생한다`() {
            assertThrows<IllegalArgumentException> {
                Lotto(listOf(1, 2, 3, 4, 5))
            }
        }
    }

    @Nested
    @DisplayName("정상 입력 테스트")
    inner class ValidLottoTests {
        @Test
        fun `정상적인 로또 번호가 입력되면 로또 객체가 생성된다`(){
            val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
            assertEquals(listOf(1, 2, 3, 4, 5, 6), lotto.get())
        }
    }

}
