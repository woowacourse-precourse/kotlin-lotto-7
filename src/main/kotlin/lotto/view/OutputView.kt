package lotto.view

import lotto.constants.ViewConstant
import lotto.repository.Repository

class OutputView(
    private val repo: Repository
) {
    fun printLottos() {
        println(String.format(ViewConstant.OUTPUT_PRINT_LOTTO, repo.lottos.size))
        for (i in repo.lottos) {
            println(i.getNumber())
        }
    }

    fun printResult() {
        println(ViewConstant.OUTPUT_PRINT_WINNING_STATISTICS)
        println(String.format(ViewConstant.OUTPUT_PRINT_MATCH_3_COUNT, repo.result.match3Count))
        println(String.format(ViewConstant.OUTPUT_PRINT_MATCH_4_COUNT, repo.result.match4Count))
        println(String.format(ViewConstant.OUTPUT_PRINT_MATCH_5_COUNT, repo.result.match5Count))
        println(String.format(ViewConstant.OUTPUT_PRINT_MATCH_5_COUNT_AND_BONUS, repo.result.match5AndBonusCount))
        println(String.format(ViewConstant.OUTPUT_PRINT_MATCH_6_COUNT, repo.result.match6Count))
        println(String.format(ViewConstant.OUTPUT_PRINT_TOTAL_PROFIT, repo.result.totalProfit))
    }
}