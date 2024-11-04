package data

import util.SettingValue

class Bonus(private val numbers: Int) {

    init {
        require(numbers in SettingValue.LOTTO_NUMBER_MINIMUM..SettingValue.LOTTO_NUMBER_MAXIMUM) {
            "[ERROR] 보너스 번호는 1~45 사이여야 합니다."
        }
    }

    val read: Int
        get() = numbers
}