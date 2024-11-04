package lotto

class Lotto(
    private val numbers: List<Int>,
) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }

    fun getWinningRank(winningNumber: List<Int>, bonusNumber: Int): WinningRank {
        return WinningRank.getWinningRank(
            lottoNumber = numbers,
            winningNumbers = winningNumber,
            bonusNumber = bonusNumber,
        )
    }

}
