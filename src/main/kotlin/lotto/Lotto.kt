package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LottoMaker.NUMBERS_COUNT) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.toSet().size == numbers.size) { ErrorMessage.LOTTO_NUMBER_NO_DUPLICATE }
    }

    // TODO: 추가 기능 구현
}
