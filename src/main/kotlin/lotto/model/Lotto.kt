package lotto.model

class Lotto(private val numbers: List<Int>) {
    val lottoNumbers: List<Int>
        get() = numbers

    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.all { it in 1..45 }) { "[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다." }
        require(numbers.distinct().size == 6) { "[ERROR] 로또 번호는 중복이 없어야 합니다." }
    }

    fun compareWinningLotto(winningLotto: WinningLotto): LottoPrize {
        var matchingCount = 0
        var isMatchingBonusNumber = false

        lottoNumbers.forEach { lottoNumber ->
            if (winningLotto.lotto.lottoNumbers.contains(lottoNumber)) {
                matchingCount++
            }

            if (lottoNumber == winningLotto.bonusNumber) {
                isMatchingBonusNumber = true
            }
        }

        return LottoPrize.fromMatchingCount(matchingCount, isMatchingBonusNumber)
    }
}
