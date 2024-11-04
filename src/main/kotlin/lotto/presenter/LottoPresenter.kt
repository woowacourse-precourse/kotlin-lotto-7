package lotto.presenter

import lotto.constants.LottoConstants
import lotto.utils.LottoGenerator
import lotto.view.interfaces.PurchaseViewInterface

class LottoPresenter(private val view: PurchaseViewInterface) {

  private val lottoGenerator = LottoGenerator()

  fun start() {
    view.requestPurchaseAmount() // 구입 금액 입력 요청
  }

  fun onPurchaseAmountReceived(amount: Int) {
    val lottoCount = amount / LottoConstants.LOTTO_PRICE
    println("$lottoCount 개를 구매했습니다.")

    // n개의 로또 번호 생성 및 출력
    val lottos = lottoGenerator.generateLottos(lottoCount)
    lottos.forEach { println(it.getNumbers()) }

    // 당첨 번호 입력 요청
  }
}
