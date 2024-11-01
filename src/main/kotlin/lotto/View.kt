package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.domain.LottoWinningInfo
import lotto.domain.Money

const val MESSAGE_INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
const val MESSAGE_INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요."

fun getLottoPurchaseAmount(): Money {
    while (true) {
        try {
            println(MESSAGE_INPUT_PURCHASE_AMOUNT)
            val input = convertInt(readLineAndLineBreak())

            return Money(input)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            println()
        }
    }
}

fun getLottoWinningInfo(): LottoWinningInfo {
    val winningInfo = LottoWinningInfo(getLottoWinningNumbers())
    setLottoBonusNumber(winningInfo)

    return winningInfo
}

private fun setLottoBonusNumber(winningInfo: LottoWinningInfo) {
    while (true) {
        try {
            println(MESSAGE_INPUT_PURCHASE_AMOUNT)
            winningInfo.bonusNumber = convertInt(readLineAndLineBreak())
            break
        } catch (e: IllegalArgumentException) {
            println(e.message)
            println()
        }
    }
}

fun getLottoWinningNumbers(): List<Int> {
    while (true) {
        try {
            println(MESSAGE_INPUT_WINNING_NUMBER)
            val input = convertListInt(readLineAndLineBreak())

            return input
        } catch (e: IllegalArgumentException) {
            println(e.message)
            println()
        }
    }
}

private fun readLineAndLineBreak(): String {
    val input = Console.readLine()
    println()

    return input
}
