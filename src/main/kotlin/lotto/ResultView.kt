package lotto

import camp.nextstep.edu.missionutils.Console

class ResultView {
    fun getWinningNumbers(): List<Int> {
        while (true) {
            println(WINNINGNUMBER_PROMPT_MESSAGE)
            try {
                val winningNumbers = Console.readLine().split(",").map { it.trim().toInt() }
                Validator.validateWinningNumbers(winningNumbers) // 유효성 검사
                return winningNumbers
            } catch (e: NumberFormatException) {
                println(ERROR_MESSAGE)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun getBonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            println(BONUSNUMBER_PROMPT_MESSAGE)
            try {
                val bonusNumber = Console.readLine().toInt()
                Validator.validateBonusNumber(bonusNumber, winningNumbers) // 유효성 검사
                return bonusNumber
            } catch (e: NumberFormatException) {
                println(ERROR_MESSAGE)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    companion object {
        const val WINNINGNUMBER_PROMPT_MESSAGE = "\n당첨 번호를 입력해 주세요."
        const val BONUSNUMBER_PROMPT_MESSAGE = "\n보너스 번호를 입력해 주세요."
        const val ERROR_MESSAGE = "[ERROR] 유효한 번호를 입력해 주세요."
    }
}