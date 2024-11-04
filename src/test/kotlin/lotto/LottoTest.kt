package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import validator.*

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
    fun `보너스 번호와 뽑은 로또 번호가 중복인 경우`() {

        val randomLottoNum: List<Int> = listOf(1, 2, 3, 4, 5, 6)
        val stringValidator: StringGenerator = StringValidator()
        val rangeValidator: NumbersValidator = RangeValidator()

        val checkLottoNum = BonusNumberValidator(randomLottoNum, stringValidator, rangeValidator)
        val bonusNumbers = "6"

        assertThrows<IllegalArgumentException>("보너스는 뽑은 값과 중복될 수 없습니다.") {
            checkLottoNum.validate(bonusNumbers)
        }
    }

    @Test
    fun `로또 번호가 1 ~ 45 사이의 숫자가 아니면 예외를 발생`() {
        assertThrows<IllegalArgumentException>("로또 번호는 1 ~ 45 사이여야 합니다") {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }


}
