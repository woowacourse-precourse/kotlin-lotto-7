package view

import camp.nextstep.edu.missionutils.Console.readLine
import delegate.common.CommonErrorDelegate
import delegate.input.InputErrorDelegate
import domain.enums.Input
import domain.enums.Process
import util.retryWhenNoException

class InputView(
    private val commonErrorDelegator: CommonErrorDelegate,
    private val inputErrorDelegate: InputErrorDelegate
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
        inputErrorDelegate.isThousandWonUnit(value)
    }
}