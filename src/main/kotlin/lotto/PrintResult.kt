package lotto

object PrintResult {
    fun printRandomNumbers() {
        val randomNumbers = LottoSystem.getRandomNumbers()
        randomNumbers.forEach { println(it) }
    }

    fun numberOfPurchasesInstructions(purchaseAmount:Int){
        println("\n${purchaseAmount}개를 구매했습니다.")
    }

}