package lotto

import camp.nextstep.edu.missionutils.Randoms
import kotlin.properties.Delegates

class LottoMachine {
    var payment by Delegates.notNull<Int>()
    var purchasedLotto = PurchasedLotto()
    private val ioHandler = IOHandler()

    init {
        val input = ioHandler.inputToUser(PAYMENRFIRSTINSTRUCTION)

        payment = getCorrectPayment(input)
        purchasedLotto.amountOfLotto = calculateAmountOfLotto()
        repeat(purchasedLotto.amountOfLotto) {
            purchasedLotto.purchasedLotto.add(LottoNumbering().lottoNumbering())
        }
        when (Validation().isZero(purchasedLotto.amountOfLotto)) {
            true -> ioHandler.outputForZeroOfLotto()
            false -> ioHandler.outputForPurchasedLotto(purchasedLotto)
        }
    }

    private fun calculateAmountOfLotto(): Int {
        return payment / 1000
    }

    private fun getCorrectPayment(input: String): Int {
        var tempInput = input

        return try {
            Validation().checkPayment(tempInput)
        } catch (e: IllegalArgumentException) {
            tempInput = ioHandler.inputToUser("${e.message} $PAYMENTRETRYINSTRUCTION")
            getCorrectPayment(tempInput)
        }
    }

    companion object {
        const val PAYMENRFIRSTINSTRUCTION = "구입금액을 입력해 주세요."
        const val PAYMENTRETRYINSTRUCTION = "구입금액을 다시 입력해주세요."
    }
}

class LottoNumbering {

    fun lottoNumbering(): List<Int> {
        val lottoNumbers = pickLottoNumber()

        Validation().checkNumbering(lottoNumbers)
        return sortLottoNumber(lottoNumbers)
    }

    private fun pickLottoNumber(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }

    private fun sortLottoNumber(lottoNumbers: List<Int>): List<Int> {
        return lottoNumbers.sorted()
    }
}