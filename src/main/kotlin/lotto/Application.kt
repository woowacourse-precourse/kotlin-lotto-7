package lotto

import lotto.data.random.pickLottoNumbers
import lotto.domain.model.factory.LottoFactory
import lotto.ui.Ui

fun main() {
    val ui = Ui()
    val lottoFactory = LottoFactory(lottoNumberGenerator = ::pickLottoNumbers)
    val app = LottoApp(inputView = ui, outputView = ui, lottoFactory = lottoFactory)

    app.run()
}
