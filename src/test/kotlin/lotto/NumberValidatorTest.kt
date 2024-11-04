package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import validator.LottoGenerator
import validator.RangeValidator

class NumberValidatorTest {
    @Test
    fun `1~45 사이의 숫자를 뽑은 경우`() {
        val rangeValidate = LottoGenerator()
        val numbers = listOf(1, 2, 3, 45, 5, 6)
        rangeValidate.validate(numbers)
    }

    @Test
    fun `1~45 사이의 숫자를 뽑지 않은 경우`() {
        val rangeValidate = RangeValidator()
        val numbers = listOf(0, 2, 3, 49, 5, 6)
        assertThrows<IllegalArgumentException>("로또 번호는 1~45 사이의 값이여야 합니다.") {
            rangeValidate.validate(numbers)
        }
    }

    @Test
    fun `로또 개수를 6개 고르지 않았을 때`() {
        val rangeValidate = RangeValidator()
        val numbers = listOf(2, 3, 49, 5, 6)
        assertThrows<IllegalArgumentException>("로또는 6개를 선택해야 됩니다.") {
            rangeValidate.validate(numbers)
        }
    }

    @Test
    fun `6개의 숫자를 선택했을 때`() {
        val rangeValidate = RangeValidator()
        val numbers = listOf(1, 2, 3, 39, 5, 6)
        rangeValidate.validate(numbers)
    }

}