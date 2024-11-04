package lotto.ui

import lotto.domain.model.Lotto

interface OutputView {
    fun displayExceptionMessage(exception: Throwable)
    fun displayAmount(amount: Int)
    fun displayLottoes(lottoes: List<Lotto>)
}
