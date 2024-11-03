package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoSystem {
    private lateinit var winningNumber: List<Int>
    private var bonusNumber: Int = 0
    private var purchaseAmount: Int = 0
    private var numberOfPurchases: Int = 0
    private var randomNumbers = mutableListOf<MutableList<Int>?>()
    private var matchCounts = mutableListOf<MutableList<Int>>()
    private var ranks = mutableMapOf<LottoRank,Int>()


    init {
        Input
        checkWinning()
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

    fun getWinningNumber(): List<Int> = winningNumber

    fun getBonusNumber(): Int = bonusNumber

    fun getRandomNumbers(): MutableList<MutableList<Int>?> = randomNumbers

    private fun setRanks(){
        ranks[LottoRank.FIVE] = 0
        ranks[LottoRank.FOUR] = 0
        ranks[LottoRank.THREE] = 0
        ranks[LottoRank.TWO] = 0
        ranks[LottoRank.ONE] = 0
    }

    private fun checkWinning(){
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
    }

    private fun saveNumberOfPurchases() {
        numberOfPurchases = purchaseAmount / 1000
        PrintResult.numberOfPurchasesInstructions(numberOfPurchases)
        saveRandomNumbers(numberOfPurchases)
    }

    private fun saveRandomNumbers(numberOfPurchases: Int) {
        repeat(numberOfPurchases) {
            val randomNumber = pickRandomNumbers()
            randomNumbers.add(randomNumber!!.sorted().toMutableList())
        }
        PrintResult.printRandomNumbers()
    }

    private fun pickRandomNumbers(): MutableList<Int>? = Randoms.pickUniqueNumbersInRange(1, 45, 6)

}