package lotto.view

import lotto.Constants.OUTPUT_LOTTO_TICKET_COUNT_MESSAGE
import lotto.Constants.OUTPUT_LOTTO_WINNING_MESSAGE
import lotto.model.LottoRank

class OutputView {
    fun countTicketsMessage(ticket: Int) {
        print("\n" + String.format(OUTPUT_LOTTO_TICKET_COUNT_MESSAGE, ticket))
    }

    fun generateTicketsMessage(tickets: List<List<Int>>) {
        tickets.forEach { ticket ->
            print("\n" + ticket.sorted())
        }
    }

    fun displayWinningMessage() {
        println("\n$OUTPUT_LOTTO_WINNING_MESSAGE")
        println("---")
        LottoRank.values().forEach { rank ->
            if (rank != LottoRank.THREE_MATCH) print("\n")
            if (rank == LottoRank.FIVE_MATCH_WITH_BONUS) {
                print("${rank.matchCount}개 일치, 보너스 볼 일치 (${rank.prizeString}원) - ${rank.count}개")
            }
            print("${rank.matchCount}개 일치 (${rank.prizeString}원) - ${rank.count}개")
        }
    }

    fun displayProfitPercentage(percentage: Double) {
        print("\n총 수익률은 ${percentage}%입니다.")
    }
}