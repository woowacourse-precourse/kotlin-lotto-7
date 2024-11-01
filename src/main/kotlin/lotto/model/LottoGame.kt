package lotto.model

class LottoGame {
    private var numbers: List<Int> = listOf()

    fun set(lottoNumbers: List<Int>) {
        numbers = lottoNumbers
    }

    fun validatePrice(price: String): String? {
        if (price.toIntOrNull() == null) {
            return "[ERROR] 구매 가격은 숫자여야 합니다."
        }
        return null
    }

    fun buy(price: String): Int {
        return price.toInt() / LOTTO_TICKET_PRICE
    }

    fun check(winningNumbers: List<Int>): Int {
        var winningCount = 0
        winningNumbers.forEach {
            if (numbers.contains(it)) {
                winningCount ++
            }
        }
        return winningCount
    }

    fun isBonus(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }

    companion object {
        const val LOTTO_TICKET_PRICE = 1000
    }
}