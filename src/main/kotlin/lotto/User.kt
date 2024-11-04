package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.LottoConstants.DELIMITER

class User {
    private fun getUserInput() = Console.readLine()
    fun inputBonusNum(): Int = Console.readLine().toInt()

    fun inputMoney(): String = Console.readLine()

    private fun isValidLottoNumbers(): List<Int> {
        val lottoNumbers = getUserInput()
        CheckInputValidation.validateNull(lottoNumbers)
        return lottoNumbers.split(DELIMITER).map { it.toInt() }
    }

    fun getLottoNumber(): List<Int> {
        return try {
            isValidLottoNumbers()
        } catch (e: IllegalArgumentException) {
            print(e.message)
            getLottoNumber()
        }
    }
}
