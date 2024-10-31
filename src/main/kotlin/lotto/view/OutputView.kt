package lotto.view

import lotto.model.PrizeNumber

class OutputView {
    fun printRequirePaymentMessage() {
        println(MESSAGE_INPUT_PAYMENT)
    }

    fun printAmountTickets(tickets: Int) {
        println()
        println("$tickets$PRINT_AMOUNT_TICKETS")
    }

    fun printInformationLotto(lotto: List<List<Int>>) {
        println(lotto.joinToString(LINE_FEED))
    }

    fun printRequirePrizeNumber() {
        println()
        println(MESSAGE_PRIZE_NUMBER)
    }

    fun printRequireBonusNumber() {
        println()
        println(MESSAGE_BONUS_NUMBER)
    }

    fun printResult(prizeResult: MutableMap<PrizeNumber, Int>, earningRate: Double) {
        val sb = StringBuilder(MESSAGE_RESULT)
        sb.append("$PRINT_RESULT_THREE${prizeResult[PrizeNumber.FIFTH]}$UNIT_CORRECT")
        sb.append("$PRINT_RESULT_FOUR${prizeResult[PrizeNumber.FOURTH]}$UNIT_CORRECT")
        sb.append("$PRINT_RESULT_FIVE${prizeResult[PrizeNumber.THIRD]}$UNIT_CORRECT")
        sb.append("$PRINT_RESULT_FIVE_WITH_BONUS${prizeResult[PrizeNumber.SECOND]}$UNIT_CORRECT")
        sb.append("$PRINT_RESULT_ALL${prizeResult[PrizeNumber.FIRST]}$UNIT_CORRECT")
        sb.append("$RESULT$earningRate$RESULT_SECOND")
        println(sb)
    }

    companion object {
        private const val MESSAGE_INPUT_PAYMENT = "구입금액을 입력해 주세요."
        private const val PRINT_AMOUNT_TICKETS = "개를 구매했습니다."
        private const val MESSAGE_PRIZE_NUMBER = "당첨 번호를 입력해 주세요."
        private const val MESSAGE_BONUS_NUMBER = "보너스 번호를 입력해 주세요."
        private const val LINE_FEED = "\n"
        private const val MESSAGE_RESULT = "당첨 통계\n---\n"
        private const val PRINT_RESULT_THREE = "3개 일치 (5,000원) - "
        private const val PRINT_RESULT_FOUR = "4개 일치 (50,000원) - "
        private const val PRINT_RESULT_FIVE = "5개 일치 (1,500,000원) - "
        private const val PRINT_RESULT_FIVE_WITH_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - "
        private const val PRINT_RESULT_ALL = "6개 일치 (2,000,000,000원) - "
        private const val UNIT_CORRECT = "개\n"
        private const val RESULT = "총 수익률은 "
        private const val RESULT_SECOND = "%입니다."
    }
}