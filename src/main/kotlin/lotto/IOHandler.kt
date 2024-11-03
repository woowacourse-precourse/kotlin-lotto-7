package lotto

class IOHandler {
    fun inputToUser(instruction: String): String {
        println(instruction)
        return readLine() ?: EXCEPTIONOFNULL
    }

    fun outputForPurchasedLotto(purchasedLotto: PurchasedLotto) {
        val output = StringBuilder()

        output.append("\n", purchasedLotto.amountOfLotto, "개를 구매했습니다.")
        purchasedLotto.purchasedLotto.forEach { output.append("\n", it) }
        println(output)
    }

    fun outputForZeroOfLotto() {
        println(EXITLOTTONUMBERGENERATOR)
    }

    fun outputForWinningStaus(winningStatus: Map<Int, Int>, rankStandard: Map<Int, WinnerRank>, rateOfReturn: String) {
        val output = StringBuilder()

        output.append("\n당첨 통계", "\n---")
        winningStatus.forEach {
            output.append("\n")
            output.append(outputForWinningRank(rankStandard[it.key]!!, it.value))
        }
        output.append("\n총 수익률은 $rateOfReturn%입니다.")
        println(output)
    }

    private fun outputForWinningRank(winnerRank: WinnerRank, amount: Int): String {
        return "${winnerRank.standard} (${Formatting().formatPrice(winnerRank.prize)}원) - ${amount}개"
    }

    companion object {
        const val EXCEPTIONOFNULL = "입력값을 확인할 수 없습니다. 다시 입력해주세요."
        const val EXITLOTTONUMBERGENERATOR = "지불하신 금액이 0원이므로 종료합니다."
    }
}