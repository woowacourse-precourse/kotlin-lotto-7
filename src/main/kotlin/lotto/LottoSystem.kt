package lotto

import camp.nextstep.edu.missionutils.Randoms
import java.math.BigDecimal
import java.math.RoundingMode

object LottoSystem {
    private lateinit var winningNumber: List<Int>
    private var bonusNumber : Int = 0
    private var purchaseAmount : Int = 0
    private var numberOfPurchases : Int = 0
    private lateinit var randomNumbers : MutableList<MutableList<Int>?>
    private lateinit var matchCounts : MutableList<MutableList<Int>>
    private var ranks = mutableMapOf<LottoRank,Int>()
    private lateinit var rateOfReturn : BigDecimal

    fun start() {
        Input.start()
        checkWinning()
        PrintResult.printWinningStatistics()
    }

    fun saveBonusNumber(bonusNumber: Int) {
        this.bonusNumber = bonusNumber
    }

    fun saveWinningNumber(winningNumber: List<Int>) {
        this.winningNumber = winningNumber
    }

    fun savePurchaseAmount(purchaseAmount: Int) {
        this.purchaseAmount = purchaseAmount
        saveNumberOfPurchases()
    }

    private fun saveRateOfReturn(){
        rateOfReturn = BigDecimal.ZERO
        ranks.entries.forEach { entry ->
            if (entry.value > 0) {
                val prizeAmount = entry.key.price.toBigDecimal()
                rateOfReturn += prizeAmount * BigDecimal(entry.value)
            }
        }
        rateOfReturn = rateOfReturn
            .divide(BigDecimal(purchaseAmount), 10, RoundingMode.HALF_UP) // 충분한 정밀도로 나눗셈 수행
            .multiply(BigDecimal(100))
            .setScale(1, RoundingMode.HALF_UP)
    }

    fun getRateOfReturn(): BigDecimal = rateOfReturn

    fun getRandomNumbers(): MutableList<MutableList<Int>?> = randomNumbers

    fun getWinningNumber(): List<Int> = winningNumber

    fun getBonusNumber(): Int = bonusNumber

    fun getRanks(): MutableMap<LottoRank, Int> = ranks

    private fun setRanks(){
        ranks[LottoRank.FIVE] = 0
        ranks[LottoRank.FOUR] = 0
        ranks[LottoRank.THREE] = 0
        ranks[LottoRank.TWO] = 0
        ranks[LottoRank.ONE] = 0
    }

    private fun checkWinning(){
        matchCounts = mutableListOf()
        randomNumbers.forEach {
            val lotto = Lotto(it!!.toList())
            val matchCount = lotto.getMatchCount()
            matchCounts.add(matchCount)
        }
        saveRanks(matchCounts)
    }

    private fun saveRanks(matchCounts: MutableList<MutableList<Int>>) {
        setRanks()
        matchCounts.forEach {
            if(it[0]==6){
                ranks[LottoRank.ONE] = ranks[LottoRank.ONE]!! + 1
            }else if(it[0]==5&&it[1]==1){
                ranks[LottoRank.TWO] = ranks[LottoRank.TWO]!! + 1
            }else if(it[0]==5&&it[1]==0){
                ranks[LottoRank.THREE] = ranks[LottoRank.THREE]!! + 1
            }else if(it[0]==4){
                ranks[LottoRank.FOUR] = ranks[LottoRank.FOUR]!! + 1
            }else if(it[0]==3){
                ranks[LottoRank.FIVE] = ranks[LottoRank.FIVE]!! + 1
            }
        }
        saveRateOfReturn()
    }

    private fun saveNumberOfPurchases(){
        numberOfPurchases = purchaseAmount/1000
        PrintResult.numberOfPurchasesInstructions(numberOfPurchases)
        saveRandomNumbers(numberOfPurchases)
    }

    private fun saveRandomNumbers(numberOfPurchases: Int) {
        randomNumbers = mutableListOf()
        repeat(numberOfPurchases){
            val randomNumber = pickRandomNumbers()
            randomNumbers.add(randomNumber!!.sorted().toMutableList())
        }
        PrintResult.printRandomNumbers()
    }

    private fun pickRandomNumbers(): MutableList<Int>? = Randoms.pickUniqueNumbersInRange(1, 45, 6)

}