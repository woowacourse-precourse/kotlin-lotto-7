package lotto

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange

fun main() {
    startLotto()
}

/* 로또 실행 함수 */
fun startLotto() {
    val lottoCnt = inputMoney() //구입한 로또 개수
    val lottoList = mutableListOf<Lotto>() //발행한 로또 리스트

    repeat(lottoCnt) {
        pickLottoNumbers(lottoList)
    }
}

/* 로또 구입 금액 입력 함수 */
fun inputMoney(): Int {
    while (true) {
        try {
            println("구입금액을 입력해 주세요.")
            val money = readLine()?.toInt() ?: throw IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.")

            if (money % 1000 != 0) {
                throw IllegalArgumentException("[ERROR] 금액이 1000으로 나누어 떨어지지 않습니다.")
            }

            return money / 1000
        } catch (e: NumberFormatException) {
            println("[ERROR] 숫자를 입력해 주세요.")
        }
    }
}

/* 로또 발행 함수 */
fun pickLottoNumbers(lottoList: MutableList<Lotto>) {
    val lottoNumbers = pickUniqueNumbersInRange(1, 45, 6)
    lottoList.add(Lotto(lottoNumbers))
}