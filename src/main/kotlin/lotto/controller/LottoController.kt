package lotto.controller

import camp.nextstep.edu.missionutils.Console.readLine

class LottoController {

    fun start() {
        println("구입금액을 입력해 주세요.")
        val price = readLine()
        require(price.isNotBlank()) { "[ERROR] 공백은 입력할 수 없습니다." }
    }
}