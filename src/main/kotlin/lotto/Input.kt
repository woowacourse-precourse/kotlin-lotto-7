package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Input {
    var ticket = 0
    val output = Output()
    lateinit var lottos: MutableList<MutableList<Int>>
    lateinit var correctLotto: List<String>
    lateinit var correctIntLotto: List<Int>
    lateinit var lotto: Lotto

    fun input(): String {
        return Console.readLine()
    }


    fun inputMoney(input: String) {
        while (true) {
            try {
                val money = confirmInteger(input)
                confirmNullOrBlank(input)
                confirmNegativeOrZero(money)
                ticket = confirmDivider(money)
                return
            } catch (e: CustomErrorHandler) {
                output.output("\n" + e.message + "\n")
                output.outPutMoney()
                continue
            }
        }
    }

    //숫자가 아닌 경우
    private fun confirmInteger(money: String): Int {
        val intMoney: Int
        try {
            intMoney = money.toInt()
        } catch (e: NumberFormatException) {
            throw CustomErrorHandler("[ERROR] 숫자만 입력할 수 있습니다.", CustomException.NUMBER)
        }
        return intMoney
    }

    //금액이 0이거나 음수인 경우
    private fun confirmNegativeOrZero(money: Int) {
        if (money <= 0) {
            throw CustomErrorHandler("[ERROR] 티켓은 양의 정수만 입력할 수 있습니다.", CustomException.INTEGER)
        }
    }

    //티켓이 1000원 단위로 나누어 떨어 지지 않는 경우
    private fun confirmDivider(ticket: Int): Int {
        if (ticket % 1000 != 0) {
            throw CustomErrorHandler("[ERROR] 티켓은 1000원 단위로만 입력할 수 있습니다.", CustomException.DIVIDE)
        }
        return ticket / 1000
    }

    //빈 값
    private fun confirmNullOrBlank(inputNumber: String) {
        if (inputNumber.isBlank()) {
            throw CustomErrorHandler("[ERROR] 로또 번호가 비어있습니다.", CustomException.BLANK)
        }
    }

    //구입한 만큼 로또 번호생성
    fun buyTicket() {
        lottos = mutableListOf()
        for (i in 0 until ticket) {
            lottos.add(Randoms.pickUniqueNumbersInRange(1, 45, 6))
        }
        output.outPutTicket(ticket, lottos)
    }




}