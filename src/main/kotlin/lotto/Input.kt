package lotto

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
                Validator.validatePurchaseAmount(purchaseAmount)
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
                val winningNumber = readLine()
                Validator.validateWinningNumber(winningNumber)
                LottoSystem.saveWinningNumber(winningNumber.split(",").map { it.trim().toInt() })
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
                val bonusNumber = readLine()
                Validator.validateBonusNumber(bonusNumber)
                LottoSystem.saveBonusNumber(bonusNumber.toInt())
                return
            }catch (e:IllegalArgumentException){
                println(e.message)
            }
        }
    }

}