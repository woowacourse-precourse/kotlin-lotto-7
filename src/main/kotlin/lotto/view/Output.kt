package lotto.view

import lotto.utils.InputUserGuide
import lotto.utils.OuputString

object GuideOutput {
    fun amount() {
        println(InputUserGuide.MONEY)
    }

    fun winNumber() {
        newline()
        println(InputUserGuide.NUMBER)
    }

    fun bonusNumber() {
        newline()
        println(InputUserGuide.BONUS)
    }

    private fun newline() = println()
}

object UserFeedback {
    fun randomLotoo(tryCount: Int, number: MutableList<MutableList<Int>>) {
        println("$tryCount${OuputString.TRY_COUNT}")
        number.forEach {
            println(it)
        }
    }
}