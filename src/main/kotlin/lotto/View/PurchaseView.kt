package lotto.View

import camp.nextstep.edu.missionutils.Console
import lotto.Model.User
import lotto.Util.Validator

class PurchaseView {
    // 구매할 로또의 개수 반환
    fun getPurchaseLottoCount(): Int {
        while (true) {
            try {
                println(PROMPT_MESSAGE)
                val input = Console.readLine()
                val amount = Validator.validatePurchaseInput(input) // 유효성 검사
                val purchasedLottoCount = amount / 1000 // 구매할 로또 개수
                return purchasedLottoCount
            } catch (e: IllegalArgumentException) {
                println(e.message) // [ERROR]로 시작하는 에러 메시지 출력
            }
        }
    }

    fun displayLottos(user: User) {
        println("\n${user.purchasedLottos.size}$PROMPT_PURCHASE_MESSAGE")
        user.purchasedLottos.forEach { lotto ->
            println(lotto.getNumbers())
        }
    }

    companion object {
        const val PROMPT_MESSAGE = "구입금액을 입력해 주세요."
        const val PROMPT_PURCHASE_MESSAGE = "개를 구매했습니다."
    }
}