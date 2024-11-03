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
                output.outPutMoney()
                val input = input()
                confirmNullOrBlank(input)
                val money = confirmInteger(input)
                confirmNegativeOrZero(money)
                ticket = confirmDivider(money)
                return
            } catch (e: CustomErrorHandler) {
                output.output(e.message + "\n")
                continue
            }
        }
    }

    private fun confirmInteger(money: String): Int {
        return try {
            money.toInt()
        } catch (e: NumberFormatException) {
            throw CustomErrorHandler("[ERROR] 숫자만 입력할 수 있습니다.", CustomException.NUMBER)
        }
    }

    private fun confirmNegativeOrZero(money: Int) {
        if (money <= 0) {
            throw CustomErrorHandler("[ERROR] 티켓은 양의 정수만 입력할 수 있습니다.", CustomException.INTEGER)
        }
    }

    private fun confirmDivider(ticket: Int): Int {
        if (ticket % 1000 != 0) {
            throw CustomErrorHandler("[ERROR] 티켓은 1000원 단위로만 입력할 수 있습니다.", CustomException.DIVIDE)
        }
        return ticket / 1000
    }

    private fun confirmNullOrBlank(inputNumber: String) {
        if (inputNumber.isBlank()) {
            throw CustomErrorHandler("[ERROR] 로또 번호가 비어있습니다.", CustomException.BLANK)
        }
    }

    private fun buyTicket() {
        lottos = mutableListOf()
        for (i in 0 until ticket) {
            lottos.add(Randoms.pickUniqueNumbersInRange(1, 45, 6))
            lottos[i].sort()
        }
        output.outPutTicket(ticket, lottos)
    }

    private fun correctLottoNumber() {
        while (true) {
            try {
                output.printLotto(LottoType.LOTTO)
                val resultLotto = input()
                correctLotto = resultLotto.split(",")

                // 6개의 숫자인지 먼저 확인
                confirmLottoCount(correctLotto)

                // 각 숫자의 유효성을 한번에 검사하고 변환
                correctIntLotto = correctLotto.map { number ->
                    validateAndConvertNumber(number)
                }

                // 중복 검사
                checkLottoDuplicate(correctIntLotto)

                lotto = Lotto(correctIntLotto)
                break
            } catch (e: CustomErrorHandler) {
                output.output(e.message + "\n")
                continue
            }
        }
    }

    private fun inputBonusNumber() {
        while (true) {
            try {
                output.printLotto(LottoType.BONUS)
                val bonusNumber = input()
                val bonusInt = validateAndConvertNumber(bonusNumber)
                checkBonusDuplicate(bonusInt)
                lotto.compareLotto(lottos, bonusInt)
                break
            } catch (e: CustomErrorHandler) {
                output.output(e.message + "\n")
                continue
            }
        }
    }

    private fun validateAndConvertNumber(input: String): Int {
        // 빈 값 체크
        if (input.isBlank()) {
            throw CustomErrorHandler("[ERROR] 로또 번호가 비어있습니다.", CustomException.BLANK)
        }

        // 숫자 변환
        val number = try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw CustomErrorHandler("[ERROR] 숫자만 입력할 수 있습니다.", CustomException.NUMBER)
        }

        // 음수나 0 체크
        if (number <= 0) {
            throw CustomErrorHandler("[ERROR] 로또 번호는 1이상 45이하의 정수여야 합니다.", CustomException.INTEGER)
        }

        // 범위 체크
        if (number > 45) {
            throw CustomErrorHandler("[ERROR] 로또 번호는 1이상 45이하의 정수여야 합니다.", CustomException.BOUNDARY)
        }

        return number
    }

    private fun confirmLottoCount(lottos: List<String>) {
        if (lottos.size != 6) {
            throw CustomErrorHandler("[ERROR] 로또 번호는 6개여야 합니다.", CustomException.BLANK)
        }
    }

    private fun checkLottoDuplicate(numbers: List<Int>) {
        if (numbers.distinct().size != 6) {
            throw CustomErrorHandler("[ERROR] 로또 번호에 중복된 숫자가 있습니다.", CustomException.DUPLICATE)
        }
    }

    private fun checkBonusDuplicate(number: Int) {
        if (correctIntLotto.contains(number)) {
            throw CustomErrorHandler("[ERROR] 로또 번호에 중복된 숫자가 있습니다.", CustomException.DUPLICATE)
        }
    }

    private fun checkList() {
        output.outPutPostCorrectList(lotto.checkList)
    }

    private fun rate() {
        output.printRate(lotto.resultMoney, ticket * 1000)
    }
}