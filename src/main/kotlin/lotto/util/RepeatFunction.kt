package lotto.util

import lotto.view.OutputView

object RepeatFunction {
    fun <T> executeWithRetry(action: () -> T): T {
        while (true) {
            try {
                return action()
            } catch (e: IllegalArgumentException) {
                OutputView.printExceptionMessage(e.message)
            }
        }
    }
}
