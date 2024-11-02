package lotto

import camp.nextstep.edu.missionutils.Console

class Input {
    private fun input(): String? = Console.readLine()

    fun getAmount(): String? {
        println(REQUEST_AMOUNT_MESSAGE);
        return input()
    }

    companion object {
        private const val REQUEST_AMOUNT_MESSAGE = "구입금액을 입력해 주세요."
    }
}