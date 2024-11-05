package lotto.model

import lotto.model.LottoNumber.Companion

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE) { "[ERROR] 로또 번호는 ${LOTTO_SIZE}개여야 합니다" }
        require(numbers.distinct().size == LOTTO_SIZE) { "[ERROR] 로또 번호는 중복되지 않아야 합니다" }
        require(numbers.all { it in LottoNumber.NUMBER_RANGE }) {
            "[ERROR] 로또 번호는 ${LottoNumber.MIN_NUMBER}부터 ${LottoNumber.MAX_NUMBER}사이의 숫자여야 합니다"
        }
    }

    fun containNumber(lottoNumber: LottoNumber): Boolean {
        return numbers.contains(lottoNumber.getNumber())
    }

    fun countMatchNumber(mainNumbers: Lotto): Int {
        return numbers.intersect(mainNumbers.numbers).size
    }

    override fun toString(): String = numbers.sorted().toString()

    companion object {
        const val LOTTO_SIZE = 6
    }
}
