package lotto

import lotto.domain.validator.delegate.common.CommonErrorDelegate
import lotto.domain.validator.delegate.common.CommonErrorDelegator
import lotto.domain.validator.delegate.input.InputErrorDelegate
import lotto.domain.validator.delegate.input.InputErrorDelegator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource
import lotto.domain.enums.Exception
import lotto.domain.enums.Process
import lotto.domain.validator.InputValidator
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import lotto.domain.util.ext.splitByComma
import lotto.domain.util.ext.toMapByEachCount
import org.junit.jupiter.api.TestInstance

class InputTest {
    private lateinit var commonErrorDelegate: CommonErrorDelegate
    private lateinit var inputErrorDelegate: InputErrorDelegate
    private lateinit var inputValidator: InputValidator

    @BeforeEach
    fun init() {
        commonErrorDelegate = CommonErrorDelegator()
        inputErrorDelegate = InputErrorDelegator()
        inputValidator = InputValidator(commonErrorDelegate, inputErrorDelegate)
    }

    @Nested
    inner class CommonErrorTest {
        @ParameterizedTest
        @EmptySource
        fun `사용자의 입력값이 비어있을 때`(입력: String) {
            Assertions.assertThatThrownBy { commonErrorDelegate.isEmpty(입력) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(Exception.EMPTY_INPUT.toString())
        }

        @Test
        fun `사용자의 입력값이 정수로 표현할 수 있는 범위를 넘어갈 때`() {
            val value = "10000000000000000"
            Assertions.assertThatThrownBy { commonErrorDelegate.isOverIntMaxValue(value) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(Exception.EXCEED_MAX_INT.toString())
        }
    }

    @Nested
    inner class PurchaseAmountTest {

        @ParameterizedTest
        @ValueSource(strings = ["abc", "ㄱㄴㄷ", "!@#$", "100,23,22"])
        fun `구입 금액 입력값이 숫자가 아닐 때`(value: String) {
            val type = Process.PAY
            Assertions.assertThatThrownBy { commonErrorDelegate.isNumeric(value, type) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("${type}은(는) ${Exception.INVALID_INPUT}")
        }

        @ParameterizedTest
        @ValueSource(strings = ["0", "9999", "10001", "1111"])
        fun `구입 금액 입력값이 천원 단위가 아닐 때 `(value: String) {
            Assertions.assertThatThrownBy { inputErrorDelegate.isThousandWonUnit(value) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(Exception.INVALID_UNIT.toString())
        }
    }

    @Nested
    inner class WinningNumberTest {

        @ParameterizedTest
        @ValueSource(strings = [",,,", ",", "1", "1,2", "1,2,3", "1,2,3,4", "1,2,3,4,5", "1,2,3,4,5,6,7,8,9,10"])
        fun `당첨 번호가 6개가 아닐 때 예외 테스트`(value: String) {
            val winningNumber = value.split(",")
            Assertions.assertThatThrownBy { inputErrorDelegate.isInvalidLottoSize(winningNumber) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(Exception.INVALID_SIZE.toString())
        }

        @ParameterizedTest
        @ValueSource(strings = ["1,2,3,4,5,@", "1,;ㄱ,a,4,5,@"])
        fun `당첨 번호에 숫자와 구분자(쉼표)가 아닌 문자가 입력되었을 때`(value: String) {
            Assertions.assertThatThrownBy { inputErrorDelegate.isInvalidInputFormat(value) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(Exception.INVALID_FORMAT.toString())
        }

        @ParameterizedTest
        @ValueSource(strings = ["1,2,3,4,5,46", "0,1,2,3,4,5"])
        fun `당첨번호가 로또번호의 범위를 벗어날 때`(value: String) {
            val type = Process.WINNING_NUMBER
            val winningNumber = value.splitByComma()
            Assertions.assertThatThrownBy {
                inputErrorDelegate.isExceededRange(
                    winningNumber,
                    type
                )
            }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(Exception.EXCEED_INPUT.toString())
        }

        @ParameterizedTest
        @ValueSource(strings = ["1, 1, 1, 1, 1, 1", "1, 2, 3, 3, 3, 3", "1, 2, 3, 4, 5, 5"])
        fun `당첨 번호가 중복 됐을 때`(value: String) {
            val winningNumber = value.splitByComma().toMapByEachCount()
            Assertions.assertThatThrownBy { inputErrorDelegate.isDuplicated(winningNumber) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(Exception.INVALID_DUPLICATED.toString())
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    inner class BonusNumberTest {

        @ParameterizedTest
        @ValueSource(strings = ["abc", "ㄱㄴㄷ", "!@#$", "100,23,22"])
        fun `보너스 번호가 숫자가 아닐 때`(value: String) {
            val type = Process.BONUS_NUMBER
            Assertions.assertThatThrownBy { commonErrorDelegate.isNumeric(value, type) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("${type}은(는) ${Exception.INVALID_INPUT}")
        }

        @ParameterizedTest
        @ValueSource(strings = ["0,1,2,3,4,5, 0,22,33,44,2,46"])
        fun `보너스 번호가 로또번호의 범위를 벗어날 때`(value: String) {
            val type = Process.BONUS_NUMBER
            val winningNumber = value.splitByComma()
            Assertions.assertThatThrownBy {
                inputErrorDelegate.isExceededRange(winningNumber, type)
            }.isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(Exception.EXCEED_INPUT.toString())
        }

        @Test
        fun `보너스 번호가 당첨 번호와 중복될 때`() {
            val winningNumber = listOf(1, 2, 3, 4, 5, 6)
            val bonusNumber = 3
            Assertions.assertThatThrownBy {
                inputErrorDelegate.isDuplicatedBonusNumber(winningNumber, bonusNumber)
            }.isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(Exception.BONUS_NUMBER_DUPLICATED.toString())
        }
    }
}
