package lotto
import camp.nextstep.edu.missionutils.Console as con
class Input {
    fun getInputMoney(): Int {
        var input=con.readLine()
        try {
            val result : Int=input.toInt()%1000
            if(result!=0){
                throw IllegalArgumentException()
            }
            return input.toInt()
        }
        catch (e : IllegalArgumentException){
            return -1
        }
    }

    fun getWinningNum(): List<Int> {
        val winningNum = mutableListOf<Int>()
        try {
            val inputString: List<String> = con.readLine().split(",")
            for (i in inputString){
                winningNum.addLast(i.toInt())
            }
            return winningNum
        }
        catch (e : IllegalArgumentException){
            return listOf(1)
        }
    }

    fun getBonusNum(winningNums : List<Int>): Int {
        try {
            val bonusNum: Int=con.readLine().toInt()
            Lotto(winningNums).checkBonusNum(bonusNum)
            return bonusNum
        }
        catch (e : IllegalArgumentException){
            println("[ERROR] 올바른 숫자를 입력하시오")
            return -1
        }
    }


}