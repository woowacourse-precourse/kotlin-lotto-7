package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.all { it in 1..45 }) { "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다." }
        require(numbers.distinct().size == 6) { "[ERROR] 로또 번호는 중복되지 않아야 합니다." }
    }

    // 로또 번호를 정렬된 형태로 반환
    fun getSortedNumbers(): List<Int> = numbers.sorted()

    // 당첨 번호와의 일치 개수 계산
    fun countMatchingNumbers(winningNumbers: List<Int>): Int {
        return numbers.count { it in winningNumbers }
    }

    // 보너스 번호와 일치 여부 확인
    fun containsBonusNumber(bonusNumber: Int): Boolean {
        return bonusNumber in numbers
    }
}

// 개수만큼 로또 발행
fun generateLottoTickets(count: Int): List<Lotto> {
    val tickets = mutableListOf<Lotto>()
    repeat(count) {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).toList()
        tickets.add(Lotto(numbers))
    }
    return tickets
}
