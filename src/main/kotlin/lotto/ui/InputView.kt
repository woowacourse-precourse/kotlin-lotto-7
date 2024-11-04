package lotto.ui

interface InputView {
    fun requestBudget(): Result<Int>
    fun requestWinningNumbers(): Result<List<Int>>
    fun requestBonusWinningNumber(winningNumbers: List<Int>): Result<Int>
}
