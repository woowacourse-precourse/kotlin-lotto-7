package lotto.converter

import lotto.exception.ExceptionCode
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoArgumentConverterTest {

    @Test
    fun `toLottoArgument()는 쉼표를 구분자로 구분하고 List 컬렉션에 Int 자료형으로 변환 후 반환한다`() {
        // given
        val input = "1,2,3,4,5,6"
        val expected = listOf(1, 2, 3, 4, 5, 6)

        // when
        val actual = LottoArgumentConverter.toLottoArgument(input)

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun `toLottoArgument()는 쉼표 구분자로 구분 후 숫자가 아닌 문자가 존재하면 예외를 발생시킨다`() {
        // given
        val input = "1,2,3,4,a,6"
        val expectedMessage = ExceptionCode.INVALID_NUMERIC.getMessage()

        // when && then
        assertThatIllegalArgumentException().isThrownBy {
            LottoArgumentConverter.toLottoArgument(input)
        }.withMessage(expectedMessage)
    }

    @Test
    fun `toBonusNumberArgument()는 문자열을 숫자로 변환 후 반환한다`(){
        // given
        val input = "10"
        val expected = 10

        // when
        val actual = LottoArgumentConverter.toBonusNumberArgument(input)

        // then
        Assertions.assertSame(expected, actual)
    }

    @Test
    fun `toBonusNumberArgument()는 문자열을 숫자로 변환하지 못하면 예외를 발생시킨다`(){
        // given
        val input = "1o"
        val expectedMessage = ExceptionCode.INVALID_NUMERIC.getMessage()

        // when && then
        assertThatIllegalArgumentException().isThrownBy {
            LottoArgumentConverter.toBonusNumberArgument(input)
        }.withMessage(expectedMessage)

    }

}
