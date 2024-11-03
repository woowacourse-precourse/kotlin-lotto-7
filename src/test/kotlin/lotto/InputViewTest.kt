package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputViewTest {
    @Test
    fun `구매금액이 숫자가 아닌 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            ExceptionProcess.validPrice("hello")
            ExceptionProcess.validPrice("-1000")
        }
    }

    @Test
    fun `구매금액이 1000원 미만인 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            ExceptionProcess.validPrice("900")
        }
    }

    @Test
    fun `당첨번호가 1~45사이의 숫자가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            ExceptionProcess.validLottoNumber("1,2,3,4,5,333")
        }
    }

    @Test
    fun `당첨번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            ExceptionProcess.validLottoNumber("1, 2, 3, 4, 5, 6, 7")
        }
    }

    @Test
    fun `당첨번호의 개수가 6개 미만이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            ExceptionProcess.validLottoNumber("1, 2, 3, 4, 5")
        }
    }

    // TODO: 테스트가 통과하도록 프로덕션 코드 구현
    @Test
    fun `당첨번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            ExceptionProcess.validLottoNumber("1, 2, 3, 4, 5, 5")
        }
    }

    @Test
    fun `당첨번호가 오름차순이 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            ExceptionProcess.validLottoNumber("1, 3, 2, 4, 5, 6")
        }
    }

    @Test
    fun `당첨번호가 문자이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            ExceptionProcess.validLottoNumber("1, 3, 2, 4, 5, 6")
        }
    }

    @Test
    fun `보너스 번호가 숫자가 아닌 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            ExceptionProcess.validPrice("hello")
            ExceptionProcess.validPrice("-1000")
        }
    }

    @Test
    fun `보너스 번호가 1~45사이의 숫자가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            ExceptionProcess.validLottoNumber("1,2,3,4,5,333")
        }
    }
}