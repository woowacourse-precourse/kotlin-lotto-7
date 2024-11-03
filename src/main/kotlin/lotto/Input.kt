package lotto

object Input {

    init {
        inputPurchaseAmount()
        inputWinningNumber()
        inputBonusNumber()
    }
    private fun inputPurchaseAmount(){
        Instructions.purchaseAmountInstructions()
        val purchaseAmount = readln().toInt()
    }

    private fun inputWinningNumber(){
        Instructions.winningNumberInstructions()
        val winningNumber = readLine()!!.split(",").map { it.trim().toInt() }
    }

    private fun inputBonusNumber(){
        Instructions.bonusNumberInstructions()
        val bonusNumber = readln().toInt()
    }

}