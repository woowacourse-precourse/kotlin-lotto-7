package lotto

import lotto.ui.Ui

fun main() {
    val ui = Ui()

    val budget = keepRequestingForValidBudget(ui)
}

private fun keepRequestingForValidBudget(ui: Ui): Int {
    while (true) {
        ui.requestBudget().onSuccess { budget ->
            return budget
        }.onFailure { exception ->
            ui.displayExceptionMessage(exception.message)
        }
    }
}
