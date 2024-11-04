package lotto

import camp.nextstep.edu.missionutils.Console

class Input {
    private fun input(): String = Console.readLine()

    private fun checkChangeInt(input  : String) : Boolean {
        try {
            input.toInt()
            return true
        }catch (e: NumberFormatException){
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

            }catch (e : IllegalArgumentException){
                println(NOT_NUMBER)
            }
        }
    }

    private fun checkDuplicationLottoNumbers(lottoNumbers: List<Int>){
        val duplicationNumbers = lottoNumbers.filterIndexed { idx, it -> lottoNumbers.indexOf(it) != idx }
        if(duplicationNumbers.isNotEmpty()){
           throw IllegalArgumentException(DUPLICATION_NUMBER)
        }
    }

    fun getLottoNumbers(): List<Int> {
        println(REQUEST_NUMBERS_MESSAGE)

        while (true){
            val lottoNumbers = input().split(',').map { it.toInt() }

            try{
                checkDuplicationLottoNumbers(lottoNumbers)
                return lottoNumbers
            }catch (e : IllegalArgumentException){
                println(DUPLICATION_NUMBER)
            }
        }
    }

    fun getLottoBonusNumbers(): Int {
        println(REQUEST_BONUS_NUMBERS_MESSAGE)
        return input().toInt()
    }

    companion object {
        private const val REQUEST_AMOUNT_MESSAGE = "구입금액을 입력해 주세요."
        private const val REQUEST_AMOUNT_MESSAGE_AGAIN = "구입금액을 형식에 맞춰 재입력해 주세요."
        private const val REQUEST_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요."
        private const val REQUEST_BONUS_NUMBERS_MESSAGE = "보너스 번호를 입력해 주세요."
    }
}