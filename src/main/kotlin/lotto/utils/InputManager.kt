package lotto.utils

import camp.nextstep.edu.missionutils.Console

object InputManager {

    private const val INPUT_PURCHASE_MONEY_TITLE = "구입금액을 입력해 주세요."
    /**
     * 로또를 구입할 금액을 입력 받는다.
     * @return 로또 구입 금액
     */
    fun getPurchaseMoney(): Int {
        return callRetriableInput { println(INPUT_PURCHASE_MONEY_TITLE)
            val input = Console.readLine()
            return@callRetriableInput input.toPurchaseMoney()
        }
    }

    private fun String.toPurchaseMoney(): Int {
        ValidationUtils.checkValidInputPurchaseMoney(this)
        return this.toInt()
    }

    private const val INPUT_WINNING_NUMBERS_TITLE = "당첨 번호를 입력해 주세요."
    /**
     * 로또 당첨 번호를 입력 받는다. 쉼표(,)를 기준으로 구분한다.
     * @return 로또 당첨 번호 세트
     */
    fun getWinningNumbers(): List<Int> {
        return callRetriableInput {
            println(INPUT_WINNING_NUMBERS_TITLE)
            val input = Console.readLine()
            return@callRetriableInput input.toWinningNumbers()
        }
    }

    private const val INPUT_WINNING_NUMBERS_SEPARATOR = ","
    private fun String.toWinningNumbers(): List<Int> {
        ValidationUtils.checkValidWinningNumbers(this, INPUT_WINNING_NUMBERS_SEPARATOR)
        return split(INPUT_WINNING_NUMBERS_SEPARATOR).map {
            it.toInt()
        }
    }

    private const val INPUT_BONUS_NUMBER_TITLE = "보너스 번호를 입력해 주세요."
    /**
     * 로또 당첨 보너스 번호를 입력 받는다.
     * @return 보너스 번호
     */
    fun getBonusNumber(winningNumbers: List<Int>): Int {
        return callRetriableInput {
            println(INPUT_BONUS_NUMBER_TITLE)
            val input = Console.readLine()
            return@callRetriableInput input.toBonusNumber(winningNumbers)
        }.also {
            Console.close()
        }
    }

    private fun String.toBonusNumber(winningNumbers: List<Int>): Int {
        ValidationUtils.checkValidBonusNumber(this, winningNumbers)
        return toInt()
    }

    private fun <T> callRetriableInput(call: () -> T): T {
        while (true) {
            try {
                return call.invoke()
            } catch (e: IllegalArgumentException) {
                println(e.message)  // 예외 메시지를 출력하고 반복
            }
        }
    }

}

