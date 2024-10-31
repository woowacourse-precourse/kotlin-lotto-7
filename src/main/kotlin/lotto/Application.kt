package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

const val lottoPrice = 1000

fun main() {
    // TODO: 프로그램 구현
    val lottoMachine = LottoMachine()

    println("구입금액을 입력해 주세요.")
    val purchaseCost: Int = getPurchaseCost()
    val releaseLottoCount = purchaseCost.calculateLottoCount()
    val lottos = lottoMachine.releaseLotto(releaseLottoCount)

    println(lottos.joinToString("\n") { lotto ->
        "[${lotto.getNumbers().joinToString(", ")}]"
    })
}

private fun Int.validatePrice(): Int {
    if (this % lottoPrice != 0) {
        throw IllegalArgumentException("[ERROR] 금액은 1000으로 나눌 수 있는 값이어야 합니다.")
    }

    return this
}

private fun Int.calculateLottoCount(): Int {
    return this / lottoPrice
}

@Throws(IllegalArgumentException::class)
private fun getPurchaseCost(): Int {
    var purchaseCost: Int? = null

    while (purchaseCost == null) {
        val purchaseCostInput = Console.readLine()

        try {
            purchaseCost = convertInputToNumber(purchaseCostInput)
                .validatePrice()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            purchaseCost = null
        }
    }

    return purchaseCost
}

private fun convertInputToNumber(input: String): Int {
    try {
        val parseInput = input.toInt()
        if (parseInput < 0) {
            throw IllegalArgumentException("[ERROR] 입력은 0 이상이어야 합니다.")
        }

        return parseInput
    } catch (e: NullPointerException) {
        throw IllegalArgumentException("[ERROR] 입력값이 비었습니다.")
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("[ERROR] 입력은 숫자여야 합니다.")
    }
}