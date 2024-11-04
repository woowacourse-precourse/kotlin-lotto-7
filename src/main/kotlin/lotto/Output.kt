package lotto

import java.text.DecimalFormat


class Output {

    fun printLottoNumbers(numbers: MutableList<List<Int>>) {
        println(numbers.size.toString() + LOTTO_COUNT_PRINT)
        numbers.forEach { println(it) }
    }

    private fun matchPrint(rank : RANK, matchNumber: Int){
        val moneyFormat = DecimalFormat("#,###")
        println("${MATCH[rank]}개 일치${if(rank == RANK.SECOND) ", 보너스 볼 일치" else ""} (${moneyFormat.format(PRIZE[rank])}원) - ${matchNumber}개")
    }
    fun printPrize(ranks : MutableMap<RANK, Int>, rate : Double) {
        println(PRIZE_PRINT)
        println(LINE_PRINT)
        val rateFormat = DecimalFormat("#0.0")
        for (rank in ranks){
            if(rank.key != RANK.OTHERS) matchPrint(rank.key, rank.value)
        }
        println("총 수익률은 ${rateFormat.format(rate)}%입니다.")
    }


    companion object {
        private const val LOTTO_COUNT_PRINT = "개를 구매했습니다."
        private const val PRIZE_PRINT = "당첨 통계"
        private const val LINE_PRINT = "---"
    }
}