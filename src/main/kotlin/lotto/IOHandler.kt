package lotto

class IOHandler {
    fun inputToUser(instruction: String): String {
        println(instruction)
        return readLine() ?: EXCEPTIONOFNULL
    }

    fun inputWinningNumbers(): String {
        return inputToUser(WINNINGNUMBERINSTRUCTION)
    }

    fun outputForPurchasedLotto(purchasedLotto: PurchasedLotto) {
        val output = StringBuilder()

        output.append(purchasedLotto.amountOfLotto, "개를 구매했습니다.")
        purchasedLotto.purchasedLotto.forEach { output.append("\n", it) }
        println(output)
    }

    fun outputForZeroOfLotto() {
        println("지불하신 금액이 0원이므로 종료합니다.")
    }

    companion object {
        const val EXCEPTIONOFNULL = "입력값을 확인할 수 없습니다. 다시 입력해주세요."
        const val WINNINGNUMBERINSTRUCTION = "당첨 번호를 입력해 주세요."
    }
}