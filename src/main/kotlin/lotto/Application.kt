package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("구입 금액을 입력해 주세요.")
    do {
        try {
            val number = getAmount()
            println(number)
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