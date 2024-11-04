package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import validator.LottoGenerator
import validator.RangeValidator

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

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @Test
    fun `리스트 내에 중복 숫자가 있는 경우`() {
        val duplicateValidate = LottoGenerator()
        val numbers = listOf(1, 2, 2, 4, 5, 6)
        assertThrows<IllegalArgumentException>("로또 번호는 중복될 수 없습니다.") {
            duplicateValidate.validate(numbers)
        }
    }

    @Test
    fun `리스트 내에 중복 숫자가 없는 경우`() {
        val duplicateValidate = LottoGenerator()
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        duplicateValidate.validate(numbers)
    }

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
    fun `6개의 숫자를 선택하지 않은 경우`() {
        val rangeValidate = RangeValidator()
        val numbers = listOf(2, 3, 49, 5, 6)
        assertThrows<IllegalArgumentException>("로또는 6개를 선택해야 됩니다.") {
            rangeValidate.validate(numbers)
        }
    }


}
