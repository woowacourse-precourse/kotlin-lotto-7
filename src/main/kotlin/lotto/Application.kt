package lotto

import camp.nextstep.edu.missionutils.Console

lateinit var hitNumbers : List<Int>

fun main() {
    val money = inputHowMuch()
    val myLottos = makeMyLotto(money)
    hitNumbers = inputHitNumbers()
    val bonusNumber = inputBonusNumber()
}

fun inputBonusNumber(): Int {
    val inputMessage = "보너스 번호를 입력해 주세요."
    println(inputMessage)
    val inputBonus = Console.readLine()
    validateBonusNumber(inputBonus)
    return inputBonus.toInt()
}

fun validateBonusNumber(inputBonus: String) {
    validateEmpty(inputBonus)
    validateBlank(inputBonus)
    validateBecomeNumber(inputBonus)
    validateBetween1And45(inputBonus.toInt())
    validateDuplicateWithHit(inputBonus.toInt())
}

fun validateDuplicateWithHit(input: Int) {
    val exceptionMessage = "[ERROR] 당첨 숫자와 중복 될 수 없습니다"
    require(input !in hitNumbers){throw IllegalArgumentException(exceptionMessage)}
}

fun inputHitNumbers(): List<Int> {
    val inputMessage = "당첨 번호를 입력해 주세요."
    println(inputMessage)
    val inputHit = Console.readLine()
    return validateHitNumbers(inputHit)
}

fun validateHitNumbers(input: String) : List<Int> {
    validateEmpty(input)
    validateBlank(input)
    validatePattern(input)
    val parsedInput = parseByComma(input)
    validateBetween1And45(parsedInput)
    validateDuplicate(parsedInput)
    return parsedInput
}

fun validateDuplicate(parsedInput: List<Int>) {
    val exceptionMessage = "[ERROR] 중복된 숫자가 존재하면 안 됩니다."
    require(parsedInput.groupingBy { it }.eachCount().all { 1 == it.value }){throw IllegalArgumentException(exceptionMessage)}
}

fun validateBetween1And45(parsedInput: List<Int>) {
    val exceptionMessage = "[ERROR] 1이상 45이하의 숫자여야 합니다."
    require(parsedInput.all { it in Lotto.MIN_LOTTO_NUMBER..Lotto.MAX_LOTTO_NUMBER }) { throw IllegalArgumentException(exceptionMessage) }
}

fun validateBetween1And45(input: Int) {
    val exceptionMessage = "[ERROR] 1이상 45이하의 숫자여야 합니다."
    require(input in Lotto.MIN_LOTTO_NUMBER..Lotto.MAX_LOTTO_NUMBER ) { throw IllegalArgumentException(exceptionMessage) }
}

fun parseByComma(input: String): List<Int> {
    return input.split(",").map { it.toInt() }.toList()
}

fun validatePattern(input: String) {
    val exceptionMessage = "[ERROR] 숫자,숫자,숫자,숫자,숫자,숫자 패턴이 아닙니다."
    val pattern = Regex("^(\\d+,){5}\\d+$") // 숫콤숫콤숫콤숫콤숫콤숫(숫 : 숫자, 콤 : 콤마)
    require(pattern.matches(input)) { throw IllegalArgumentException(exceptionMessage) }
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
