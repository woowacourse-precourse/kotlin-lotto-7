package lotto.model

import camp.nextstep.edu.missionutils.Console

class LottoPurchase {
    fun displayPurchaseCount(count: Int) {
        println("${count}개를 구매했습니다.")
    }

    fun getPurchaseAmount(): Int {
        while (true) {
            try {
                return readPurchaseAmount()
            } catch (e: NumberFormatException) {
                println("[ERROR] 유효한 숫자(정수)를 입력해야 합니다.")
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun readPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val input = Console.readLine()
        val amount = input.toInt()
        validatePurchaseAmount(amount)
        return amount
    }

    private fun validatePurchaseAmount(amount: Int) {
        require(amount % 1000 == 0) { "[ERROR] 구입 금액은 1,000원 단위여야 합니다." }
    }

    fun calculateLottoCount(amount: Int): Int {
        return amount / 1000
    }
}
