package lotto

fun isDuplicationLottoNumbers(lottoNumbers: List<Int>): Boolean {
    val duplicationNumbers = lottoNumbers.filterIndexed { idx, it -> lottoNumbers.indexOf(it) != idx }
    if (duplicationNumbers.isNotEmpty()) {
        println(DUPLICATION_NUMBER)
        return false
    }
    return true
}
fun isRangeLottoNumber(number: Int): Boolean  {
    if (number < LOTTO_RANGE_FLOOR || number > LOTTO_RANGE_CEIL) {
        println(NOT_RANGE_NUMBER)
        return false
    }
    return true
}