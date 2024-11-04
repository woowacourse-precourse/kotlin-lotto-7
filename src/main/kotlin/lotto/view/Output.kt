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
    fun randomLotto(tryCount: Int, number: MutableList<MutableList<Int>>) {
        newline()
        println("$tryCount${OuputString.TRY_COUNT}")
        number.forEach {
            println(it)
        }
    }

    fun result(matche: List<Int>, revenue: Int) {
        println("${OuputString.RESULT}")
        println("${OuputString.BAR}")
        println("${OuputString.MATCHE_3}$matche[0]${OuputString.MATCHE_END}")
        println("${OuputString.MATCHE_4}$matche[1]${OuputString.MATCHE_END}")
        println("${OuputString.MATCHE_5}$matche[2]${OuputString.MATCHE_END}")
        println("${OuputString.MATCHE_5_BONUS}$matche[3]${OuputString.MATCHE_END}")
        println("${OuputString.MATCHE_6}$matche[4]${OuputString.MATCHE_END}")
        println("${OuputString.REVENUE}$revenue${OuputString.REVENUE_END}")
    }

    private fun newline() = println()
}