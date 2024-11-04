package lotto

import camp.nextstep.edu.missionutils.Console

class Input {
    private fun input(): String = Console.readLine()

    private fun checkChangeInt(input: String): Boolean {
        try {
            input.toInt()
            return true
        } catch (e: NumberFormatException) {
            println(NOT_NUMBER)
            throw IllegalArgumentException(NOT_NUMBER)
        }
    }

    fun getAmount(): Int {
        println(REQUEST_AMOUNT_MESSAGE);

        while (true) {
            val input = input()

            try {
                checkChangeInt(input)
                return input.toInt()

            } catch (e: IllegalArgumentException) {
                continue
            }
        }
    }

    fun getLottoNumbers(): List<Int> {
        println(REQUEST_NUMBERS_MESSAGE)

        while (true) {
            val lottoNumbers = input().split(',').map { it.toInt() }

            try {
                lottoNumbers.forEach {
                    isRangeLottoNumber(it)
                }
                return lottoNumbers
            } catch (e: IllegalArgumentException) {
                continue
            }
        }
    }

    fun getLottoBonusNumbers(): Int {
        println(REQUEST_BONUS_NUMBERS_MESSAGE)

        while (true) {
            val input = input()

            try {
                checkChangeInt(input)
                isRangeLottoNumber(input.toInt())
                return input.toInt()

            } catch (e: IllegalArgumentException) {
                continue
            }
        }
    }

    companion object {
        private const val REQUEST_AMOUNT_MESSAGE = "구입금액을 입력해 주세요."
        private const val REQUEST_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요."
        private const val REQUEST_BONUS_NUMBERS_MESSAGE = "보너스 번호를 입력해 주세요."
    }
}