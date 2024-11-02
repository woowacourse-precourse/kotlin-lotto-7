package lotto

import lotto.controller.InputController
import lotto.controller.MainController
import lotto.repository.Repository
import lotto.view.InputView

fun main() {
    val mainController = MainController(InputController(Repository()))
    mainController.run()
}
