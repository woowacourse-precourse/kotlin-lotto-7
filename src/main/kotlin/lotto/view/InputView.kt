package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.InputValidator

object InputView {
    private const val SEPARATOR = ","

    private fun getUserInput(): String = Console.readLine()

    fun getSingleDigit(): Int {
        val input = getUserInput()
        InputValidator.validateInput(input)
        return input.toInt()
    }

    fun getMultipleDigit(): List<Int> {
        val input = getUserInput()
        return input.split(SEPARATOR).map {
            InputValidator.validateInput(it)
            it.toInt()
        }
    }
}
