package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoSystem {
    private lateinit var winningNumber: List<Int>
    private var bonusNumber: Int = 0
    private var purchaseAmount: Int = 0
    private var numberOfPurchases: Int = 0
    private var randomNumbers = mutableListOf<MutableList<Int>?>()

    init {
        Input
    }

    fun getRandomNumbers(): MutableList<MutableList<Int>?> = randomNumbers

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