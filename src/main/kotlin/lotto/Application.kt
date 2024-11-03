package lotto

fun main() {
    val lottoMachine = LottoMachine()
    val winningNumber = WinningNumbers(DrawingWinningNumbers().drawingWinningNumbers())
    val bonusNumber = BonusNumber(DrawingWinningNumbers().drawingBonusNumber(winningNumber))

    TotalLottoResult(lottoMachine.purchasedLotto, winningNumber, bonusNumber)
}
