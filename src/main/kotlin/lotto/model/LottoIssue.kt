package lotto.model

import camp.nextstep.edu.missionutils.Randoms

class LottoIssue {
    fun issueLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(numbers.sorted()) // Lotto 객체 생성
    }

    // 여러 개의 로또 발행
    fun issueLottos(count: Int): List<Lotto> {
        return List(count) { issueLotto() }
    }
}
