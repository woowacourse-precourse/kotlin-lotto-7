package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

enum class PrizeWinner {
    FIRST,
    SECOND,
    THIRD,
    FOURTH,
    FIFTH,
    LOSER
}

fun main() {
    println("구입 금액을 입력해주세요.")
    var purchasedLottosCount: Int
    do {
        try {
            purchasedLottosCount = getAmount()
            println()
            println("${purchasedLottosCount}개를 구매했습니다.")
        } catch (e: IllegalArgumentException) {
            println(e.message)
            continue
        }
        break
    } while (true)

    val purchasedLottos = createLottos(purchasedLottosCount)
    printLottos(purchasedLottos)

    println("당첨 번호를 입력해주세요.")
    var winningLotto: Lotto
    do {
        try {
            winningLotto = getWinningLotto()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            continue
        }
        break
    } while (true)

    println()
    println("보너스 번호를 입력해주세요.")
    var bonusNumber: Int
    do {
        try {
            bonusNumber = getBonusNumber()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            continue
        }
        break
    } while (true)

    println()
    val lottoResult = ArrayList<PrizeWinner>()
    purchasedLottos.forEach {
        lottoResult.add(checkWinner(checkLotto(it, winningLotto), checkBonus(it, winningLotto, bonusNumber)))
    }
    printResult(lottoResult)
    println("총 수익률은 ${String.format("%.1f", getReturnRate(purchasedLottosCount, lottoResult)*100)}%입니다.")
}

fun getAmount(): Int {
    val amount = Console.readLine()
    return checkAmount(amount)
}

fun checkAmount(amount: String): Int {
    try {
        val checkedAmount = amount.toInt()
        if (checkedAmount % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] 1,000원 단위로만 구매 가능합니다. 구입 금액을 다시 입력해주세요.")
        }
        return checkedAmount / 1000
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("[ERROR] 구입 금액은 정수로만 입력되어야 합니다. 구입 금액을 다시 입력해주세요.")
    }
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

fun getWinningLotto(): Lotto {
    val winningNumbers = Console.readLine().split(",")
    return Lotto(checkNumber(winningNumbers))
}

fun checkNumber(lottoNumbers: List<String>): List<Int> {
    try {
        val mappedLottoNumbers = lottoNumbers.map { it.toInt() }
        mappedLottoNumbers.forEach {
            require(it in 1..45) {"[ERROR] 로또 번호는 1부터 45 사이의 정수여야 합니다. 로또 번호를 다시 입력해주세요."}
        }
        return mappedLottoNumbers
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("[ERROR] 쉼표(,) 이외의 구분자를 사용할 수 없습니다. 로또 번호를 다시 입력해주세요.")
    }
}

fun getBonusNumber(): Int {
    val bonusNumber = Console.readLine()
    return checkNumber(bonusNumber)
}

fun checkNumber(lottoNumber: String): Int {
    try {
        val checkedLottoNumber = lottoNumber.toInt()
        require(checkedLottoNumber in 1 .. 45) {"[ERROR] 로또 번호는 1부터 45 사이의 정수여야 합니다. 보너스 번호를 다시 입력해주세요."}
        return checkedLottoNumber
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 정수여야 합니다. 보너스 번호를 다시 입력해주세요.")
    }
}

fun checkWinner(count: Int, isBonusEqual: Boolean): PrizeWinner {
    var result: PrizeWinner = PrizeWinner.LOSER
    when(count) {
        6 -> result = PrizeWinner.FIRST
        5 -> result = if (isBonusEqual) {
            PrizeWinner.SECOND
        } else {
            PrizeWinner.THIRD
        }
        4 -> result = PrizeWinner.FOURTH
        3 -> result = PrizeWinner.FIFTH
    }

    return result
}

fun checkLotto(purchasedLotto: Lotto, winningLotto: Lotto): Int {
    var count = 0
    for (i in 0 until 6) {
        if (purchasedLotto.getNumbers()[i] == winningLotto.getNumbers()[i]) {
            count++
        }
    }

    return count
}

fun checkBonus(purchasedLotto: Lotto, winningLotto: Lotto, bonusNumber: Int): Boolean {
    var flag = false
    for (i in 0 until 6) {
        if (purchasedLotto.getNumbers()[i] == winningLotto.getNumbers()[i]) {
            continue
        }
        if (purchasedLotto.getNumbers()[i] == bonusNumber) {
            flag = true
        }
    }

    return flag
}

fun printResult(lottoResult: ArrayList<PrizeWinner>) {
    println("당첨 통계")
    println("---")
    println("3개 일치 (5,000원) - ${lottoResult.count { it == PrizeWinner.FIFTH }}개")
    println("4개 일치 (50,000원) - ${lottoResult.count { it == PrizeWinner.FOURTH }}개")
    println("5개 일치 (1,500,000원) - ${lottoResult.count { it == PrizeWinner.THIRD }}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${lottoResult.count { it == PrizeWinner.SECOND }}개")
    println("6개 일치 (2,000,000,000원) - ${lottoResult.count { it == PrizeWinner.FIRST }}개")
}

fun getReturnRate(purchasedLottosCount: Int, lottoResult: ArrayList<PrizeWinner>): Double {
    val purchaseAmount = (purchasedLottosCount*1000).toDouble()
    val returnAmount = (lottoResult.count { it == PrizeWinner.FIFTH }*5000 + lottoResult.count { it == PrizeWinner.FOURTH }*50000 +
            lottoResult.count { it == PrizeWinner.THIRD }*1500000 + lottoResult.count { it == PrizeWinner.SECOND }*30000000 +
            lottoResult.count { it == PrizeWinner.FIRST }*2000000000).toDouble()

    return returnAmount / purchaseAmount
}
