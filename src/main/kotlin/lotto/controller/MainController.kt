package lotto.controller

import lotto.model.LottoGenerator
import lotto.view.Input
import lotto.view.Output

class MainController {
    fun execute(){
        val money = Input.readMoney()
        Output.printPurchaseDetails(money)
        LottoGenerator().makeLotto(money)
    }
}