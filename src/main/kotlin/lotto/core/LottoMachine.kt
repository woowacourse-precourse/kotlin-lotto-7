package lotto.core

import camp.nextstep.edu.missionutils.Console
import lotto.data.PurchaseAmount

const val TICKET_PRICE = 1000

class LottoMachine {
    private var purchaseAmount: Int = 0

    fun run() {
        requestPurchaseAmount()
    }

    private fun requestPurchaseAmount() {
        while (true) {
            try {
                println("구입금액을 입력해 주세요.")

                purchaseAmount = PurchaseAmount(Console.readLine(), TICKET_PRICE).getAmount()
                break
            } catch (e: IllegalArgumentException) {
                println("잘못된 입력입니다. 다시 입력해 주세요. ${e.message}")
            }
        }
    }

}