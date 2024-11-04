package lotto

import lotto.LottoConstants.LOTTO_NUMBER_RANGE
import lotto.LottoConstants.LOTTO_PRICE
import lotto.LottoConstants.MINIMUM_PRICE


class LottoSeller() {
    fun generateLottoNumbers(lottoMoney: Int): List<LottoNumberGenerator> {

        val result = mutableListOf<LottoNumberGenerator>()
        repeat(lottoMoney) {
            result.add(LottoNumberGenerator())
        }
        return result
    }

    fun checkTicketMoneyValidate(lottoMoney: String): String {
        CheckInputValidation.checkInteger(lottoMoney)
        require((lottoMoney.toInt() % LOTTO_PRICE) == MINIMUM_PRICE) { ErrorMessage.NUMBER_UNIT.getMessage() }
        return lottoMoney
    }

    fun lottoTicketCount(lottoMoney: String): Int {
        return lottoMoney.toInt() / LOTTO_PRICE
    }


    fun checkLottoHasBonusNum(lottoList: List<Int>, bonusNum: Int): Int {
        checkContainNum(lottoList, bonusNum)
        checkBonusLength(bonusNum)
        return bonusNum
    }

    private fun checkContainNum(lottoList: List<Int>, bonusNum: Int): Int {
        require(!lottoList.contains(bonusNum)) { ErrorMessage.NUMBER_DISTINCT.getMessage() }
        return bonusNum
    }

    private fun checkBonusLength(bonusNum: Int): Int {
        require(bonusNum in LOTTO_NUMBER_RANGE) { ErrorMessage.NUMBER_RANGE.getMessage() }
        return bonusNum
    }
}
