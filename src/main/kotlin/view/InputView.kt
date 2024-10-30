package view

import camp.nextstep.edu.missionutils.Console.readLine
import delegate.common.CommonErrorDelegate
import util.Input
import util.Process
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
            isValid(pay)
        }
    }

    private fun isValid(value: String){
        val process = Process.PAY
        commonErrorDelegator.isEmpty(value)
        commonErrorDelegator.isNumeric(value, process)
    }
}