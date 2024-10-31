package lotto

import lotto.model.Lotto
import lotto.model.LottoGenerator
import lotto.view.InputView
import lotto.validator.*
import lotto.view.OutputView

class Controller {

    val input = InputView()
    val output = OutputView()
    val inputValidator = InputValidator()
    val lottoGenerator = LottoGenerator()

    fun start(){

        var money : String
        while(true){
            money = input.getMoney()
            if(inputValidator.isValidMoney(money)) break
            ValidatorMessage.INPUT_MONEY.display()
        }
        val numberOfLotto = lottoGenerator.getNumberOfLotto(money)
        val randomLotto = lottoGenerator.generateLotto(numberOfLotto)

        output.displayLotto(numberOfLotto,randomLotto)

    }


}