package lotto

import model.Lotto
import values.Content

class CheckError {
    fun validateLotto(lotto: Lotto) {
        validateNumberCount(lotto)
        validateUniqueNumbers(lotto)
    }

    private fun validateNumberCount(lotto: Lotto) {
        if (lotto.getNumbers().size != 6) {
            throw IllegalArgumentException(Content.ERROR_OF_COUNT_SIX)
        }
    }

    private fun validateUniqueNumbers(lotto: Lotto) {
        if (lotto.getNumbers().size != lotto.getNumbers().toSet().size) {
            throw IllegalArgumentException(Content.ERROR_OF_SAME)
        }
    }
}