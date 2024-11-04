package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Console.readLine

object Input {

    fun start() {
        inputPurchaseAmount()
        inputWinningNumber()
        inputBonusNumber()
    }
    private fun inputPurchaseAmount(){
        while (true){
            try {
                Instructions.purchaseAmountInstructions()
                val purchaseAmount = readLine()
                Validator.checkPurchaseAmount(purchaseAmount)
                LottoSystem.savePurchaseAmount(purchaseAmount.toInt())
                return
            }catch (e:IllegalArgumentException){
                println(e.message)
            }
        }
    }

    private fun inputWinningNumber(){
        while (true){
            try {
                Instructions.winningNumberInstructions()
                val winningNumber = readLine().split(",").map { it.trim().toInt() }
                LottoSystem.saveWinningNumber(winningNumber)
                return
            }catch (e:IllegalArgumentException){
                println(e.message)
            }
        }
    }

    private fun inputBonusNumber(){
        while (true){
            try {
                Instructions.bonusNumberInstructions()
                val bonusNumber = readLine().toInt()
                LottoSystem.saveBonusNumber(bonusNumber)
                return
            }catch (e:IllegalArgumentException){
                println(e.message)
            }
        }
    }

}