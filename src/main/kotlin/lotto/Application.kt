package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val purchase = LottoPurchase()
    val purchaseAmount = purchase.getPurchaseAmount()
    val lottoCount = purchase.calculateLottoCount(purchaseAmount)

    val lottoIssue = LottoIssue()
    val issuedLottos = lottoIssue.issueLottos(lottoCount)

    purchase.displayPurchaseCount(issuedLottos.size)
    issuedLottos.forEach { println(it) }
}

class LottoIssue {
    // 로또 번호 한 세트를 생성
    fun issueLotto(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
    }

    // 여러 개의 로또 발행
    fun issueLottos(count: Int): List<List<Int>> {
        return List(count) { issueLotto() }
    }
}

class LottoPurchase{

    fun displayPurchaseCount(count: Int) {
        println("${count}개를 구매했습니다.")
    }

    fun getPurchaseAmount(): Int {
        while (true) {
            try {
                println("구입금액을 입력해 주세요.")
                val input = Console.readLine()
                val amount = input.toInt()
                require(amount % 1000 == 0) { "[ERROR] 구입 금액은 1,000원 단위여야 합니다." }
                return amount
            } catch (e: NumberFormatException) {
                println("[ERROR] 유효한 숫자를 입력해야 합니다.")
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
    fun calculateLottoCount(amount: Int): Int {
        return amount / 1000
    }
}