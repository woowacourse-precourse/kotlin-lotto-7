package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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

    @Test
    fun `로또 번호 생성 정상 확인`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                val lottoNumber = LottoNumbering().lottoNumbering()
                assertThat(lottoNumber).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
            }, listOf(5, 4, 3, 2, 1, 6)
        )
    }

    @Test
    fun `로또 번호 숫자 6개 예외 함수`() {
        assertThrows<IllegalArgumentException> {
            Validation().isAmountOfNumberSix(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `로또 번호 범위 예외 함수`() {
        assertThrows<IllegalArgumentException> {
            Validation().isNumbersRange1To45(listOf(0, 1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `로또 번호 중복 예외 함수`() {
        assertThrows<IllegalArgumentException> {
            Validation().isNumbersNotDuplicate(listOf(1, 2, 3, 3, 4, 5))
        }
    }

    @Test
    fun `당첨 번호 입력시 공백 제거`() {
        assertThat(DrawingWinningNumbers().deleteBlank("1, 2, 3, 4, 5, 6")).isEqualTo("1,2,3,4,5,6")
    }

    @Test
    fun `당첨 번호 타입 숫자로 이루어진 리스트로 변경`() {
        assertThat(DrawingWinningNumbers().transferType("1,2,3,4,5,6")).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }
}