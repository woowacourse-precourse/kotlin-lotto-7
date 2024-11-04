package lotto.presenter

import lotto.constants.LottoConstants
import lotto.model.LottoModel
import lotto.utils.LottoGenerator
import lotto.utils.Validator
import lotto.view.interfaces.PurchaseViewInterface
import lotto.view.interfaces.WinningNumberViewInterface

class PurchasePresenter(
  private val purchaseView: PurchaseViewInterface,
  private val winningNumberView: WinningNumberViewInterface,
  private val lottoModel: LottoModel
) {

  private val lottoGenerator = LottoGenerator()

  fun startPurchase() {
    purchaseView.requestPurchaseAmount()
  }

  fun onPurchaseAmountReceived(amount: Int?) {
    try {
      Validator.validatePurchaseAmount(amount)
      val lottoCount = amount!! / LottoConstants.LOTTO_PRICE
      println("${lottoCount}개를 구매했습니다.")

      lottoModel.purchaseAmount = amount
      lottoModel.lottoCount = lottoCount

      // 로또 번호 생성
      val lottos = lottoGenerator.generateLottos(lottoCount)
      lottoModel.generatedLottos.addAll(lottos.map { it.getNumbers() })

      // 생성된 로또 번호 출력
      lottoModel.generatedLottos.forEach { println(it) }

      // 구매 후 당첨 번호 입력 요청
      winningNumberView.requestWinningNumbers()
    } catch (e: IllegalArgumentException) {
      purchaseView.requestPurchaseAmount()
    }
  }
}
