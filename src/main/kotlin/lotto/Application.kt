package lotto

import lotto.controller.MainController
import lotto.repository.Repository

fun main() {
    val mainController = MainController(Repository())
    mainController.run()
}
