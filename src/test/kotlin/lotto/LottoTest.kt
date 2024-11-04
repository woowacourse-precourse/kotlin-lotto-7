package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한 후 정상적인 로또 번호로 생성`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7)) // 예외 발생
        }
        // 정상적인 로또 번호로 생성
        Lotto(listOf(1, 2, 3, 4, 5, 6)) // 예외가 발생하지 않아야 함
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한 후 정상적인 로또 번호로 생성`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5)) // 예외 발생
        }
        // 정상적인 로또 번호로 생성
        Lotto(listOf(1, 2, 3, 4, 5, 6)) // 예외가 발생하지 않아야 함
    }

    @Test
    fun `로또 번호가 1에서 45 범위를 벗어나면 예외가 발생한 후 정상적인 로또 번호로 생성`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 2, 3, 4, 5, 6)) // 예외 발생
        }
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46)) // 예외 발생
        }
        // 정상적인 로또 번호로 생성
        Lotto(listOf(1, 2, 3, 4, 5, 6)) // 예외가 발생하지 않아야 함
    }

    @Test
    fun `정상적인 로또 번호로 생성시 예외가 발생하지 않는다`() {
        // 정상적인 로또 번호로 생성
        Lotto(listOf(1, 2, 3, 4, 5, 6)) // 예외가 발생하지 않아야 함
    }
}
