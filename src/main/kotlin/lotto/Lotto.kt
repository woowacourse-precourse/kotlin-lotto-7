package lotto

import camp.nextstep.edu.missionutils.Console

enum class LottoPrice(val price: Int, val key: Int, val print: String) {
    FIRST(2000000000, 6, "2,000,000,000원"),
    SECOND(30000000, 5, "30,000,000원"),
    THIRD(1500000, 7, "1,500,000원"),
    FORTH(50000, 4, "50000원"),
    FIFTH(5000, 3, "5000원");

    companion object {
        fun findPriceByKey(key: Int): Int? {
            return LottoPrice.entries.find { it.key == key }?.price
        }

        fun findPrintByKey(key: Int): String {
            return LottoPrice.entries.find { it.key == key }?.print.toString()
        }
    }
}


class Lotto(private val numbers: List<Int>) {
    private var bonusNumber = 0

    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }

    fun inputBonus() {
        bonusNumber = Console.readLine().toIntOrNull() ?: throw (IllegalArgumentException("[ERROR] 숫자가 아닙니다. "))
    }

    fun findNumbers(paperNumber: List<Int>): Int {
        var matched = 0
        for (number in paperNumber) {
            if (matchNumber(number)) {
                matched++
            }
        }
        return matched
    }

    private fun matchNumber(number: Int): Boolean {
        for (nowNumber in numbers) {
            if (number == nowNumber) {
                return true
            }
        }
        return false
    }

    fun findBonus(paperNumber: List<Int>): Boolean {
        for (number in paperNumber) {
            if (number == bonusNumber) {
                return true
            }
        }
        return false
    }

}
