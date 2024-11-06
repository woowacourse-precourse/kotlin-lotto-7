package lotto

import lotto.utils.ValidationUtils

class Lotto(
    private val numbers: List<Int>,
) {
    init {
        ValidationUtils.checkValidLottoNumbers(numbers)
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    fun getWinningRank(winningNumber: List<Int>, bonusNumber: Int): WinningRank {
        return WinningRank.getWinningRank(
            lottoNumber = numbers,
            winningNumbers = winningNumber,
            bonusNumber = bonusNumber,
        )
    }

}
