package lotto.model

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.Assertions.assertThat

class BonusNumberTest {
    private lateinit var bonusNumber: BonusNumber
    private lateinit var winningNumbers: List<Int>

    @BeforeEach
    fun setUp() {
        bonusNumber = BonusNumber()
        winningNumbers = listOf(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `보너스 번호 설정 시 정상적인 입력일 경우 설정된다`() {
        val rawBonusNumber = "7"
        bonusNumber.setBonusNumber(rawBonusNumber, winningNumbers)
        assertThat(bonusNumber.getBonusNumber()).isEqualTo(7)
    }

    @Test
    fun `보너스 번호에 숫자가 아닌 값이 입력될 경우 예외가 발생한다`() {
        val rawBonusNumber = "A"
        assertThatThrownBy { bonusNumber.setBonusNumber(rawBonusNumber, winningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(BonusNumber.BONUS_NUMBER_TYPE_MESSAGE)
    }

    @Test
    fun `보너스 번호가 당첨 번호와 겹칠 경우 예외가 발생한다`() {
        val rawBonusNumber = "3"
        assertThatThrownBy { bonusNumber.setBonusNumber(rawBonusNumber, winningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(BonusNumber.BONUS_NUMBER_DUPLICATE_MESSAGE)
    }

    @Test
    fun `보너스 번호가 범위를 벗어날 경우 예외가 발생한다`() {
        val rawBonusNumber = "50"
        assertThatThrownBy { bonusNumber.setBonusNumber(rawBonusNumber, winningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(BonusNumber.BONUS_NUMBER_RANGE_MESSAGE)
    }
}