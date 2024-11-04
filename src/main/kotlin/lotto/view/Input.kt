package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.validation.InputValidation

class Input {
    private val inputValidation = InputValidation()

    fun getPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val value = readLine().let {
            inputValidation.typeInt(it).also { amount ->
                inputValidation.unitOfNumber(amount, 1000)
            }
        }
        println()
        return value
    }

    fun getLottoNumbers(): List<Int> {
        println("당첨 번호를 입력해 주세요.")
        val value = readLine().let {
            inputValidation.lottoNumbers(inputValidation.lottoNumbersDelimiter(it))
        }
        println()
        return value
    }

    fun getLottoBonusNumber(): Int {
        println("보너스 번호를 입력해주세요.")
        val value = readLine().let {
            inputValidation.typeInt(it).also { number ->
                inputValidation.lottoNumberRange(number)
            }
        }
        println()
        return value
    }

    private fun readLine(): String = Console.readLine()
}