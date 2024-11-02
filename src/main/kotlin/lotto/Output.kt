package lotto

class Output {

    fun printLottoNumbers(numbers: MutableList<MutableList<Int>>){
        println(LOTTO_COUNT_PRINT)
        numbers.forEach{ println(it) }
    }

    companion object{
        private const val LOTTO_COUNT_PRINT = "8개를 구매했습니다."
    }
}