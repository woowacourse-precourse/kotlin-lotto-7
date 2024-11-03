package view

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InputViewTest : NsTest() {
    @Test
    fun `입력 테스트`() {
        run("5000")
        assertThat(output()).contains(InputView.BILL_REQUIREMENT)
    }

    override fun runMain() {
        InputView().start()
    }
}