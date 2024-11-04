package lotto

class Broadcast {
    fun printInputPaymentMassage() {
        println(PURCHASE_PAYMENT_MESSAGE)
    }

    fun printLottoNumbers(purchaseLotto: List<Lotto>) {
        printLottoQuantity(purchaseLotto.size)
        purchaseLotto.forEach {
            println(it.getLottoNumbers())
        }
    }

    private fun printLottoQuantity(count: Int) {
        println("\n$count$PURCHASE_LOTTO_COUNT_MESSAGE")
    }

    fun printWinningNumberMessage() {
        println("\n$WINNING_NUMBER_MESSAGE")
    }

    fun printInputBonusNumberMessage() {
        println("\n$INPUT_BONUS_NUMBER_MESSAGE")
    }

    fun printWinningStatistics(winningMessage: List<String>) {
        println(WINNING_STATISTICS)
        winningMessage.forEach {
            println(it)
        }
    }

    companion object {
        const val PURCHASE_PAYMENT_MESSAGE = "구입금액을 입력해 주세요."
        const val PURCHASE_LOTTO_COUNT_MESSAGE = "개를 구매했습니다."
        const val WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요."
        const val INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요."
        const val WINNING_STATISTICS = "\n당첨 통계\n---\n"
    }
}