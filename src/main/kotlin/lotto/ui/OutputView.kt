package lotto.ui

import lotto.domain.model.Lotto
import lotto.domain.model.LottoWinPlace

interface OutputView {
    fun displayExceptionMessage(exception: Throwable)
    fun displayAmount(amount: Int)
    fun displayLottoes(lottoes: List<Lotto>)
    fun displayLottoResults(lottoWinPlaces: Map<LottoWinPlace, Int>, budget: Int)
}
