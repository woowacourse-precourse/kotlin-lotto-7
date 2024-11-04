package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    val money = inputHowMuch()
    val myLottos = makeMyLotto(money)
    println()
}

fun makeMyLotto(money: Int): List<Lotto> {
    val amount = howManyBuy(money)
    return List(amount) { Lotto() }
}

fun howManyBuy(money: Int): Int {
    val amount = money / 1000
    val amountMessage = "개를 구매했습니다."
    println("$amount$amountMessage")
    return amount
}

fun inputHowMuch(): Int {
    val inputMessage = "구입금액을 입력해 주세요."
    println(inputMessage)
    val money = Console.readLine()
    Console.close()
    validateMoney(money)
    return money.toInt()
}

fun validateMoney(input: String) {
    validateEmpty(input)
    validateBlank(input)
    validateBecomeNumber(input)
    validateNaturalNumber(input)
    validate1000won(input)
}

fun validateEmpty(input: String) {
    val exceptionMessage = "[ERROR] 입력이 들어오지 않았습니다."
    require(input.isNotEmpty()) { throw IllegalArgumentException(exceptionMessage) }
}

fun validateBlank(input: String) {
    val exceptionMessage = "[ERROR] 입력에 공백만이 있습니다."
    require(input.isNotBlank()) { throw IllegalArgumentException(exceptionMessage) }
}

fun validateBecomeNumber(input: String) {
    val exceptionMessage = "[ERROR] 정수로 변환할수 없습니다."
    require(input.toIntOrNull() is Int) { throw NumberFormatException(exceptionMessage) }
}

fun validateNaturalNumber(input: String) {
    val exceptionMessage = "[ERROR] 자연수가 아닙니다."
    require(0 < input.toInt()) { throw IllegalArgumentException(exceptionMessage) }
}

fun validate1000won(input: String) {
    val exceptionMessage = "[ERROR] 1000원 단위가 아닙니다."
    require(input.toInt() % 1000 == 0) { throw IllegalArgumentException(exceptionMessage) }
}
