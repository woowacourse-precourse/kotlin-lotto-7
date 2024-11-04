package lotto

import lotto.model.LottoTicket
import lotto.presenter.LottoPresenter
import lotto.view.LottoView
import lotto.view.LottoViewImpl

fun main() {
    val view: LottoView = LottoViewImpl()
    val lottoTicket = LottoTicket()
    val presenter = LottoPresenter(view, lottoTicket)

    val price = view.getTicketsPrice()
    presenter.processLottoTickets(price)

    val winningNumbers = view.getWinningNumbers()
    val bonusNumbers = view.getBonusNumber()
    presenter.processWinningNumbers(winningNumbers, bonusNumbers)
}
