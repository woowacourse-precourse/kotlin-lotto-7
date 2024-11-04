package lotto

import lotto.utils.ValidationUtils

class Lotto(
    val numbers: List<Int>,
) {
    init {
        ValidationUtils.checkValidLottoNumbers(numbers)
    }

    fun getWinningRank(winningNumber: List<Int>, bonusNumber: Int): WinningRank {
        return WinningRank.getWinningRank(
            lottoNumber = numbers,
            winningNumbers = winningNumber,
            bonusNumber = bonusNumber,
        )
    }

}
