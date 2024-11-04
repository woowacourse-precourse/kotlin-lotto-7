package lotto

import lotto.model.Lotto
import lotto.util.InputParser.parseWinningNumbers
import lotto.util.InputValidator.validateLottoNumberInRange
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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

    @ParameterizedTest
    @ValueSource(strings = ["0,1,2,3,4,5", "1,2,3,4,5,999"])
    fun `당첨 번호 중 1 이상 45 이하가 아닌 것이 있을 경우 예외가 발생한다`(input: String) {
        val numbers = parseWinningNumbers(input)
        assertThrows<IllegalArgumentException> { numbers.forEach { validateLottoNumberInRange(it) } }
    }
}
