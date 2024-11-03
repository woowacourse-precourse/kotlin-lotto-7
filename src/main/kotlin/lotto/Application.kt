package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

enum class LottoError(val message: String) {
    INVALID_AMOUNT("[ERROR] 유효한 금액을 입력해주세요."),
    INVALID_UNIT("[ERROR] 로또 금액은 1000원 단위로 입력해야 합니다."),
    INVALID_NUM("[ERROR] 1~45 사이의 중복되지 않는 6개의 숫자를 입력해 주세요."),
    INVALID_SPLIT("[ERROR] 유효한 구분자와 숫자를 사용해 주세요."),
    INVALID_DUPLICATE("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    fun throwException(): IllegalArgumentException {
        return IllegalArgumentException(this.message)
    }
}

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
            Validation.validateLottoNumbers(lottoNum) // 번호 유효성 검증
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
