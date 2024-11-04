package lotto.View

import camp.nextstep.edu.missionutils.Console
import lotto.InputValidation
import lotto.Lotto
import lotto.LottoResult

class InputView {
    fun inputPurchaseLotto(): Int {
        println("구입금액을 입력해 주세요.")

        while (true) {
            try {
                val lottoPayment = Console.readLine().toIntOrNull()
                        ?: throw IllegalArgumentException("[ERROR] 구입 금액은 숫자로 입력해야 합니다.")

                return lottoAmount
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }

    }

    fun inputLottoNum(): List<String> {
        println("당첨 번호를 입력해 주세요.")

        while (true) {
            try {
                val lottoNum = Console.readLine().split(",")

                return lottoNum
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun inputBonusLottoNum(lottoNum: List<Int>): Int {
        println("보너스 번호를 입력해 주세요.")
        while (true) {
            try {
                val bonusLottoNum = Console.readLine().toIntOrNull()
                    ?: throw IllegalArgumentException("[ERROR] 구입 금액은 숫자로 입력해야 합니다.")

                return bonusLottoNum
            } catch (e: IllegalArgumentException) {
                // 예외 메시지를 출력하고 재입력을 받도록 한다.
                println(e.message)
            }
        }
    }
}