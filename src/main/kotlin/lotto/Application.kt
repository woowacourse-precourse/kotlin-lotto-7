package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

const val TICKET_PRICE = 1000

fun main() {
    var validInput = false
    var amount = ""
    val lotto = mutableListOf<List<Int>>()


    while (!validInput) {
        try {
            println("구입금액을 입력해 주세요.")

            amount = Console.readLine()
            require(amount.toIntOrNull() != null) { "[ERROR] 구입금액은 정수여야 합니다." }
            PurchaseAmount(amount.toInt(), TICKET_PRICE)

            validInput = true
        } catch (e: IllegalArgumentException) {
            println("잘못된 입력입니다. 다시 입력해 주세요. ${e.message}")
        }
    }

    val purchasedLottoCount = amount.toInt() / TICKET_PRICE

    println("${purchasedLottoCount}개를 구매했습니다.")

    repeat(purchasedLottoCount) {
        val lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        lotto.add(lottoNumbers)

        println("[${lottoNumbers.joinToString(", ")}]")
    }
    println()


    validInput = false
    var winningNumberInput = ""

    while (!validInput) {
        try {
            println("당첨 번호를 입력해 주세요.")

            winningNumberInput = Console.readLine()
            val winningNumber = winningNumberInput.split(",").map { it }
            require(winningNumber.all { it.toIntOrNull() != null }) { "[ERROR] 로또번호는 정수여야 합니다." }
            Lotto(winningNumber.map { it.toInt() })

            validInput = true  // 예외 없이 통과한 경우에만 루프 종료

        } catch (e: IllegalArgumentException) {
            println("잘못된 입력입니다. 다시 입력해 주세요. ${e.message}")
        } catch (e: NumberFormatException) {
            println("숫자를 입력해 주세요.")
        }
    }


    validInput = false
    var bonusNumberInput = ""

    while (!validInput) {
        try {
            println("보너스 번호를 입력해 주세요.")

            bonusNumberInput = Console.readLine()
            require(bonusNumberInput.toIntOrNull() != null) { "[ERROR] 보너스번호는 정수여야 합니다." }
            BonusNumber(bonusNumberInput.toInt(), winningNumberInput.split(",").map { it.toInt() })

            validInput = true
        } catch (e: IllegalArgumentException) {
            println("잘못된 입력입니다. 다시 입력해 주세요. ${e.message}")
        }
    }

    // ---
    val winningNumbers = winningNumberInput.split(",").map { it.toInt() }

    val lottoStatics = mutableListOf<Rank>()

    lotto.forEach { userLotto ->
        val matchNumbers = userLotto.intersect(winningNumbers)

        when (matchNumbers.size) {
            6 -> lottoStatics.add(Rank.FIRST)
            5 -> lottoStatics.add(secondOrThird(userLotto, bonusNumberInput.toInt()))
            4 -> lottoStatics.add(Rank.FOURTH)
            3 -> lottoStatics.add(Rank.FIFTH)
        }
    }

    //---

    println("당첨 통계")
    println("---")

    println(
        "3개 일치 (${Rank.FIFTH.prize}원) - ${lottoStatics.count { it == Rank.FIFTH }}개\n" +
                "4개 일치 (50,000원) - ${lottoStatics.count { it == Rank.FOURTH }}개\n" +
                "5개 일치 (1,500,000원) - ${lottoStatics.count { it == Rank.THIRD }}개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - ${lottoStatics.count { it == Rank.SECOND }}개\n" +
                "6개 일치 (2,000,000,000원) - ${lottoStatics.count { it == Rank.FIRST }}개"
    )

    val winningMoney: Int = lottoStatics.sumOf { it.prize.replace(",", "").toInt() }

    var profitRate = 0.00
    if (winningMoney == 0) {
        profitRate = 0.00
    } else {
        profitRate = winningMoney.toDouble() / amount.toInt() * 100
    }

    println("총 수익률은 %.1f%%입니다.".format(profitRate)) // 둘째 자리에서 반올림


}

fun secondOrThird(userLotto: List<Int>, bonusNumber: Int): Rank {
    if (userLotto.contains(bonusNumber)) return Rank.SECOND
    return Rank.THIRD
}
