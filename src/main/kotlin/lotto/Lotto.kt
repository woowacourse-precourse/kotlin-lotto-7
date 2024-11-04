package lotto

import camp.nextstep.edu.missionutils.Console

enum class LottoPrice(val price: Int, val key: Int, val print: String) {
    FIRST(2000000000, 6, "2,000,000,000원"),
    SECOND(30000000, 7, "30,000,000원"),
    THIRD(1500000, 5, "1,500,000원"),
    FORTH(50000, 4, "50,000원"),
    FIFTH(5000, 3, "5,000원");

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
    init {
        val finalNumbers = numbers.distinct()
        if (finalNumbers.size != 6) {
            print("[ERROR] 로또 번호는 6개여야 합니다.")
            throw (IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다."))
        }
    }

    var bonusNumber = 0
    fun inputBonus() {
        try {
            bonusNumber = Console.readLine().toIntOrNull() ?: run {
                println("[ERROR] 숫자가 아닙니다.")
                throw (IllegalArgumentException("[ERROR] 숫자가 아닙니다."))
            }
            if (bonusNumber > 45 || bonusNumber < 1) {
                println("[ERROR]범위 내의 숫자가 아닙니다.")
                throw (IllegalArgumentException("[ERROR]범위 내의 숫자가 아닙니다."))
            }
        } catch (e: IllegalArgumentException) {
            inputBonus()
        }

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
