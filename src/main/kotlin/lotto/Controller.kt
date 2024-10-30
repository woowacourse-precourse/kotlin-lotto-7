package lotto

import lotto.view.InputView
import lotto.validator.*

class Controller {

    val input = InputView()
    val inputValidator = InputValidator()

    fun start(){
        var money = input.getMoney()
        while(!inputValidator.isValidMoney(money)){
            money = input.getMoney()
        }
    }

}