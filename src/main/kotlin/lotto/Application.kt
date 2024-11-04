package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    inputHowMuch()
}

fun inputHowMuch() {
    val inputMessage = "구입금액을 입력해 주세요."
    println(inputMessage)
    val money = Console.readLine()
    validateMoney(money)
}

fun validateMoney(input : String) {
    validateEmpty(input)
    validateBlank(input)
    validateBecomeNumber(input)
    validateNaturalNumber(input)
    validate1000won(input)
}

fun validateEmpty(input : String){
    val exceptionMessage = "[ERROR] 입력이 들어오지 않았습니다."
    require(input.isNotEmpty()){throw IllegalArgumentException(exceptionMessage)}
}

fun validateBlank(input : String){
    val exceptionMessage = "[ERROR] 입력에 공백만이 있습니다."
    require(input.isNotBlank()){throw IllegalArgumentException(exceptionMessage)}
}

fun validateBecomeNumber(input : String){
    val exceptionMessage = "[ERROR] 정수로 변환할수 없습니다."
    require(input.toIntOrNull() is Int){throw NumberFormatException(exceptionMessage)}
}

fun validateNaturalNumber(input: String){
    val exceptionMessage = "[ERROR] 자연수가 아닙니다."
    require(0 < input.toInt()){throw IllegalArgumentException(exceptionMessage)}
}

fun validate1000won(input: String){
    val exceptionMessage = "[ERROR] 1000원 단위가 아닙니다."
    require(input.toInt()%1000 == 0){throw IllegalArgumentException(exceptionMessage)}
}