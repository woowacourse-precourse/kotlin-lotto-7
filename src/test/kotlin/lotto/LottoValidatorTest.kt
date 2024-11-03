package lotto

import lotto.domain.entity.Lotto
import lotto.validator.LottoValidator
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LottoValidatorTest {
    private val validator = LottoValidator()
    private val testLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

    @ParameterizedTest
    @ValueSource(strings = ["천원", "1000j"])
    @DisplayName("금액이 문자열이면 예외 처리")
    fun `로또 금액 구매 시 문자열 예외 처리`(input: String) {
        assertThrows<IllegalArgumentException> { validator.validatePurchasePrice(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "1100"])
    @DisplayName("금액이 1000원 미만이거나 1000원으로 나누어 떨어지지 않으면 예외 처리")
    fun `로또 금액 유효성 예외 처리`(input: String) {
        assertThrows<IllegalArgumentException> { validator.validatePurchasePrice(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["a,b,c,d,e,f", "1,2,3,4,5,abc", "abcdef", "1.0,2.0,4,5,6,7", "1,,,2,,,3,,,4,,5,,6"])
    @DisplayName("로또 번호로 입력된 문자열의 유효성 검사 예외 처리")
    fun `로또 번호 유효성 예외 처리`(input: String) {
        assertThrows<IllegalArgumentException> { validator.validateWinningLotto(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["abc", "1.1"])
    @DisplayName("보너스 번호로 입력된 문자열의 유효성 검사 예외 처리")
    fun `보너스 번호 유효성 예외 처리`(input: String) {
        assertThrows<IllegalArgumentException> { validator.validateBonusNumber(input, testLotto) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "46", "1000"])
    @DisplayName("보너스 번호가 범위를 벗어나면 예외 처리")
    fun `보너스 번호 범위 예외 처리`(input: String) {
        assertThrows<IllegalArgumentException> { validator.validateBonusNumber(input, testLotto) }
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "1,2,3,4,5,6:1",
            "1,2,3,4,5,6:6"
        ],
        delimiter = ':'
    )
    @DisplayName("지정한 당첨 로또 번호 안에 보너스 번호가 포함되면 예외 처리")
    fun `보너스 번호 중복 예외 처리`(winLottoNumbers: String, bonusNumber: String) {
        val winLotto = Lotto(winLottoNumbers.split(',').map { it.toInt() })
        assertThrows<IllegalArgumentException> { validator.validateBonusNumber(bonusNumber, winLotto) }
    }
}