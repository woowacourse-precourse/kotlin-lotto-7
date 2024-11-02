package view

class OutputView {

    fun printLottoNumbers(count: Int, lottos: List<List<Int>>) {
        println()
        println(amountNotice.format(count))
        for (i in 0..lottos.lastIndex) {
            println(lottos[i])
        }
        println()
    }

    companion object {
        const val amountNotice = "%d개를 구매했습니다."
        const val winStaticNotice = "당첨 통계"
        const val fifthWinNotice = "3개 일치 (5,000원) - %d개"
        const val forthWinNotice = "4개 일치 (50,000원) - %d개"
        const val thirdWinNotice = "5개 일치 (1,500,000원) - %d개"
        const val secondWinNotice = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"
        const val firstWinNotice = "6개 일치 (2,000,000,000원) - %d개"
        const val rateNotice = "총 수익률은 %f%입니다."
    }
}