package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }

    override fun toString(): String {
        val lottoNumbersOutput = numbers.joinToString(prefix = "[", postfix = "]", separator = ", ")
        return lottoNumbersOutput
    }
    // TODO: 추가 기능 구현
}
