package lotto

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BillValidatorTest : NsTest() {
    @Test
    fun `구입 금액이 1000보다 작으면 예외가 발생한다`() {
        BillValidator().billCheck(500)
        assertThat(output()).contains(ErrorMessage.BILLS_NOT_ENOUGH.getMessage())
    }

    @Test
    fun `구입 금액이 1000 단위가 아니면 예외가 발생한다`() {
        BillValidator().billCheck(1200)
        assertThat(output()).contains(ErrorMessage.BILLS_NOT_DIVIDED.getMessage())
    }

    override fun runMain() {
        main()
    }
}