package lotto.controller

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto

class LottoController {
    fun runLottoMachine() {
        val purchaseAmount = getPurchaseAmount()
        val lottos = purchaseLottos(purchaseAmount)
        printLottos(lottos)
    }
}

fun getPurchaseAmount(): Int {
    println("구입금액을 입력해 주세요.")
    val input = Console.readLine()
    return try {
        val amount = input.toInt()
        validatePurchaseAmount(amount)
        amount
    } catch (e: Exception) {
        println("[ERROR] 구입 금액은 1,000원 단위의 숫자로 입력해야 합니다.")
        getPurchaseAmount()
    }
}

fun validatePurchaseAmount(amount: Int) {
    if (amount % 1000 != 0 || amount <= 0 || amount > 1_000_000) {
        throw IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 1,000,000원 이하이어야 합니다.")
    }
}

fun purchaseLottos(amount: Int): List<Lotto> {
    val numberOfTickets = amount / 1000
    return List(numberOfTickets) { Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)) }
}

fun printLottos(lottos: List<Lotto>) {
    println("${lottos.size}개를 구매했습니다.")
    lottos.forEach { println(it.getNumbers().sorted()) }
}
