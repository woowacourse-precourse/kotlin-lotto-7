package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val lottoIssue = LottoIssue()
    val issuedLottos = lottoIssue.issueLottos(5)

    println("${issuedLottos.size}개를 구매했습니다.")
    issuedLottos.forEach { println(it) }
}

class LottoIssue {
    // 로또 번호 한 세트를 생성
    fun issueLotto(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
    }

    // 여러 개의 로또 발행
    fun issueLottos(count: Int): List<List<Int>> {
        return List(count) { issueLotto() }
    }
}
