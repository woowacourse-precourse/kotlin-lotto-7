package lotto

import lotto.ui.Ui
import lotto.util.keepCallingForSuccessResult

fun main() {
    val ui = Ui()

    val budget = keepCallingForSuccessResult(onFailure = ui::handleFailure, actionToCall = ui::requestBudget)
}

fun Ui.handleFailure(exception: Throwable): Unit = displayExceptionMessage(exception.message)
