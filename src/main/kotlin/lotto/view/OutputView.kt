package lotto.view

import lotto.model.LottoTicket

object OutputView {

    fun printLottoTickets(lottoTickets: List<LottoTicket>) {
        println("${lottoTickets.size}개를 구매했습니다.")
        lottoTickets.forEach { println(it.getSortedNumbers()) }
    }
}