package lotto

import lotto.model.LottoTicket
import lotto.presenter.LottoPresenter
import lotto.view.LottoView
import lotto.view.LottoViewImpl

fun main() {
    val view: LottoView = LottoViewImpl()
    val lottoTicket = LottoTicket()
    val presenter = LottoPresenter(view, lottoTicket)

    val price = presenter.getValidLottoPrice()
    presenter.processLottoTickets(price)
    presenter.processWinningNumbers(price)
}
