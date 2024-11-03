package lotto

import camp.nextstep.edu.missionutils.Console

class ResultView {
    fun getWinningNumbers(): List<Int> {
        println(WINNINGNUMBER_PROMPT_MESSAGE)
        return try {
            Console.readLine().split(",").map { it.trim().toInt() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ERROR_MESSAGE)
        }
    }

    fun getBonusNumber(): Int {
        println(BONUSNUMBER_PROMPT_MESSAGE)
        return try {
            Console.readLine().toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ERROR_MESSAGE)
        }
    }

    companion object {
        const val WINNINGNUMBER_PROMPT_MESSAGE = "\n당첨 번호를 입력해 주세요."
        const val BONUSNUMBER_PROMPT_MESSAGE = "\n보너스 번호를 입력해 주세요."
        const val ERROR_MESSAGE = "[ERROR] 유효한 번호를 입력해 주세요."
    }
}