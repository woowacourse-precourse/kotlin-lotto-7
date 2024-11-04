package lotto.config

import lotto.LottoApplication
import lotto.view.InputViewImpl
import lotto.view.OutputViewImpl

object ApplicationFactory {
    fun createLottoApplication(): LottoApplication {
        val inputView = InputViewImpl()
        val outputView = OutputViewImpl()
        return LottoApplication(inputView, outputView)
    }
}