package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import net.bytebuddy.pool.TypePool.Resolution.Illegal

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

    println("\n당첨 번호를 입력해 주세요.")
    val normalWinningNumbers = getNumbers(6)

    println("\n보너스 번호를 입력해 주세요.")
    val bonusNumbers = getNumbers(1).first()

    println("\n당첨 통계\n---")
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

private fun getNumbers(count : Int): List<Int> {
    var normalNumbers: List<Int>? = null

    while (normalNumbers == null) {
        val input = Console.readLine()
        try {
            normalNumbers = parseNormalWinningNumbers(input)
                .checkNumberLength(count)
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    return normalNumbers
}

private fun parseNormalWinningNumbers(numbersInformation: String): List<Int> {
    try {
        return numbersInformation.split(",").map {
            it.trim()
                .toInt()
                .checkIntRange(1, 45)
        }
    } catch (e: NullPointerException) {
        throw IllegalArgumentException("[ERROR] 입력값이 비었습니다.")
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("[ERROR] 입력은 숫자여야 합니다.")
    }
}

private fun Int.checkIntRange(start: Int, end: Int): Int {
    if (this !in start .. end) {
        throw IllegalArgumentException("[ERROR] 숫자는 1 이상 45 이하여야 합니다.")
    }

    return this
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

private fun List<Int>.checkNumberLength(count: Int): List<Int> {
    if (this.size != count) {
        throw IllegalArgumentException("[ERROR] ${count}개의 숫자를 입력해야 합니다.")
    }

    return this
}