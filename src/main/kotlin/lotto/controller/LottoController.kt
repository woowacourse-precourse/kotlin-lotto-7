package lotto.controller

import lotto.view.Input

class LottoController(val input: Input) {
    private fun getLottoTicketCount(): Int {
        return input.getPurchaseAmount() / 1000
    }
}