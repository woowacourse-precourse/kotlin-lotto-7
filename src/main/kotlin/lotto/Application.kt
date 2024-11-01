package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현

    val price = Input.purchasePrice()

    println("구매 가격은 " + price +"원 입니다.")
}

// [#] 입력 기능
object Input {
    // [1] 구매 금액 입력 기능
    fun purchasePrice(): Int {
        println("구입금액을 입력해 주세요.")
        val price = Console.readLine().toInt()
        try {
            if (price % 1000 != 0)
                throw IllegalArgumentException("[ERROR] 잘못된 구매 금액")
        }
        catch (e: IllegalArgumentException){
            println(e.message)
            return -1
        }
        return price
    }

    // [2] 당첨 번호 입력 기능
    fun setLottoNumber(list : List<Int>){

    }

}
