package lotto

fun getLotto():MutableList<Int> {
    val LOTTO_COUNT:Int = 6
    val STRAT_LOTTO_NUM:Int = 1
    val END_LOTTO_NUM:Int = 45
    var lottoNotDuplex:HashSet<Int> = hashSetOf()
    var lottoTicket:MutableList<Int> = mutableListOf()

    while (lottoNotDuplex.size != 6) {
        lottoTicket = camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(STRAT_LOTTO_NUM, END_LOTTO_NUM, LOTTO_COUNT)
        lottoNotDuplex = lottoTicket.toHashSet()
    }
    lottoTicket.sort()
    return lottoTicket
}


class Lotto(private val numbers: List<Int>) {
    init {
        var numbersNotDuplex:HashSet<Int> = numbers.toHashSet()

        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbersNotDuplex.size == 6) {"[ERROR] 로또 번호는 중복될 수 없습니다" }
        numbers.all { it in 1..45 } || throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
    }

    fun determineWith(pickedNumbers:MutableList<Int>, bonusNumber:Int):Int {
        pickedNumbers.add(bonusNumber)
        val winningCount = numbers.count { it in pickedNumbers }
        return winningCount
    }

    // TODO: 추가 기능 구현

}
