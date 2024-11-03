package lotto.controller

import lotto.model.LottoGenerator
import lotto.model.WinningCalculator
import lotto.view.Input
import lotto.view.Output

class MainController {
    fun execute(){
        val money = Input.readMoney()
        Output.printPurchaseDetails(money)
        val lottoGenerator = LottoGenerator()
        lottoGenerator.makeLotto(money)
        Output.printLottoDetails(lottoGenerator.getLottoes())
        val winningNumber = Input.readWinningNumber()
        val bonusNumber = Input.readBonusNumber()
        val calculator = WinningCalculator()
        val result = calculator.calculateDetails(winningNumber,bonusNumber,lottoGenerator.getLottoes())
        Output.printWinningDetails(result)
        Output.printReturnRate(calculator.calculateReturnRate(money,result))
    }
}