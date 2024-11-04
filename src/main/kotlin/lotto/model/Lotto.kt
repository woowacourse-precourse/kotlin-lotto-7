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
        validateDuplicatedNumber()
    }

    private fun validateLottoSize() {
        require(numbers.size == LOTTO_SIZE) { getErrorMessage(INVALID_LOTTO_SIZE) }
    }

    private fun validateLottoNumber() {
        require(numbers.all { it in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER }) {
            getErrorMessage(INVALID_LOTTO_NUMBER)
        }
    }

    private fun validateDuplicatedNumber(){
         require(numbers.size == numbers.distinct().size) { getErrorMessage(DUPLICATE_LOTTO_NUMBER_ERROR) }
    }

    companion object {
        private const val INVALID_LOTTO_SIZE = "로또 번호는 ${LOTTO_SIZE}개여야 합니다."
        private const val DUPLICATE_LOTTO_NUMBER_ERROR = "로또 번호에 중복된 숫자가 존재합니다."
        private const val INVALID_LOTTO_NUMBER =
            "로또 번호는 $MIN_LOTTO_NUMBER 이상 ${MIN_LOTTO_NUMBER}이하여야 합니다."
    }
}
