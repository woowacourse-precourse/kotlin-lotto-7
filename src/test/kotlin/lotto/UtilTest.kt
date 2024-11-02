package lotto

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import util.convertRoundAtTwoDecimal
import util.convertWithDigitComma

class UtilTest {

    @ParameterizedTest
    @MethodSource("천단위_쉼표로_문자열_분리_테스트용_데이터")
    fun `천단위_쉼표로_문자열_분리_테스트`(변경할_숫자: Int, 기댓값: String) {

        // when
        val 결과 = 변경할_숫자.convertWithDigitComma()

        //then
        assertTrue(결과 == 기댓값)
    }

    @ParameterizedTest
    @MethodSource("소수점_이하_한자리로_반올림_테스트용_데이터")
    fun `소수점_이하_한자리로_반올림_테스트`(변경할_숫자: Double, 기댓값: String) {

        //when
        val 결과 = 변경할_숫자.convertRoundAtTwoDecimal()

        //then
        assertTrue(결과 == 기댓값)
    }

    companion object {
        @JvmStatic
        fun `천단위_쉼표로_문자열_분리_테스트용_데이터`() = listOf(
            Arguments.of(100, "100"),
            Arguments.of(1000, "1,000"),
            Arguments.of(10000, "10,000"),
            Arguments.of(100000, "100,000"),
            Arguments.of(1000000, "1,000,000"),
            Arguments.of(10000000, "10,000,000"),
            Arguments.of(100000000, "100,000,000"),
            Arguments.of(1000000000, "1,000,000,000"),
        )

        @JvmStatic
        fun `소수점_이하_한자리로_반올림_테스트용_데이터`() = listOf(
            Arguments.of(1.99, "2.0"),
            Arguments.of(1.34, "1.3"),
            Arguments.of(1234.1234, "1234.1"),
            Arguments.of(1234.1735, "1234.2"),
            Arguments.of(100.1, "100.1")
        )
    }
}