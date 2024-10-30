package view

import camp.nextstep.edu.missionutils.Console.readLine
import domain.enums.Input
import domain.validator.InputValidator
import util.retryWhenNoException

class InputView(
    private val validator: InputValidator,
) {
    init {
        getPayment()
    }

    private fun getPayment(){
        val pay = retryWhenNoException {
            println(Input.INPUT_PAY.toString())
            val pay = readLine()
            validator(pay)
        }
    }
}