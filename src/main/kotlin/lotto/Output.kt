package lotto

import lotto.CustomException.*
import lotto.LottoType.BONUS
import lotto.LottoType.LOTTO

class Output {

    companion object {
        const val BONUSBALL = 3
        const val PLUSCORRECTNUM = 3
        const val BONUSCORRECT = 5

    }

    fun output(message: String) = println(message)
    fun outPutMoney() {
        println("구입금액을 입력해 주세요.")
    }

    fun outPutTicket(ticket: Int, lottoList: List<List<Int>>) {
        println("\n${ticket}개를 구매했습니다.")
        for (list in lottoList) {
            println(list)
        }
    }

    fun printCustomMessage(customException: CustomException) {
        when (customException) {
            DIVIDE -> throw IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.")
            NUMBER -> throw IllegalArgumentException("[ERROR] 티켓은 양의 정수만 입력할 수 있습니다.")
            INTEGER -> throw IllegalArgumentException("[ERROR] 티켓은 1000원 단위로만 입력할 수 있습니다.")
            BLANK -> throw IllegalArgumentException("[ERROR] 로또 번호가 비어있습니다.")
            BOUNDARY -> throw IllegalArgumentException("[ERROR] 로또 번호는 1이상 45이하의 정수여야 합니다.")
        }
    }

    fun outPutCorrectNumber() = println("\n당첨 번호를 입력해 주세요.")
    fun outPutBonusNumber() = println("\n보너스 번호를 입력해 주세요.")

}