package lotto.view

class LottoOutputView {
    fun outputPurchasePrice() {
        println(LottoOutputText.INPUT_PURCHASE_PRICE_TEXT)
    }

    fun outputLottoList(lottoList: List<List<Int>>) {
        println("${lottoList.size}${LottoOutputText.LOTTO_GENERATE_FINISH_TEXT}")
        lottoList.forEach { lotto ->
            println(lotto)
        }
    }

    fun outputWinningNumber() {
        println(LottoOutputText.INPUT_WINNING_NUMBERS)
    }

    fun outputBonusNumber() {
        println(LottoOutputText.INPUT_BONUS_NUMBER)
    }

    fun outputLottoResult(
        printableRankList: List<String>,
        winningRankCountList: List<Int>,
        rateOfReturn: String,
    ) {
        println(LottoOutputText.LOTTO_WINNING_RESULT_TITLE)
        println(LottoOutputText.LOTTO_WINNING_RESULT_SEPARATE_LINE)

        printableRankList.forEachIndexed { index, printableRank ->
            println("$printableRank - ${winningRankCountList[index]}개")
        }

        println(
            "${LottoOutputText.LOTTO_WINNING_RESULT_TOTAL_RATE_OF_RETURN} " +
                    "$rateOfReturn${LottoOutputText.LOTTO_WINNING_RESULT_TOTAL_RATE_OF_RETURN_2}"
        )
    }

    fun printErrorMessage(message: String) {
        newLine()
        println(message)
        newLine()
    }

    fun newLine() = println()
}