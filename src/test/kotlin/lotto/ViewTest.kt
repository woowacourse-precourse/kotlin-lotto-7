package lotto

import lotto.view.CommandLineView
import lotto.view.View

class ViewTest {
    val view: View = CommandLineView()

    fun `구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다`() {

    }
}