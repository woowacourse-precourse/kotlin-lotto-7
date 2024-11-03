package lotto.controller

import lotto.model.LotteryGenerator
import lotto.model.WinningCalculator
import lotto.view.Input
import lotto.view.Output

class MainController {
    fun execute(){
        val money = Input.readMoney()
        Output.printPurchaseDetails(money)
        val lottoGenerator = LotteryGenerator()
        lottoGenerator.makeLotto(money)
        Output.printLottoDetails(lottoGenerator.getLotteries())
        val winningNumber = Input.readWinningNumber()
        val bonusNumber = Input.readBonusNumber()
        val calculator = WinningCalculator()
        val result = calculator.calculateDetails(winningNumber,bonusNumber,lottoGenerator.getLotteries())
        Output.printWinningDetails(result)
        Output.printReturnRate(calculator.calculateReturnRate(money,result))
    }
}