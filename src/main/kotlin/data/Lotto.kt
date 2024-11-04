package data

import util.SettingValue

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.size == numbers.toSet().size) { "[ERROR] 같은 번호는 없어야 합니다." }
        require(numbers.all {
            it in SettingValue.LOTTO_NUMBER_MINIMUM..SettingValue.LOTTO_NUMBER_MAXIMUM
        }) { "[ERROR] 로또 번호는 1~45 사이여야 합니다." }
    }

    val read: List<Int>
        get() = numbers

    fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }
}