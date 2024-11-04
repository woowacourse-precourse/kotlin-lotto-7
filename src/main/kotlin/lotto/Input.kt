package lotto

import camp.nextstep.edu.missionutils.Console.readLine

object Input {

    fun start() {
        inputPurchaseAmount()
        inputWinningNumber()
        inputBonusNumber()
    }
    private fun inputPurchaseAmount(){
        Instructions.purchaseAmountInstructions()
        val purchaseAmount = readLine().toInt()
        LottoSystem.savePurchaseAmount(purchaseAmount)
    }

    private fun inputWinningNumber(){
        Instructions.winningNumberInstructions()
        val winningNumber = readLine().split(",").map { it.trim().toInt() }
        LottoSystem.saveWinningNumber(winningNumber)
    }

    private fun inputBonusNumber(){
        Instructions.bonusNumberInstructions()
        val bonusNumber = readLine().toInt()
        LottoSystem.saveBonusNumber(bonusNumber)
    }

}