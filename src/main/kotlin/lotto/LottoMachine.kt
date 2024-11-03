package lotto

import camp.nextstep.edu.missionutils.Console
class LottoMachine() {

    fun payLottoery():Int {
        println("구입금액을 입력해주세요.")
        val payment = Console.readLine()
        return payment.toInt()
    }
}