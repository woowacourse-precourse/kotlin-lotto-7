package lotto

import lotto.domain.generator.LottoGenerator
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val game =
        LottoGame(
            LottoGenerator(),
            InputView(),
            OutputView(),
        )
    game.play()
}
