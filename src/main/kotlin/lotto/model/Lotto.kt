package lotto.model

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == LOTTO_NUMBER_SIZE) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.all { it in LOTTO_MINIMUM_NUMBER..LOTTO_MAXIMUM_NUMBER }) { "[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다." }
        require(numbers.distinct().size == LOTTO_NUMBER_SIZE) { "[ERROR] 로또 번호는 중복이 없어야 합니다." }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    fun getSortedNumbers(): List<Int> {
        return numbers.sorted()
    }

    fun compareWinningLotto(winningLotto: WinningLotto): LottoPrize {
        var matchingCount = 0
        var isMatchingBonusNumber = false

        numbers.forEach { lottoNumber ->
            if (winningLotto.lotto.numbers.contains(lottoNumber)) {
                matchingCount++
            }

            if (lottoNumber == winningLotto.bonusNumber) {
                isMatchingBonusNumber = true
            }
        }

        return LottoPrize.fromMatchingCount(matchingCount, isMatchingBonusNumber)
    }

    companion object {
        const val LOTTO_PRICE = 1_000
        const val LOTTO_NUMBER_SIZE = 6
        const val LOTTO_MINIMUM_NUMBER = 1
        const val LOTTO_MAXIMUM_NUMBER = 45
    }
}
