package lotto

import lotto.CustomException.*
import java.lang.RuntimeException

class CustomErrorHandler(override val message: String, private val exception: CustomException) : RuntimeException(){
    private lateinit var customException : CustomException
    fun invoke(){
        this.customException = exception
    }

}