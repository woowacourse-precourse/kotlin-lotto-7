package lotto

import lotto.data.random.pickLottoNumbers
import lotto.domain.factory.LottoFactory
import lotto.ui.Ui
import lotto.util.keepCallingForSuccessResult

fun main() {
    val ui = Ui()

    val budget = keepCallingForSuccessResult(onFailure = ui::displayExceptionMessage, actionToCall = ui::requestBudget)

    val amount = budget / Lotto.LOTTO_PRICE
    ui.displayAmount(amount)

    val lottoFactory = LottoFactory(lottoNumberGenerator = ::pickLottoNumbers)
    val lottoes = lottoFactory.createLottoes(amount)
    ui.displayLottoes(lottoes)
}
