package lotto

import lotto.ui.Ui
import lotto.util.keepCallingForSuccessResult

fun main() {
    val ui = Ui()

    val budget = keepCallingForSuccessResult(onFailure = ui::displayExceptionMessage, actionToCall = ui::requestBudget)
}
