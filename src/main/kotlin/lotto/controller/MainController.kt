package lotto.controller

import lotto.model.LotteryGenerator
import lotto.model.WinningCalculator
import lotto.util.Transformer
import lotto.util.Validator
import lotto.view.Input
import lotto.view.Output

class MainController {
    fun execute(){
        Output.printMoneyToInput()
        val money = readAndValidateMoney().toInt()
        Output.printPurchaseDetails(money)
        val lottoGenerator = LotteryGenerator()
        lottoGenerator.makeLotto(money)
        Output.printLottoDetails(lottoGenerator.getLotteries())
        Output.printWinningNumberToInput()
        val winningNumber = Transformer().stringToLotto(readAndValidateWinningNumber())
        Output.printBonusNumberToInput()
        val bonusNumber = readAndValidateBonusNumber().toInt()
        val calculator = WinningCalculator()
        val result = calculator.calculateDetails(winningNumber,bonusNumber,lottoGenerator.getLotteries())
        Output.printWinningDetails(result)
        Output.printReturnRate(calculator.calculateReturnRate(money,result))
    }

    private fun readAndValidateMoney() : String{
        return try {
            val money = Input.read()
            Validator().validateMoneyInput(money)
            money
        } catch (e: IllegalArgumentException) {
            readAndValidateMoney()
        }
    }

    private fun readAndValidateWinningNumber() : String{
        return try {
            val winningNumber = Input.read()
            Validator().validateWinningNumberInput(winningNumber)
            winningNumber
        } catch (e: IllegalArgumentException) {
            readAndValidateWinningNumber()
        }
    }

    private fun readAndValidateBonusNumber() : String{
        return try {
            val bonusNumber = Input.read()
            Validator().validateBonusNumberInput(bonusNumber)
            bonusNumber
        } catch (e: IllegalArgumentException) {
            readAndValidateBonusNumber()
        }
    }
}