package lotto

import camp.nextstep.edu.missionutils.Console

fun inputMoney() : Int {
    while (true) {
        println("구입금액을 입력해 주세요.")
        val input = Console.readLine()

        try {
            return validMoney(input)
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

fun validMoney(input: String) : Int  {
    val money = input.toIntOrNull()
        ?: throw IllegalArgumentException(ErrorMessage.MONEY_VALID_ERROR.message)

    if (money < 1000) {
        throw IllegalArgumentException(ErrorMessage.MONEY_ERROR.message)
    }
    if (money % 1000 != 0) {
        throw IllegalArgumentException (ErrorMessage.MONEY_DIVIDE_ERROR.message)
    }
    calculateTicket(money)
    return money
}

fun calculateTicket(money: Int) : Int {
    val ticketCount = money / 1000
    println("$ticketCount 개를 구매했습니다.")
    return ticketCount
}

fun inputLottoNumbers() : List<Int> {
    while (true) {
        println("당첨 번호를 입력해 주세요 (쉼표로 구분)")

        val inputNum = Console.readLine()
        try {
            val lottoNumbers = validLottoNum(inputNum)
            Lotto(lottoNumbers)
            return lottoNumbers
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

fun validLottoNum (input : String) : List<Int> {
    val numbers = input.split(",").map { it.trim() }

    if (numbers.any { it.toIntOrNull() == null }) {
        throw IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_FORMAT_ERROR.message)
    }

    return numbers.map { it.toInt() }
}

fun inputBonusNumber(lottoNumbers: List<Int>) : Int {
    while (true) {
        println("보너스 번호를 입력해주세요.")

        val input = Console.readLine()

        try {
            return validBonusNumber(input,lottoNumbers)
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

fun validBonusNumber(input : String, lottoNumbers : List<Int>) : Int {
    val bonusNum = input.toIntOrNull()
        ?: throw IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_FORMAT_ERROR.message)

    if (bonusNum !in 1..45) throw IllegalArgumentException(ErrorMessage.LOTTO_RANGE_ERROR.message)
    if (bonusNum in lottoNumbers) throw IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATION_ERROR.message)

    return bonusNum
}