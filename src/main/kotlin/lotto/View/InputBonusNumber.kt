package lotto.View

import camp.nextstep.edu.missionutils.Console

fun inputBonusNumber(winningNumbers: List<Int>): Int {
    println("보너스 번호를 입력해 주세요.")
    return readAndValidateBonusNumber(winningNumbers)
}

private fun readAndValidateBonusNumber(winningNumbers: List<Int>): Int {
    return try {
        val bonus = readBonusNumber()
        validateBonusNumber(bonus, winningNumbers)
        bonus
    } catch (e: NumberFormatException) {
        println("[ERROR] 보너스 번호는 숫자로 입력해야 합니다.")
        inputBonusNumber(winningNumbers)
    } catch (e: IllegalArgumentException) {
        println(e.message)
        inputBonusNumber(winningNumbers)
    }
}

private fun readBonusNumber(): Int {
    return Console.readLine().toInt()
}

private fun validateBonusNumber(bonus: Int, winningNumbers: List<Int>) {
    require(bonus in 1..45) { "[ERROR] 보너스 번호는 1에서 45 사이의 정수여야 합니다." }
    require(bonus !in winningNumbers) { "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다." }
}