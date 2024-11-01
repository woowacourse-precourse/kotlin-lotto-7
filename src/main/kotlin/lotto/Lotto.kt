package lotto

const val LOTTO_COUNT:Int = 6
const val STRAT_LOTTO_NUM:Int = 1
const val END_LOTTO_NUM:Int = 45

fun getLotto():MutableList<Int> {
    return camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(STRAT_LOTTO_NUM, END_LOTTO_NUM, LOTTO_COUNT)
}

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        for (number in numbers) {
            require(number in 1..45) {"[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다." }
        }
    }


    // TODO: 추가 기능 구현
}
