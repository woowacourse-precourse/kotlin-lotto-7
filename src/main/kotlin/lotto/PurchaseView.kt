package lotto

import camp.nextstep.edu.missionutils.Console

class PurchaseView {
    fun getPurchaseLottoCount(): Int {
        println(PROMPT_MESSAGE)
        val input = Console.readLine()
        val purchasedLottoCount = input?.toInt()?.div(1000) ?: 0 // 구매하는 로또의 개수
        println("\n${purchasedLottoCount}$PURCHASE_MESSAGE")
        return purchasedLottoCount
    }

    companion object {
        const val PROMPT_MESSAGE = "구입금액을 입력해 주세요."
        const val PURCHASE_MESSAGE = "개의 로또를 구매합니다."
    }
}