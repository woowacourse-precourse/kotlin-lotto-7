package lotto

import camp.nextstep.edu.missionutils.Console

class Input {
    private fun input(): String = Console.readLine()

    fun getAmount(): Int {
        println(REQUEST_AMOUNT_MESSAGE);
        return input().toInt()
    }

    fun getLottoNumbers(): List<Int> {
        println(REQUEST_NUMBERS_MESSAGE)
        return input().split(',').map { it.toInt() }
    }

    fun getLottoBonusNumbers() : Int {
        println(REQUEST_BONUS_NUMBERS_MESSAGE)
        return input().toInt()
    }

    companion object {
        private const val REQUEST_AMOUNT_MESSAGE = "구입금액을 입력해 주세요."
        private const val REQUEST_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요."
        private const val REQUEST_BONUS_NUMBERS_MESSAGE = "보너스 번호를 입력해 주세요."
    }
}