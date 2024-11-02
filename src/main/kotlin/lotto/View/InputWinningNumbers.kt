package lotto.View

import camp.nextstep.edu.missionutils.Console

fun inputWinningNumbers(): List<Int> {
    println("당첨 번호를 입력해 주세요.")
    return readAndValidateNumbers()
}

private fun readAndValidateNumbers(): List<Int> {
    return try {
        val numbers = readNumbers()
        validateNumbers(numbers)
        numbers
    } catch (e: NumberFormatException) {
        println("[ERROR] 번호는 숫자로 입력해야 합니다.")
        inputWinningNumbers()
    } catch (e: IllegalArgumentException) {
        println(e.message)
        inputWinningNumbers()
    }
}

private fun readNumbers(): List<Int> {
    return Console.readLine()
        .split(",")
        .map { it.trim().toInt() }
}

private fun validateNumbers(numbers: List<Int>) {
    require(numbers.size == 6) { "[ERROR] 당첨 번호는 6개여야 합니다." }
    require(numbers.all { num -> num in 1..45 }) { "[ERROR] 번호는 1에서 45 사이 정수여야 합니다." }
}
