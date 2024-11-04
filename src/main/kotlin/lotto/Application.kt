package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms



fun main() {
    val amount = readAndValidateAmount()
    val numberOfLottos = calculateNumberOfLottos(amount)
    println("${numberOfLottos}개를 구매했습니다.")
    generateLottos(numberOfLottos)

    val winningNumbers = readLottoNumber()
    val bonusNumber = readBonusNumber(winningNumbers)

}

fun readAndValidateAmount(): Int {
    while (true) {
        try {
            val amount = promptUserForAmount()
            Validation.validateAmount(amount) // 이 부분도 try 블록 안에 포함됨
            return amount
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

fun promptUserForAmount(): Int {
    println("구입금액을 입력해 주세요.")
    val input = Console.readLine()?.trim()
    return Validation.parseAmount(input)
}

fun calculateNumberOfLottos(amount: Int): Int {
    println()
    return amount / 1000
}

fun generateLottos(count: Int) {
    repeat(count) {
        val lottoNumbers = generateRandomLottoNumbers()
        println(lottoNumbers)
    }
}

fun generateRandomLottoNumbers(): List<Int> {
    return Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
}

fun readLottoNumber(): List<Int> {
    while (true) {
        try {
            val lottoNum = promptUserForLotto()
            Validation.validateLottoNumbers(lottoNum)
            return lottoNum
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

fun promptUserForLotto(): List<Int> {
    println("\n당첨 번호를 입력해 주세요.")
    val input = Console.readLine()?.trim()
    return Validation.parseLottoNumbers(input)
}

fun readBonusNumber(winningNumbers: List<Int>): Int {
    while (true) {
        try {
            println("\n보너스 번호를 입력해 주세요.")
            val input = Console.readLine()?.trim()
            return Validation.validateBonusNumber(input, winningNumbers)
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}
