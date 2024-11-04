package lotto

import lotto.view.CommandLineView
import lotto.view.View

fun main() {
    Application().run()
}

class Application {
    private val view: View = CommandLineView()
    fun run() {
        view.buyLottos()
        view.displayWinningLottos()
        view.readUserLottoNumbers()
        view.readUserBonusNumbers()
        view.displayLottoResult()
        view.displayReturnRate()
    }
}