package lotto

import kotlin.math.round

object PrintResult {
    fun printRandomNumbers() {
        val randomNumbers = LottoSystem.getRandomNumbers()
        randomNumbers.forEach { println(it) }
    }

    fun numberOfPurchasesInstructions(purchaseAmount:Int){
        println("\n${purchaseAmount}개를 구매했습니다.")
    }

    fun printWinningStatistics(){
        val ranks = LottoSystem.getRanks()
        println("당첨 통계")
        println("---")
        ranks.forEach {
            if(it.key.bonusMatch&&it.key.matchCount==5)
                println("${it.key.matchCount}개 일치, 보너스 볼 일치 (${it.key.priceONE}) - ${it.value}개")
            else println("${it.key.matchCount}개 일치 (${it.key.priceONE}) - ${it.value}개")
        }
        val rateOfReturn = round((LottoSystem.getRateOfReturn() * 100)) /100
        println("총 수익률은 ${rateOfReturn}%입니다.")
    }

}