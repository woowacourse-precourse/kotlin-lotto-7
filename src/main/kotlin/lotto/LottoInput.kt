package lotto

import camp.nextstep.edu.missionutils.Console

class LottoInput {
    fun getPurchasePrice(): String {
        println(INPUT_PURCHASE_PRICE)
        return Console.readLine()
    }

    companion object {
        private const val INPUT_PURCHASE_PRICE = "구입 금액을 입력해 주세요."
    }
}