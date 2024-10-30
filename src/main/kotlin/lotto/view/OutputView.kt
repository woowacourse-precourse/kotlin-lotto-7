package lotto.view

class OutputView {
    fun printRequirePaymentMessage() {
        println(MESSAGE_INPUT_PAYMENT)
    }

    fun printAmountTickets(tickets: Int) {
        println()
        println("$tickets$PRINT_AMOUNT_TICKETS")
    }

    fun printInformationLotto(lotto: List<List<Int>>) {
        println(lotto.joinToString("\n"))
    }

    fun printRequirePrizeNumber(){
        println()
        println(MESSAGE_PRIZE_NUMBER)
    }

    companion object {
        private const val MESSAGE_INPUT_PAYMENT = "구입금액을 입력해 주세요."
        private const val PRINT_AMOUNT_TICKETS = "개를 구매했습니다."
        private const val MESSAGE_PRIZE_NUMBER = "당첨 번호를 입력해 주세요."
    }
}