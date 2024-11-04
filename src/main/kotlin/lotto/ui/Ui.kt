package lotto.ui

import lotto.ui.console.ConsoleInputView
import lotto.ui.console.ConsoleOutputView

class Ui : OutputView by ConsoleOutputView(), InputView by ConsoleInputView()
