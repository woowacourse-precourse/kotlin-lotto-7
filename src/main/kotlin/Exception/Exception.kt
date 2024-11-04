package Exception

import View.OutputView

object Exception {
    fun throwException(message: String): Nothing {
        OutputView.printExceptionMessage(message)
        throw IllegalArgumentException(message)
    }
}