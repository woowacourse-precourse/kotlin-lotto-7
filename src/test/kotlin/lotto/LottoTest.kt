package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows


class LottoTest : NsTest() {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 테스트가 통과하도록 프로덕션 코드 구현
    @Test
    fun `로또 번호를 정상적으로 넣었을 때의 경우`() {
        assertDoesNotThrow { Lotto(listOf(1, 2, 3, 4, 5, 6)) }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))

        }
    }

    @Test
    fun `보너스 값이 숫자가 아닐 때 예외 테스트`() {
        assertSimpleTest {
            runException("10000", "1,2,3,4,5,6", "A")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `보너스 값이 범위를 벗어날 때 예외 테스트`() {
        assertSimpleTest {
            runException("10000", "1,2,3,4,5,6", "50")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `리스트에서 맞는 갯수 찾는 테스트`() {
        var lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        lotto.bonusNumber = 22
        assertThat(lotto.findNumbers(listOf(2, 3, 4, 5, 6, 7))).isEqualTo(5)
    }

    @Test
    fun `리스트에서 맞는 보너스 찾는 테스트`() {
        var lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        lotto.bonusNumber = 22
        assertThat(lotto.findBonus(listOf(1, 2, 3, 4, 5, 22))).isEqualTo(true)
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE: String = "[ERROR]"
    }
}
