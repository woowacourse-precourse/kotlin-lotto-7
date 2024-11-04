package model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.toSet().size == 6) { "[ERROR] 로또 번호는 중복되지 않은 번호이어야 합니다."}
    }

    fun getLottoTicket(): String {
        return numbers.sorted().joinToString()
    }
}
