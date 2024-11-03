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

    fun start() {
        inputMoney()
        buyTicket()
        correctLottoNumber()
        inputBonusNumber()
        checkList()
        rate()
    }

    private fun input(): String {
        return Console.readLine()
    }

    private fun inputMoney() {
        while (true) {
            try {
                confirmMoney()
                return
            } catch (e: CustomErrorHandler) {
                output.output("\n" + e.message + "\n")
                continue
            }
        }
    }

    private fun confirmMoney(){
        output.outPutMoney()
        val input = input()
        confirmNullOrBlank(input)
        val money = confirmInteger(input)
        confirmNegativeOrZero(money)
        ticket = confirmDivider(money)
    }

    // 숫자가 아닌 경우
    // 숫자가 아닌 경우 및 Int 범위를 벗어나는 경우
    private fun confirmInteger(money: String): Int {
        val longMoney: Long
        try {
            longMoney = money.toLong()
        } catch (e: NumberFormatException) {
            throw CustomErrorHandler("[ERROR] 숫자만 입력할 수 있습니다.", CustomException.NUMBER)
        }
        if (longMoney < Int.MIN_VALUE || longMoney > Int.MAX_VALUE) {
            throw CustomErrorHandler("[ERROR] 입력한 값이 Int 범위를 벗어났습니다.", CustomException.RANGE)
        }
        return longMoney.toInt()
    }


    //금액이 0이거나 음수인 경우
    private fun confirmNegativeOrZero(money: Int) {
        if (money <= 0) {
            throw CustomErrorHandler("[ERROR] 티켓은 양의 정수만 입력할 수 있습니다.", CustomException.INTEGER)
        }
    }


    //티켓이 1000원 단위로 나누어 떨어 지지 않는 경우
    fun confirmDivider(ticket: Int): Int {
        if (ticket % 1000 != 0) {
            throw CustomErrorHandler("[ERROR] 티켓은 1000원 단위로만 입력할 수 있습니다.", CustomException.DIVIDE)
        }
        return ticket / 1000
    }

    //빈 값
    private fun confirmLottoCount(lottos: List<String>) {
        if (lottos.size != 6) {
            throw CustomErrorHandler("[ERROR] 로또 번호는 6개여야 합니다.", CustomException.BLANK)
        }
    }

    //6글자
    private fun confirmNullOrBlank(inputNumber: String) {
        if (inputNumber.isBlank()) {
            throw CustomErrorHandler("[ERROR] 로또 번호가 비어있습니다.", CustomException.BLANK)
        }
    }

    //구입한 만큼 로또 번호생성
    private fun buyTicket() {
        lottos = mutableListOf()
        for (i in 0 until ticket) {
            lottos.add(Randoms.pickUniqueNumbersInRange(1, 45, 6))
            lottos[i].sort()
        }
        output.outPutTicket(ticket, lottos)
    }

    //로또 넘버 검증 함수
    private fun correctLottoNumber() {
        while (true) {
            try {
                confirmLotto()
                break
            } catch (e: CustomErrorHandler) {
                output.output("\n" + e.message)
                continue
            }
        }
    }

    private fun confirmLotto(){
        output.printLotto(LottoType.LOTTO)
        val resultLotto = input()
        correctLotto = resultLotto.split(",")
        confirmLottoCount(correctLotto)
        correctLotto.forEach { lottoCheck(it) }
        correctIntLotto = correctLotto.map { it.toInt() }
        checkLottoDuplicate(correctIntLotto)  // 중복 체크 추가
        lotto = Lotto(correctIntLotto)
    }

    //보너스 넘버 검증 함수
    fun inputBonusNumber() {
        while (true) {
            try {
                confirmBonus()
                break
            } catch (e: CustomErrorHandler) {
                output.output("\n" + e.message)
                continue
            }
        }
    }

    private fun confirmBonus(){
        output.printLotto(LottoType.BONUS)
        val bonusNumber = input()
        lottoCheck(bonusNumber)
        val bonusInt = bonusNumber.toInt()
        checkBonusDuplicate(bonusInt)
        lotto.compareLotto(lottos, bonusInt)
    }


        //1-45 체크
    private fun middleNumberCheck(inputNumber: Int) {
        if (inputNumber !in 1..45) {
            throw CustomErrorHandler("[ERROR] 로또 번호는 1이상 45이하의 정수여야 합니다.", CustomException.BOUNDARY)
        }
    }

    //중복 체크
    fun checkLottoDuplicate(numbers: List<Int>) {
        if (numbers.distinct().size != 6) {
            throw CustomErrorHandler("[ERROR] 로또 번호에 중복된 숫자가 있습니다.", CustomException.DUPLICATE)
        }
    }
    fun checkBonusDuplicate(numbers: Int) {
        if (correctIntLotto.contains(numbers)) {
            throw CustomErrorHandler("[ERROR] 로또 번호에 중복된 숫자가 있습니다.", CustomException.DUPLICATE)
        }
    }

    fun checkList() {
        output.outPutPostCorrectList(lotto.checkList)
    }

    private fun lottoCheck(input: String) {
        try {
            confirmNullOrBlank(input)
            val number = confirmInteger(input)
            confirmNegativeOrZero(number)
            middleNumberCheck(number)
        } catch (e: CustomErrorHandler) {
            output.output("\n" + e.message)
            throw e
        }
    }


    private fun rate(){
        output.printRate(lotto.resultMoney,ticket*1000)
    }
}