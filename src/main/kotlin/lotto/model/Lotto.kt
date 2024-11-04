package lotto.model

import lotto.constants.ErrorMessages.ERROR_LOTTO_NUMBER_DUPLICATE
import lotto.constants.ErrorMessages.ERROR_LOTTO_NUMBER_RANGE
import lotto.constants.ErrorMessages.ERROR_LOTTO_SIZE
import lotto.constants.LottoNumbers.LOTTO_MAXIMUM_NUMBER
import lotto.constants.LottoNumbers.LOTTO_MINIMUM_NUMBER
import lotto.constants.LottoNumbers.LOTTO_NUMBER_SIZE

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == LOTTO_NUMBER_SIZE) { ERROR_LOTTO_SIZE }
        require(numbers.all { it in LOTTO_MINIMUM_NUMBER..LOTTO_MAXIMUM_NUMBER }) { ERROR_LOTTO_NUMBER_RANGE }
        require(numbers.distinct().size == LOTTO_NUMBER_SIZE) { ERROR_LOTTO_NUMBER_DUPLICATE }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    fun getSortedNumbers(): List<Int> {
        return numbers.sorted()
    }

    fun compareWinningLotto(winningLotto: WinningLotto): LottoPrize {
        var matchingCount = 0
        var isMatchingBonusNumber = false

        numbers.forEach { lottoNumber ->
            if (winningLotto.lotto.numbers.contains(lottoNumber)) {
                matchingCount++
            }

            if (lottoNumber == winningLotto.bonusNumber) {
                isMatchingBonusNumber = true
            }
        }

        return LottoPrize.fromMatchingCount(matchingCount, isMatchingBonusNumber)
    }
}
