package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.LottoConstants.LOTTO_NUMBER_MAX
import lotto.LottoConstants.LOTTO_NUMBER_MIN
import lotto.LottoConstants.LOTTO_NUMBER_SIZE

class LottoNumberGenerator : LottoGenerator {

    override fun generate(): List<Int> {
        val randomLottoNumber = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_SIZE)
        return checkRandomLottoNumber(randomLottoNumber)
    }

    private fun checkRandomLottoNumber(randomNum: List<Int>): List<Int> {
        if (randomNum.distinct().size > 6) generate()
        return isSortedLottoNumber(randomNum)
    }

    private fun isSortedLottoNumber(randomNum: List<Int>): List<Int> {
        return randomNum.sorted()
    }

}
