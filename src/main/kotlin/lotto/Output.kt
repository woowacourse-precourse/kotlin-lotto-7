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
            DUPLICATE -> throw IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.")
            RANGE -> throw IllegalArgumentException("[ERROR] 입력한 값이 Int 범위를 벗어났습니다")
        }
    }

    private fun outPutCorrectNumber() = println("\n당첨 번호를 입력해 주세요.")
    private fun outPutBonusNumber() = println("\n보너스 번호를 입력해 주세요.")
    fun outPutPostCorrectList(result: MutableList<Int>) {
        println("\n당첨 통계\n---")
        for (i in 0 until result.size - 1) {
            outPutCorrectList(i, result)
        }
    }

    private fun outPutCorrectList(correct: Int, result: MutableList<Int>) {
        if (correct == BONUSBALL) {
            println("${BONUSCORRECT}개 일치, 보너스 볼 일치 (${resultScoreBoard(converterCorrectType(correct + PLUSCORRECTNUM))}원) - ${result[correct]}개")
            println("${BONUSCORRECT + 1}개 일치 (${resultScoreBoard(converterCorrectType(correct + PLUSCORRECTNUM + 1))}원) - ${result[correct + 1]}개")
            return
        }
        println("${correct + PLUSCORRECTNUM}개 일치 (${resultScoreBoard(converterCorrectType(correct + PLUSCORRECTNUM))}원) - ${result[correct]}개")
    }

    fun printLotto(lottoType: LottoType) =
        when (lottoType) {
            BONUS -> outPutBonusNumber()
            LOTTO -> outPutCorrectNumber()
        }

    fun printRate(money: Long, ticket: Int) {
        val rate = rateCalc(money, ticket)
        if (rate < 0) {
            println("총 수익률은 ${-rate}%입니다.")
        } else {
            println("총 수익률은 ${rate}%입니다.")
        }
    }

    private fun rateCalc(money: Long, ticket: Int): Double {
        val dMoney = money.toDouble()
        val dTicket = ticket.toDouble()
        val percentage = (dMoney / dTicket) * 100
        return Math.round(percentage * 100) / 100.0 // 소수 둘째 자리 반올림
    }

    fun converterCorrectType(correctCount: Int): CorrectType {
        return when (correctCount) {
            7 -> CorrectType.SIX
            6 -> CorrectType.BONUS
            5 -> CorrectType.FIVE
            4 -> CorrectType.FORE
            3 -> CorrectType.THREE
            else -> CorrectType.NO
        }
    }


    fun resultScore(correctType: CorrectType): Int {
        return when (correctType) {
            CorrectType.BONUS -> 30000000
            CorrectType.THREE -> 5000
            CorrectType.FORE -> 50000
            CorrectType.FIVE -> 1500000
            CorrectType.SIX -> 2000000000
            CorrectType.NO -> 0
        }
    }

    private fun resultScoreBoard(correctType: CorrectType): String {
        return when (correctType) {
            CorrectType.BONUS -> "30,000,000"
            CorrectType.THREE -> "5,000"
            CorrectType.FORE -> "50,000"
            CorrectType.FIVE -> "1,500,000"
            CorrectType.SIX -> "2,000,000,000"
            CorrectType.NO -> "0"
        }
    }
}