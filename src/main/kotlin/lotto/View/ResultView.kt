package lotto.View

import camp.nextstep.edu.missionutils.Console
import lotto.Util.Prize
import lotto.Util.Validator

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

    fun displayResults(results: Map<Prize, Int>, profitRate: Double) {
        println(RESULTS_PROMPT)
        println(RESULTS_START_SEPARATOR)
        println("$MATCH_THREE - ${results[Prize.FIFTH] ?: 0}개")
        println("$MATCH_FOUR - ${results[Prize.FOURTH] ?: 0}개")
        println("$MATCH_FIVE - ${results[Prize.THIRD] ?: 0}개")
        println("$MATCH_FIVE_BONUS - ${results[Prize.SECOND] ?: 0}개")
        println("$MATCH_SIX - ${results[Prize.FIRST] ?: 0}개")
        println("$PROFIT_PROMPT_FIRST${"%.1f".format(profitRate)}$PROFIT_PROMPT_SECOND")
    }

    companion object {
        const val RESULTS_PROMPT = "\n당첨 통계"
        const val RESULTS_START_SEPARATOR = "---"
        const val MATCH_THREE = "3개 일치 (5,000원)"
        const val MATCH_FOUR = "4개 일치 (50,000원)"
        const val MATCH_FIVE = "5개 일치 (1,500,000원)"
        const val MATCH_FIVE_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원)"
        const val MATCH_SIX = "6개 일치 (2,000,000,000원)"
        const val PROFIT_PROMPT_FIRST = "총 수익률은 "
        const val PROFIT_PROMPT_SECOND = "%입니다."

        const val WINNINGNUMBER_PROMPT_MESSAGE = "\n당첨 번호를 입력해 주세요."
        const val BONUSNUMBER_PROMPT_MESSAGE = "\n보너스 번호를 입력해 주세요."
        const val ERROR_MESSAGE = "[ERROR] 유효한 번호를 입력해 주세요."
    }
}