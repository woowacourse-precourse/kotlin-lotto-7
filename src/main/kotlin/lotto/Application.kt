package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

// # 메인 함수
fun main() {
    // TODO: 프로그램 구현

    val price = Input.purchasePrice()
    println("price: $price")

    val list = Input.setWinningNumber()
    println("list = $list")

    val bonus = Input.setBonusNumber()
    println("bonus = $bonus")

}

// [#] 입력 기능
object Input {
    // [1] 구매 금액 입력 기능
    fun purchasePrice(): Int {
        println("구입금액을 입력해 주세요.")
        val input = Console.readLine()
            ?.takeIf { it.isNotBlank() }
            ?: throw IllegalArgumentException("[ERROR] 입력 값을 다시 확인해주세요.")
        val price = input.toInt()
        require(price % 1000 == 0){"[ERROR] 구매 금액을 올바르게 입력해주세요."}
        return price
    }

    // [2] 당첨 번호 입력 기능, 공백 허용
    fun setWinningNumber() : List<Int> {
        println("당첨 번호를 입력해 주세요.")
        val winningNumber = Console.readLine().split(",").map { it.trim().toInt() }
        require(winningNumber.size == 6){"[ERROR] 당첨 번호는 6개여야 합니다."}
        require(winningNumber.all{ it > 0 && it < 46 }){"[ERROR] 1에서 45 사이의 숫자만 입력 가능합니다."}
        require(winningNumber.toSet().size == 6){"[ERROR] 중복 없는 6개 번호를 입력해주세요."}
        return winningNumber
    }

    // [3] 보너스 번호 입력 기능
    fun setBonusNumber() : Int{
        println("보너스 번호를 입력해 주세요.")
        val input = Console.readLine()
            ?.takeIf { it.isNotBlank() }
            ?: throw IllegalArgumentException("[ERROR] 입력 값을 다시 확인해주세요.")
        val bonusNumber = input.toInt()
        require( bonusNumber > 0 && bonusNumber < 46) {"[ERROR] 보너스 번호 값을 다시 확인해주세요."}
        return bonusNumber
    }

}
