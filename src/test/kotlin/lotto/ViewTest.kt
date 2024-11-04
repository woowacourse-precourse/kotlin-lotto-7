package lotto

import lotto.view.CommandLineView
import lotto.view.View

class ViewTest {

    fun `구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다`() {

    }

    fun `번호는 쉼표(,)를 기준으로 구분한다`() {

    }

    private fun setInput(input: String) {
        System.setIn(input.byteInputStream())
    }
}