package lotto.ui.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.entity.Lotto

class LottoBuyView {
    fun guidePurchaseAmount() = println(INPUT_PURCHASE_AMOUNT_MESSAGE)

    fun inputPurchaseAmount() = Console.readLine()

    fun guidePurchaseLottoCount(lottoCount: Int) = println("$lottoCount" + LOTTO_PURCHASE_MESSAGE)

    fun guideLottoNumbers(lottoTickets: List<Lotto>) {
        lottoTickets.forEach { lotto ->
            println(lotto.getNumbers())
        }
    }

    companion object {
        private const val INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요."
        private const val LOTTO_PURCHASE_MESSAGE = "개를 구매했습니다."
    }
}