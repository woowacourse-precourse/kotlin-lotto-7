package lotto.model

import camp.nextstep.edu.missionutils.Console

class LottoPurchase {

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
        val input = Console.readLine() // 문자열로 입력 받기
        // 입력값이 비어있지 않은지 확인
        if (input.isBlank()) {
            throw NumberFormatException("입력이 비어있습니다.")
        }
        val amount = input.toIntOrNull() // 문자열을 정수로 변환, 실패시 null 반환
        requireNotNull(amount) { "[ERROR] 유효한 숫자(정수)를 입력해야 합니다." }
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
