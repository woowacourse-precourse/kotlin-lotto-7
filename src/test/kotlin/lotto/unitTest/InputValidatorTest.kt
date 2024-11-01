package lotto.unitTest

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import lotto.domain.InputValidator
import lotto.model.Lotto
import org.junit.jupiter.api.BeforeEach
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {
    private lateinit var inputValidator: InputValidator

    @BeforeEach
    fun setUp() {
        inputValidator = InputValidator()
    }

    @ParameterizedTest
    @DisplayName("구입 금액의 예외 입력 테스트")
    @ValueSource(strings = ["300", "1500", "10001", "0", "-1000", "천원", "", " "])
    fun validateMoneyExceptTest(input: String) {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                inputValidator.validateMoney(input)
            }
        }
    }

    @ParameterizedTest
    @DisplayName("구입 금액 정상 입력 테스트")
    @ValueSource(strings = ["1000", "2000", "10000"])
    fun validateMoneyTest(input: String) {
        assertSimpleTest {
            val result = inputValidator.validateMoney(input)
            assertThat(result).isEqualTo(input.toLong())
        }
    }

    @ParameterizedTest
    @DisplayName("당첨번호 입력의 예외 테스트")
    @ValueSource(
        strings = [
            "",
            " ",
            "123456",
            "일,2,3,4,5,6",
            "1.9,2,3,4,5,6",
            "1 2 3 4 5 6",
            "1, 2, 3, 4, 5, 6",
            "0,2,3,4,5,6",
            "1,2,3,4,5,46",
            "1,1,3,4,5,6"]
    )
    fun validateWinNumbersExceptTest(input: String) {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                inputValidator.validateWinNumbers(input)
            }
        }
    }

    @ParameterizedTest
    @DisplayName("당첨번호 입력의 정상 입력 테스트")
    @CsvSource(
        "1,2,3,4,5,6|21",
        "10,20,30,40,41,45|186",
        "45,44,22,33,15,1|160", delimiter = '|'
    )
    fun validateWinNumbersTest(input: String, inputSum: String) {
        val result = inputValidator.validateWinNumbers(input)
        assertThat(result.numbers()).hasSize(6)
        assertThat(result.numbers()).allMatch { it in 1..45 }
        assertThat(result.numbers()).doesNotHaveDuplicates()
        assertThat(result.numbers().sum()).isEqualTo(inputSum.toLong())
        assertThat(result.numbers()[0] < result.numbers()[5]).isTrue()
    }

    @ParameterizedTest
    @DisplayName("보너스넘버 입력의 정상 입력 테스트")
    @ValueSource(strings = ["1", "8", "45"])
    fun validateBonusNumberTest(input: String) {
        // given
        val winLotto = Lotto(listOf(2, 3, 4, 5, 6, 7))

        // when
        val result = inputValidator.validateBonusNumber(input, winLotto)

        // then
        assertThat(result).isEqualTo(input.toInt())
    }

    @ParameterizedTest
    @DisplayName("보너스넘버 입력의 예외 입력 테스트")
    @ValueSource(strings = ["-1", "0", "1", "46", " ", "", "일", "9.9"])
    fun validateBonusNumberExceptTest(input: String) {
        // given
        val winLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        // then
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                inputValidator.validateBonusNumber(input, winLotto)
            }
        }
    }
}