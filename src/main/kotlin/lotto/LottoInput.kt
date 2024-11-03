package lotto

import camp.nextstep.edu.missionutils.Console

class LottoInput {
    fun retryPurchaseAmount(): Int = retry(::purchaseAmount)
    private fun purchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val input = Console.readLine()
        require((input.toIntOrNull()?: 0).let { it > 0 && it % Lotto.PRICE == 0 }) { "[ERROR] 로또 구입 금액은 ${Lotto.PRICE}의 배수여야 합니다." }
        println()
        return input.toInt()
    }

    fun retryNumbers(): List<Int> = retry(::numbers)

    private fun numbers(): List<Int> {
        println("당첨 번호를 입력해 주세요.")
        val input = Console.readLine().split(",")
        require(input.size == Lotto.LENGTH) { "[ERROR] 로또 당첨 번호는 ${Lotto.LENGTH}개여야 합니다." }
        require(input.toSet().size == Lotto.LENGTH) { "[ERROR] 로또 당첨 번호는 중복되면 안됩니다." }
        require(input.all(Lotto::isNumber)) { "[ERROR] 로또 당첨 번호는 ${Lotto.MIN_NUMBER} ~ ${Lotto.MAX_NUMBER} 사이의 양의 정수여야 합니다." }
        println()
        return input.map(String::toInt)
    }

    fun retryBonusNumber(): Int = retry(::bonusNumber)
    private fun bonusNumber(): Int {
        println("보너스 번호를 입력해 주세요.")
        val input = Console.readLine()
        require(Lotto.isNumber(input)) { "[ERROR] 로또 보너스 번호는 ${Lotto.MIN_NUMBER} ~ ${Lotto.MAX_NUMBER} 사이의 양의 정수여야 합니다." }
        println()
        return input.toInt()
    }

    private fun <T> retry(method: () -> T): T {
        return try {
            method()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            retry(method)
        }
    }
}