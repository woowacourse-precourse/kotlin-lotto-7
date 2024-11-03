package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LottoMaker.NUMBERS_COUNT) { ErrorMessage.LOTTO_NUMBER_COUNT_ERROR }
        require(numbers.toSet().size == numbers.size) { ErrorMessage.LOTTO_NUMBER_NO_DUPLICATE }
    }

    // TODO: 추가 기능 구현
}
