package lotto.data

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class BonusNumberTest {

    @Test
    fun `보너스 번호가 정수가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber("a", listOf(1, 2, 3, 4, 5, 6))
        }.also { exception ->
            assertThat(exception.message).isEqualTo("[ERROR] 보너스번호는 정수여야 합니다.")
        }
    }

    @Test
    fun `보너스 번호가 1부터 45 사이가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber("46", listOf(1, 2, 3, 4, 5, 6))
        }.also { exception ->
            assertThat(exception.message).isEqualTo("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.")
        }

        assertThrows<IllegalArgumentException> {
            BonusNumber("-1", listOf(1, 2, 3, 4, 5, 6))
        }.also { exception ->
            assertThat(exception.message).isEqualTo("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복되면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber("3", listOf(1, 2, 3, 4, 5, 6))
        }.also { exception ->
            assertThat(exception.message).isEqualTo("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.")
        }
    }

    @Test
    fun `보너스 번호가 올바른 경우 객체가 정상적으로 생성된다`() {
        val bonusNumber = BonusNumber("7", listOf(1, 2, 3, 4, 5, 6))
        assertThat(bonusNumber.getNumber()).isEqualTo(7)
    }
}
