package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("구입 금액을 입력해 주세요.")
    var lottos: ArrayList<Lotto>
    do {
        try {
            val number = getAmount()
            println()
            println("${number}개를 구매했습니다.")

            lottos = createLottos(number)
            printLottos(lottos)

        } catch (e: IllegalArgumentException) {
            println(e.message)
            continue
        }
        break
    } while (true)
}

fun getAmount(): Int {
    val amount = Console.readLine().toInt()
    return checkAmount(amount)
}

fun checkAmount(amount: Int): Int {
    if (amount % 1000 != 0) {
        throw IllegalArgumentException("[ERROR] 1,000원 단위로만 구매 가능합니다. 구입 금액을 다시 입력해주세요.")
    }
    return amount / 1000
}

fun createLottos(number: Int): ArrayList<Lotto> {
    val lottos = ArrayList<Lotto>()
    for (i in 0 until number) {
        lottos.add(Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
    }
    return lottos
}

fun printLottos(lottos: ArrayList<Lotto>) {
    lottos.forEach {
        println(it.getNumbers())
    }
    println()
}