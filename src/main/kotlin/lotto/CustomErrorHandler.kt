package lotto

import lotto.CustomException.*
import java.lang.RuntimeException

class CustomErrorHandler(override val message: String, private val exception: CustomException) : RuntimeException(){
    private lateinit var customException : CustomException
    private val output = Output()
    fun inputError(){
        this.customException = exception
        output.printCustomMessage(exception)
    }
}