package lotto.util
import lotto.util.ConstantsUtil.MESSAGE_NUMBER_SIZE_ERROR
object ValidatorUtil {
    fun validateLottoSize(lottoSize: Int) {
        require(lottoSize == 6) {
            MESSAGE_NUMBER_SIZE_ERROR
        }
    }
}