package lotto.model

import lotto.utils.ErrorFormatter.getErrorMessage
import camp.nextstep.edu.missionutils.Randoms
import constant.LOTTO_SIZE
import constant.MAX_LOTTO_NUMBER
import constant.MIN_LOTTO_NUMBER


class Lotto() {
    val numbers: Set<Int>

    init {
        numbers = makeLotto()
        validateLottoSize()
        validateLottoNumber()
    }

    private fun makeLotto(): Set<Int> {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE).toSortedSet()
    }

    private fun validateLottoSize() {
        require(numbers.size == LOTTO_SIZE) { getErrorMessage(INVALID_LOTTO_SIZE) }
    }

    private fun validateLottoNumber() {
        require(numbers.all { it in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER }) {
            getErrorMessage(INVALID_LOTTO_NUMBER)
        }
    }

    companion object {
        private const val INVALID_LOTTO_SIZE = "로또 번호는 ${LOTTO_SIZE}개여야 합니다."
        private const val INVALID_LOTTO_NUMBER = "로또 번호는 $MIN_LOTTO_NUMBER 이상 ${MIN_LOTTO_NUMBER}이하여야 합니다."
    }
}
