package lotto

import camp.nextstep.edu.missionutils.Console

class LottoBuyView {
    fun guidePurchaseAmount() = println("구입금액을 입력해 주세요.")

    fun inputPurchaseAmount() = Console.readLine()

    fun guidePurchaseLottoCount(lottoCount: Int) = println("${lottoCount}개를 구매했습니다.")

    fun guideLottoNumbers(lottoTickets: List<Lotto>) {
        lottoTickets.forEach { lotto ->
            println(lotto.getNumbers())
        }
    }
}