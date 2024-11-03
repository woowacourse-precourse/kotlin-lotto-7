package lotto.view

interface InputView {
    fun readPurchaseAmount(): String
    fun readWinningNumbers(): String
    fun readBonusNumber(): String
}