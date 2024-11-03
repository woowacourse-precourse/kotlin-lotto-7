package view

class OutputView {

    fun printLottoNumbers(count: Int, lottos: ArrayList<List<Int>>) {
        println()
        println(AMOUNT_NOTICE.format(count))
        for (i in 0..lottos.lastIndex) {
            println(lottos[i])
        }
        println()
    }

    fun printLottoWins(winInfo: Pair<List<Int>, Double>) {
        val winCount = winInfo.first
        val winRate = winInfo.second
        println()
        println(WIN_STATIC_NOTICE)
        println(FIFTH_WIN_NOTICE.format(winCount[4]))
        println(FORTH_WIN_NOTICE.format(winCount[3]))
        println(THIRD_WIN_NOTICE.format(winCount[2]))
        println(SECOND_WIN_NOTICE.format(winCount[1]))
        println(FIRST_WIN_NOTICE.format(winCount[0]))
        println(RATE_NOTICE.format(winRate))
    }

    companion object {
        const val AMOUNT_NOTICE = "%d개를 구매했습니다."
        const val WIN_STATIC_NOTICE = "당첨 통계\n---"
        const val FIFTH_WIN_NOTICE = "3개 일치 (5,000원) - %d개"
        const val FORTH_WIN_NOTICE = "4개 일치 (50,000원) - %d개"
        const val THIRD_WIN_NOTICE = "5개 일치 (1,500,000원) - %d개"
        const val SECOND_WIN_NOTICE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"
        const val FIRST_WIN_NOTICE = "6개 일치 (2,000,000,000원) - %d개"
        const val RATE_NOTICE = "총 수익률은 %.1f%%입니다."
    }
}