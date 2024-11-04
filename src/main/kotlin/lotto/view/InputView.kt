package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun receivePurchaseAmount(): String {
        return receiveInputWithPrompt(PURCHASE_AMOUNT_PROMPT)
    }

    private fun receiveInputWithPrompt(prompt: String): String {
        println(prompt)
        return Console.readLine()
    }

    fun receiveWinningNumbers(): String {
        return receiveInputWithPrompt("\n" + WINNING_NUMBERS_PROMPT)
    }

    fun receiveBonusNumber(): String {
        return receiveInputWithPrompt("\n" + BONUS_NUMBER_PROMPT)
    }

    companion object {
        private const val PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요."
        private const val WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요."
        private const val BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요."
    }
}