package view

import camp.nextstep.edu.missionutils.Console.readLine
import delegate.common.CommonErrorDelegate
import util.Input
import util.retryWhenNoException

class InputView(
    private val commonErrorDelegator: CommonErrorDelegate
) {
    init {
        getPayment()
    }
    private fun getPayment(){
        retryWhenNoException {
            println(Input.INPUT_PAY.toString())
            val pay = readLine()
            commonErrorDelegator.isEmpty(pay)
        }
    }
}