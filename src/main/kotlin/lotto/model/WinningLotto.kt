package lotto.model

import lotto.constant.BonusResult
import lotto.utils.ErrorFormatter.getErrorMessage
import lotto.constant.LOTTO_SIZE
import lotto.constant.LottoRank
import lotto.constant.MAX_LOTTO_NUMBER
import lotto.constant.MIN_LOTTO_NUMBER

class WinningLotto(winningLottoInput: String) {
    val winningNumbers: Set<Int>
    var bonusNumber: Int? = null

    init {
        winningNumbers = validateWinningLotto(winningLottoInput)
    }

    fun countMatchCount(lotto: Lotto): Int =
        winningNumbers.count { winningNumber -> lotto.numbers.contains(winningNumber) }

    fun checkMatchedBonusNumber(lotto: Lotto): BonusResult {
        if (lotto.numbers.contains(bonusNumber)) return BonusResult.BONUS_MATCH
        return BonusResult.BONUS_MISMATCH
    }

    fun getRank(lotto: Lotto): LottoRank = LottoRank.convertToRank(countMatchCount(lotto), checkMatchedBonusNumber(lotto))


    private fun validateWinningLotto(input: String): Set<Int> {
        val numbers = input.split(",").map { it.trim() }
        validateWinningLottoLength(numbers)
        val validatedNumbers = validateWinningLottoNumber(numbers)
        validateNoDuplicateWinningLotto(validatedNumbers)

        return validatedNumbers
    }

    private fun validateWinningLottoLength(numbers: List<String>) {
        require(numbers.size == LOTTO_SIZE) { getErrorMessage(INVALID_WINNING_NUMBERS_SIZE) }
    }

    private fun validateWinningLottoNumber(numbers: List<String>): Set<Int> {
        val validatedNumbers = numbers.map { numberString ->
            val number = requireNotNull(numberString.toIntOrNull()) {
                getErrorMessage(INVALID_WINNING_LOTTO_NUMBER)
            }

            require(number in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) {
                getErrorMessage(INVALID_WINNING_LOTTO_NUMBER)
            }
            number
        }.toSet()

        return validatedNumbers
    }

    private fun validateNoDuplicateWinningLotto(numbers : Set<Int>) {
        require(numbers.size == LOTTO_SIZE) {
            getErrorMessage(INVALID_WINNING_LOTTO_DUPLICATE)
        }
    }

    fun setBonusNumber(bonusNumberInput: String) {
        bonusNumber = validateBonusNumber(bonusNumberInput)
    }

    private fun validateBonusNumber(bonusNumberInput: String): Int {
        val bonusNumber = requireNotNull(bonusNumberInput.toIntOrNull()) {
            getErrorMessage(INVALID_BONUS_NUMBER)
        }

        require(bonusNumber >= MIN_LOTTO_NUMBER && bonusNumber <= MAX_LOTTO_NUMBER) {
            getErrorMessage(getErrorMessage(INVALID_BONUS_NUMBER))
        }

        validateNoDuplicateNumber(bonusNumber)

        return bonusNumber
    }

    private fun validateNoDuplicateNumber(bonusNumber: Int) {
        require(!winningNumbers.contains(bonusNumber)) {
            getErrorMessage(INVALID_BONUS_NUMBER_DUPLICATE)
        }
    }

    companion object {
        private const val INVALID_WINNING_NUMBERS_SIZE = "당첨 번호는 ${LOTTO_SIZE}개여야 합니다."
        private const val INVALID_WINNING_LOTTO_NUMBER =
            "당첨 번호는 ${MIN_LOTTO_NUMBER}과 ${MAX_LOTTO_NUMBER}사이 숫자만 가능합니다."
        private const val INVALID_BONUS_NUMBER =
            "보너스 번호는 ${MIN_LOTTO_NUMBER}과 ${MAX_LOTTO_NUMBER}사이 숫자만 가능합니다."
        private const val INVALID_WINNING_LOTTO_DUPLICATE =
            "당첨 번호는 중복될 수 없습니다."
        private const val INVALID_BONUS_NUMBER_DUPLICATE =
            "보너스 번호는 당첨 번호에 있는 숫자와 중복될 수 없습니다."
    }
}