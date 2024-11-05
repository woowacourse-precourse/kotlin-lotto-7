package lotto

import camp.nextstep.edu.missionutils.Console

lateinit var hitNumbers: List<Int>

fun main() {
    val money = inputHowMuch()
    val myLottos = makeMyLotto(money)
    hitNumbers = inputHitNumbers()
    val bonusNumber = inputBonusNumber()
    result(money, myLottos, bonusNumber)
}

fun result(money: Int, myLottos: List<Lotto>, bonusNumber: Int) {
    val myRewards = mutableListOf<Reward>()
    repeat(myLottos.size) { it
        myRewards += paperMatching(myLottos, bonusNumber, it)
    }
    resultOutput(money, myRewards)
}

fun resultOutput(money: Int, myRewards: List<Reward>) {
    val incomeRate = (myRewards.sumOf { it.money }.toDouble()/money.toDouble())*100
    val resultMessage = "당첨 통계\n" +
            "---\n" +
            "3개 일치 (5,000원) - ${myRewards.count { it == Reward.MATCH3 }}개\n" +
            "4개 일치 (50,000원) - ${myRewards.count { it == Reward.MATCH4 }}개\n" +
            "5개 일치 (1,500,000원) - ${myRewards.count { it == Reward.MATCH5 }}개\n" +
            "5개 일치, 보너스 볼 일치 (30,000,000원) - ${myRewards.count { it == Reward.MATCH5BONUS }}개\n" +
            "6개 일치 (2,000,000,000원) - ${myRewards.count { it == Reward.MATCH6 }}개\n" +
            "총 수익률은 ${String.format("%.2f",incomeRate).toDouble()}%입니다."
    println(resultMessage)
}

fun paperMatching(myLottos: List<Lotto>, bonusNumber: Int, turn: Int): Reward {
    val paper = myLottos[turn].getNumbers()
    val matchedCount = paper.intersect(hitNumbers.toSet()).count()
    return getReward(matchedCount, matchedCount == 5 && checkBonus(paper, bonusNumber))
}

fun checkBonus(numbers: List<Int>, bonusNumber: Int): Boolean {
    return numbers.contains(bonusNumber)
}

fun getReward(matchedCount: Int, hasBonus: Boolean): Reward {
    return when {
        matchedCount == 6 -> Reward.MATCH6
        matchedCount == 5 && hasBonus -> Reward.MATCH5BONUS
        matchedCount == 5 -> Reward.MATCH5
        matchedCount == 4 -> Reward.MATCH4
        matchedCount == 3 -> Reward.MATCH3
        else -> Reward.NONE
    }
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
    require(input !in hitNumbers) {
        println(exceptionMessage)
        throw IllegalArgumentException(exceptionMessage)
    }
}

fun inputHitNumbers(): List<Int> {
    val inputMessage = "당첨 번호를 입력해 주세요."
    println(inputMessage)
    val inputHit = Console.readLine()
    return validateHitNumbers(inputHit)
}

fun validateHitNumbers(input: String): List<Int> {
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
    require(
        parsedInput.groupingBy { it }.eachCount()
            .all { 1 == it.value }) {
        println(exceptionMessage)
        throw IllegalArgumentException(exceptionMessage) }
}

fun validateBetween1And45(input: Any, min: Int = 1, max: Int = 45) {
    val exceptionMessage = "[ERROR] $min 이상 $max 이하의 숫자여야 합니다."
    when (input) {
        is Int -> require(input in min..max) { exceptionMessage }
        is List<*> -> require((input as List<Int>).all { it in min..max }) { exceptionMessage }
        else -> throw IllegalArgumentException("[ERROR] 잘못된 데이터 타입입니다.")
    }
}


fun parseByComma(input: String): List<Int> {
    return input.split(",").map { it.toInt() }.toList()
}

fun validatePattern(input: String) {
    val exceptionMessage = "[ERROR] 숫자,숫자,숫자,숫자,숫자,숫자 패턴이 아닙니다."
    val pattern = Regex("^(\\d+,){5}\\d+$") // 예: 1,2,3,4,5,6 형식
    require(pattern.matches(input)) {
        println(exceptionMessage)
        throw IllegalArgumentException(exceptionMessage)
    }
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
    require(input.isNotEmpty()) {
        println(exceptionMessage)
        throw IllegalArgumentException(exceptionMessage)
    }
}

fun validateBlank(input: String) {
    val exceptionMessage = "[ERROR] 입력에 공백만이 있습니다."
    require(input.isNotBlank()) {
        println(exceptionMessage)
        throw IllegalArgumentException(exceptionMessage)
    }
}

fun validateBecomeNumber(input: String) {
    val exceptionMessage = "[ERROR] 정수로 변환할수 없습니다"
    require(input.toIntOrNull() is Int) {
        println(exceptionMessage)
        throw NumberFormatException(exceptionMessage)
    }
}

fun validateNaturalNumber(input: String) {
    val exceptionMessage = "[ERROR] 자연수가 아닙니다."
    require(0 < input.toInt()) {
        println(exceptionMessage)
        throw IllegalArgumentException(exceptionMessage)
    }
}

fun validate1000won(input: String) {
    val exceptionMessage = "[ERROR] 1000원 단위가 아닙니다."
    require(input.toInt() % 1000 == 0) {
        println(exceptionMessage)
        throw IllegalArgumentException(exceptionMessage)
    }
}
