package lotto.view

object GuideOutput {
    fun amount(){
        println(InputUserGuide.MONEY)
    }
    fun winNumber(){
        newline()
        println(InputUserGuide.NUMBER)
    }

    fun bonusNumber(){
        newline()
        println(InputUserGuide.BONUS)
    }

    private fun newline() = println()
}