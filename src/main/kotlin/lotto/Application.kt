package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("구입 금액을 입력해주세요.")
    var lottoCount: Int
    do {
        try {
            lottoCount = getAmount()
            println()
            println("${lottoCount}개를 구매했습니다.")
        } catch (e: IllegalArgumentException) {
            println(e.message)
            continue
        }
        break
    } while (true)

    val lottos = createLottos(lottoCount)
    printLottos(lottos)

    println("당첨 번호를 입력해주세요.")
    var prizeLotto: Lotto
    do {
        try {
            prizeLotto = getPrizeLotto()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            continue
        }
        break
    } while (true)
}

fun getAmount(): Int {
    val amount = Console.readLine().toInt()
    return checkAmount(amount)
}

fun checkAmount(amount: Int): Int {
    if (amount % 1000 != 0) {
        throw IllegalArgumentException("[ERROR] 1,000원 단위로만 구매 가능합니다. 구입 금액을 다시 입력해주세요.")
    }
    return amount / 1000
}

fun createLottos(number: Int): ArrayList<Lotto> {
    val lottos = ArrayList<Lotto>()
    for (i in 0 until number) {
        lottos.add(Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
    }
    return lottos
}

fun printLottos(lottos: ArrayList<Lotto>) {
    lottos.forEach {
        println(it.getNumbers())
    }
    println()
}

fun getPrizeLotto(): Lotto {
    val prizeNumbers = Console.readLine().split(",")
    return Lotto(checkLotto(prizeNumbers))
}

fun checkLotto(lottoNumbers: List<String>): List<Int> {
    try {
        val mappedLottoNumbers = lottoNumbers.map { it.toInt() }
        mappedLottoNumbers.forEach {
            require(it in 1..45) {"[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다. 당첨 번호를 다시 입력해주세요."}
        }
        return mappedLottoNumbers
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("[ERROR] 쉼표(,) 이외의 구분자를 사용할 수 없습니다. 당첨 번호를 다시 입력해주세요.")
    }
}