package lotto.view

import lotto.model.Lotto

interface OutputView {
    fun printNewLine()
    fun printPurchaseSummary(lottoBundle: List<Lotto>)
}