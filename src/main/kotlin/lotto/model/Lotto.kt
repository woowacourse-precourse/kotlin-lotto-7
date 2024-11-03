package lotto.model

import lotto.utils.ErrorFormatter.getErrorMessage
import camp.nextstep.edu.missionutils.Randoms
import lotto.constant.LOTTO_SIZE
import lotto.constant.MAX_LOTTO_NUMBER
import lotto.constant.MIN_LOTTO_NUMBER


class Lotto(val numbers: List<Int>) {

    init {
        validateLottoSize()
        validateLottoNumber()
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
        private const val INVALID_LOTTO_NUMBER =
            "로또 번호는 $MIN_LOTTO_NUMBER 이상 ${MIN_LOTTO_NUMBER}이하여야 합니다."
    }
}
