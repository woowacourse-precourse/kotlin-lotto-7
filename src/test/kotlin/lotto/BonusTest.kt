package lotto

import lotto.data.Bonus
import lotto.data.Winning
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@DisplayName("보너스 번호 테스트 케이스")
class BonusTest {
    @DisplayName("보너스 번호를 입력하지 않은 경우")
    @ParameterizedTest
    @MethodSource("emptySource")
    fun numberIsEmpty(winning: Winning, input: String, message: String) {
        val result = assertThrows<IllegalArgumentException> { Bonus(input, winning) }
        assertEquals(result.message, message)
    }

    @DisplayName("숫자가 아닐 경우")
    @ParameterizedTest
    @MethodSource("notNumberSource")
    fun isNotNumber(winning: Winning, input: String, message: String) {
        val result = assertThrows<IllegalArgumentException> { Bonus(input, winning) }
        assertEquals(result.message, message)
    }

    @DisplayName("0으로 시작할 경우")
    @ParameterizedTest
    @MethodSource("startZeroSource")
    fun numberStartIsZero(winning: Winning, input: String, message: String) {
        val result = assertThrows<IllegalArgumentException> { Bonus(input, winning) }
        assertEquals(result.message, message)
    }

    @DisplayName("당첨 번호와 중복될 경우")
    @ParameterizedTest
    @MethodSource("winningDuplicationSource")
    fun numberInWinningNumber(winning: Winning, input: String, message: String) {
        val result = assertThrows<IllegalArgumentException> { Bonus(input, winning) }
        assertEquals(result.message, message)
    }

    @DisplayName("보너스 번호 범위를 벗어날 경우")
    @ParameterizedTest
    @MethodSource("outOfRangeSource")
    fun numberOutOfRange(winning: Winning, input: String, message: String) {
        val result = assertThrows<IllegalArgumentException> { Bonus(input, winning) }
        assertEquals(result.message, message)
    }

    companion object {
        private val winning = Winning("1,2,3,4,5,6")

        @JvmStatic
        fun emptySource(): Stream<Arguments> = Stream.of(
            arguments(winning, "", "[ERROR] 보너스 번호가 입력되지 않았습니다. 보너스 번호를 입력해주세요.")
        )

        @JvmStatic
        fun notNumberSource(): Stream<Arguments> = Stream.of(
            arguments(winning, "a", "[ERROR] 숫자만 입력해주세요."),
            arguments(winning, "가", "[ERROR] 숫자만 입력해주세요."),
            arguments(winning, "^", "[ERROR] 숫자만 입력해주세요."),
            arguments(winning, "\t", "[ERROR] 숫자만 입력해주세요."),
            arguments(winning, "\n", "[ERROR] 숫자만 입력해주세요.")
        )

        @JvmStatic
        fun startZeroSource(): Stream<Arguments> = Stream.of(
            arguments(winning, "01", "[ERROR] 0으로 시작하지 않는 번호를 입력해주세요."),
            arguments(winning, "045", "[ERROR] 0으로 시작하지 않는 번호를 입력해주세요."),
            arguments(winning, "035", "[ERROR] 0으로 시작하지 않는 번호를 입력해주세요."),
            arguments(winning, "017", "[ERROR] 0으로 시작하지 않는 번호를 입력해주세요."),
            arguments(winning, "025", "[ERROR] 0으로 시작하지 않는 번호를 입력해주세요.")
        )

        @JvmStatic
        fun winningDuplicationSource(): Stream<Arguments> = Stream.of(
            arguments(winning, "1", "[ERROR] 당첨 번호와 중복되지 않는 번호로 입력해주세요."),
            arguments(winning, "2", "[ERROR] 당첨 번호와 중복되지 않는 번호로 입력해주세요."),
            arguments(winning, "3", "[ERROR] 당첨 번호와 중복되지 않는 번호로 입력해주세요."),
            arguments(winning, "4", "[ERROR] 당첨 번호와 중복되지 않는 번호로 입력해주세요."),
            arguments(winning, "5", "[ERROR] 당첨 번호와 중복되지 않는 번호로 입력해주세요."),
            arguments(winning, "6", "[ERROR] 당첨 번호와 중복되지 않는 번호로 입력해주세요.")
        )

        @JvmStatic
        fun outOfRangeSource(): Stream<Arguments> = Stream.of(
            arguments(winning, "46", "[ERROR] 1 ~ 45 범위 내 1개의 번호를 입력해주세요."),
            arguments(winning, "52", "[ERROR] 1 ~ 45 범위 내 1개의 번호를 입력해주세요."),
            arguments(winning, "53", "[ERROR] 1 ~ 45 범위 내 1개의 번호를 입력해주세요."),
            arguments(winning, "54", "[ERROR] 1 ~ 45 범위 내 1개의 번호를 입력해주세요."),
            arguments(winning, "55", "[ERROR] 1 ~ 45 범위 내 1개의 번호를 입력해주세요."),
            arguments(winning, "11654121641126411621", "[ERROR] 1 ~ 45 범위 내 1개의 번호를 입력해주세요.")
        )
    }
}