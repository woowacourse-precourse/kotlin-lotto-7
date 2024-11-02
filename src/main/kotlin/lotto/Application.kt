package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val purchase = LottoPurchase()
    val purchaseAmount = purchase.getPurchaseAmount()
    val lottoCount = purchase.calculateLottoCount(purchaseAmount)

    val lottoIssue = LottoIssue()
    val issuedLottos = lottoIssue.issueLottos(lottoCount)

    purchase.displayPurchaseCount(issuedLottos.size)
    issuedLottos.forEach { println(it) }

    val winningNumber = WinningNumber()
    val winningNumbers = winningNumber.getWinningNumber()
    val bonusNumber = winningNumber.getBonusNumber()

    println("당첨 번호: $winningNumbers")
    println("보너스 번호: $bonusNumber")

}

class LottoIssue {
    fun issueLotto(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
    }

    // 여러 개의 로또 발행
    fun issueLottos(count: Int): List<List<Int>> {
        return List(count) { issueLotto() }
    }
}

class LottoPurchase {
    fun displayPurchaseCount(count: Int) {
        println("${count}개를 구매했습니다.")
    }

    fun getPurchaseAmount(): Int {
        while (true) {
            try {
                return readPurchaseAmount()
            } catch (e: NumberFormatException) {
                println("[ERROR] 유효한 숫자(정수)를 입력해야 합니다.")
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun readPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val input = Console.readLine()
        val amount = input.toInt()
        validatePurchaseAmount(amount)
        return amount
    }

    private fun validatePurchaseAmount(amount: Int) {
        require(amount % 1000 == 0) { "[ERROR] 구입 금액은 1,000원 단위여야 합니다." }
    }

    fun calculateLottoCount(amount: Int): Int {
        return amount / 1000
    }
}

class WinningNumber {
    fun getWinningNumber(): List<Int> {
        while (true) {
            val numbers = readWinningNumbers()
            if (isValidNumberscheck(numbers)) {
                return numbers.filterNotNull()
            }
        }
    }


    private fun readWinningNumbers(): List<Int?> {
        println("당첨 번호를 입력해 주세요.")
        val input = Console.readLine()
        return input.split(",").map { it.trim().toIntOrNull() }
    }

    private fun isValidNumberscheck(numbers: List<Int?>): Boolean {
        // 숫자가 null인지 확인하고, 개수가 6이 아니고, 정수가 아니면  오류 메시지 출력
        if (numbers.any { it == null } || numbers.size != 6) {
            println("[ERROR] 당첨 번호는 6개의 정수만 입력해야 합니다.")
            return false
        }

        // 숫자가 1 ~ 45 사이인지 확인
        if (numbers.any { it !in 1..45 }) {
            println("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.")
            return false
        }

        // 중복 값이 있는지 확인
        val distinctNumbers = numbers.distinct()
        if (distinctNumbers.size != numbers.size) {
            println("[ERROR] 당첨 번호에는 중복이 있을 수 없습니다.")
            return false
        }

        return true
    }

    fun getBonusNumber(): Int {
        while (true) {
            println("보너스 번호를 입력해 주세요.")
            val input = Console.readLine()
            try {
                val bonusNumber = input.toInt()
                require(bonusNumber in 1..45) { "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다." }
                return bonusNumber
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }
}
