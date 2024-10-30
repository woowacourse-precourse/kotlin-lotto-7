package lotto

import lotto.view.InputView
import lotto.validator.*

class Controller {

    val input = InputView()
    val inputValidator = InputValidator()

    fun start(){

        var money : String
        while(true){
            money = input.getMoney()
            if(inputValidator.isValidMoney(money)) break
            ValidatorMessage.INPUT_MONEY.display()
        }
    }

}