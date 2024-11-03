package lotto

class Processer {

    fun splitLottoNumber(input: String): List<String> {
        val winNumbers = input.split(",")
        return winNumbers
    }

    fun convertLottoNumber(input: List<String>): List<Int> {
        val winNumbers = ArrayList<Int>()
        for (i in 0..input.lastIndex) {
            winNumbers.add(input[i].toInt())
        }
        return winNumbers.toList()
    }
}