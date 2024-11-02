package lotto

import camp.nextstep.edu.missionutils.Console
import java.lang.NumberFormatException

class Output {

    fun output(message : String) = println(message)
    fun outPutMoney(){
        println("구입금액을 입력해 주세요.\n")
    }

    fun outPutTicket(ticket : Int, lottoList : List<List<Int>>){
        println("${ticket}개를 구매했습니다.\n")
        for(list in lottoList){
            println(list)
        }
        println()
    }

}