package validator

import camp.nextstep.edu.missionutils.test.NsTest
import lotto.main
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoValidatorTest : NsTest() {
    @Test
    fun `로또 번호가 6개가 아니면 예외가 발생한다`() {
        LottoValidator().lottoCheck(listOf(1,2,3,4,5))
        assertThat(output()).contains(ErrorMessage.LOTTO_NOT_SIX.getMessage())
    }

    @Test
    fun `로또 번호가 1에서 45 범위가 아니면 예외가 발생한다`() {
        LottoValidator().lottoCheck(listOf(1,2,3,4,5,46))
        assertThat(output()).contains(ErrorMessage.LOTTO_OUT_OF_BOUND.getMessage())
    }

    override fun runMain() {
        main()
    }
}