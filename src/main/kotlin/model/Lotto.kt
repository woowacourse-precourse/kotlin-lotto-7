package model

import lotto.CheckError

class Lotto(private val numbers: List<Int>) {
    init {
        val checkError = CheckError()
        checkError.validateLotto(this)
//        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }
}
