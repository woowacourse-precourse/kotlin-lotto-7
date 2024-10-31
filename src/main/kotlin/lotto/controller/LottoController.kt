package lotto.controller

import lotto.model.lotto.LottoTicket
import lotto.view.InputView
import java.lang.IllegalArgumentException

class LottoController {

    fun generateLottoTickets(purchaseAmount: Int): List<LottoTicket> {
        require(purchaseAmount % 1000 == 0) { " 구입 금액은 1000원 단위여야 합니다." }
        val ticketCount = purchaseAmount / 1000

        val tickets = List(ticketCount) { LottoTicket.generate() }

        return tickets
    }

    fun getNumbers(): Int {
        val purchasePrice = InputView.askForPrice().toIntOrNull() ?: throw IllegalArgumentException("숫자를 입력해주세요")
        return purchasePrice
    }
}