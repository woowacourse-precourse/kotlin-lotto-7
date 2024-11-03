package lotto

object Input {

    fun start() {
        inputPurchaseAmount()
        inputWinningNumber()
        inputBonusNumber()
    }
    private fun inputPurchaseAmount(){
        Instructions.purchaseAmountInstructions()
        val purchaseAmount = readln().toInt()
        LottoSystem.savePurchaseAmount(purchaseAmount)
    }

    private fun inputWinningNumber(){
        Instructions.winningNumberInstructions()
        val winningNumber = readln().split(",").map { it.trim().toInt() }
        LottoSystem.saveWinningNumber(winningNumber)
    }

    private fun inputBonusNumber(){
        Instructions.bonusNumberInstructions()
        val bonusNumber = readln().toInt()
        LottoSystem.saveBonusNumber(bonusNumber)
    }

}