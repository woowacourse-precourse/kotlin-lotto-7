package lotto

class InputValidation {

    fun checkPayment(payment: Int) {
        if(payment <= 0) {
            throw IllegalArgumentException("[ERROR] 구입 금액은 1000원 이상 입력해야 합니다.")
        }

        if((payment%1000) != 0) {
            throw IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.")
        }
    }

    fun checkLottoNum(lottoNum: List<String>) {
        lottoNum.forEach { num ->
            val lottoNumber = num.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 당첨 번호는 정수로 입력해야 합니다.")

            if (lottoNumber !in 1..45) {
                throw IllegalArgumentException("[ERROR] 당첨 번호는 1~45까지의 숫자로만 입력해야 합니다. : $num")
            }
        }

        if(lottoNum.size != 6) {
            throw IllegalArgumentException("[ERROR] 당첨 번호는 6개 입력해야 합니다.")
        }
    }

    fun checkBonusLottoNum(bonusLottoNum: Int) {
        if(bonusLottoNum !in 1..45) {
            throw IllegalArgumentException("[ERROR] 보너스 번호는 1~45까지의 숫자로만 입력해야 합니다. : $bonusLottoNum")
        }
    }

    fun checkDuplicate(lottoNum: List<Int>, bonusLottoNum: Int) {
        if(lottoNum.contains(bonusLottoNum)) {
            throw IllegalArgumentException("[ERROR] 로또 당첨 번호는 중복이 아닌 6개의 숫자여야 합니다.")
        }
    }
}