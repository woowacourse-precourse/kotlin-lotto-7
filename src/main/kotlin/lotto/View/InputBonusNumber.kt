package lotto.View

import camp.nextstep.edu.missionutils.Console

fun inputBonusNumber(): Int {
    println("보너스 번호를 입력해 주세요.")
    return readAndValidateBonusNumber()
}

private fun readAndValidateBonusNumber(): Int {
    return try {
        val bonus = readBonusNumber()
        validateBonusNumber(bonus)
        bonus
    } catch (e: NumberFormatException) {
        println("[ERROR] 보너스 번호는 숫자로 입력해야 합니다.")
        inputBonusNumber()
    } catch (e: IllegalArgumentException) {
        println(e.message)
        inputBonusNumber()
    }
}

private fun readBonusNumber(): Int {
    return Console.readLine().toInt()
}

private fun validateBonusNumber(bonus: Int) {
    require(bonus in 1..45) { "[ERROR] 보너스 번호는 1에서 45 사이의 정수여야 합니다." }
}
