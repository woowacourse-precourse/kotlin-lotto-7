package lotto.controller

import camp.nextstep.edu.missionutils.Console.readLine
import lotto.LottoAmount
import lotto.LottoService

class LottoController {
    private val lottoService = LottoService()

    fun start() {
        println("구입금액을 입력해 주세요.")
        val inputAmount = readLine()
        require(inputAmount.isNotBlank()) { "[ERROR] 공백은 입력할 수 없습니다." }
        val amount =
            LottoAmount(
                inputAmount.toIntOrNull()
                    ?: throw IllegalArgumentException("[ERROR] 정수만 입력할 수 있습니다.")
            )


    }
}