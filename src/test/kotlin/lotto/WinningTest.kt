package lotto

import lotto.data.Winning
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("당첨 번호 테스트 케이스")
class WinningTest {
    @DisplayName("입력을 하지 않았을 경우")
    @ParameterizedTest
    @EmptySource
    fun numberIsEmpty(input: String) {
        val result = assertThrows<IllegalArgumentException> { Winning(input) }
        assertEquals(result.message, "[ERROR] 당첨 번호가 입력되지 않았습니다. 6개의 번호를 쉼표(,)를 기준으로 입력해주세요.")
    }

    @DisplayName(",을 기준하여 숫자로만 이루어져 있지 않은 경우")
    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = ["1,Q,2,W,3,E", "1,2,3,4.0,5,6", "1,2,3,4,5 ,6", "1,2,3,4, 5,6"])
    fun numberIsNotAllDigit(input: String) {
        val result = assertThrows<IllegalArgumentException> { Winning(input) }
        assertEquals(result.message, "[ERROR] 6개의 번호를 쉼표(,)를 기준으로 숫자만 입력해주세요.")
    }

    @DisplayName("0으로 시작하는 숫자를 입력한 경우")
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,05,06,07"])
    fun numberStartZero(input: String) {
        val result = assertThrows<IllegalArgumentException> { Winning(input) }
        assertEquals(result.message, "ERROR] 0으로 시작하지 않는 6개의 번호를 쉼표(,)를 기준으로 입력해주세요.")
    }

    @DisplayName("중복된 값이 존재할 경우")
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,4,5", "10,11,23,24,40,40"])
    fun numbersContainsDuplication(input: String) {
        val result = assertThrows<IllegalArgumentException> { Winning(input) }
        assertEquals(result.message, "[ERROR] 중복되지 않는 6개의 번호를 입력해주세요.")
    }

    @DisplayName("당첨 번호 범위를 벗어난 번호가 있는 경우")
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5,46", "1,2,3,4,5,321321321321321321321"])
    fun numberOutOfRange(input: String) {
        val result = assertThrows<IllegalArgumentException> { Winning(input) }
        assertEquals(result.message, "[ERROR] 1 ~ 45 범위 내 6개의 번호를 입력해주세요.")
    }

    @DisplayName("당첨 번호가 오름차순으로 정렬되어 있지 않은 경우")
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,6,5,4"])
    fun numberIsNotOfSort(input: String) {
        val result = assertThrows<IllegalArgumentException> { Winning(input) }
        assertEquals(result.message, "[ERROR] 당첨 번호는 오름차순으로 입력해주세요.")
    }
}