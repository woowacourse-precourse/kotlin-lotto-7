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
        val beforeValidationWinningNumber = Input.read()

        val winningNumber = Transformer().stringToLotto(beforeValidationWinningNumber)
        Output.printBonusNumberToInput()
        val beforeValidationBonusNumber = Input.read()

        val bonusNumber = beforeValidationBonusNumber.toInt()
        val calculator = WinningCalculator()
        val result = calculator.calculateDetails(winningNumber,bonusNumber,lottoGenerator.getLotteries())
        Output.printWinningDetails(result)
        Output.printReturnRate(calculator.calculateReturnRate(money,result))
    }

    private fun readAndValidateMoney() : String{
        return try {
            val beforeValidationMoney = Input.read()
            Validator().validateMoneyInput(beforeValidationMoney)
            beforeValidationMoney
        } catch (e: IllegalArgumentException) {
            readAndValidateMoney()
        }
    }
}