package lotto

import camp.nextstep.edu.missionutils.Randoms
import kotlin.properties.Delegates

class LottoMachine {
    var payment by Delegates.notNull<Int>()
    var purchasedLotto = PurchasedLotto()
    private val ioHandler = IOHandler()

    init {
        payment = insertMoney(PAYMENRFIRSTINSTRUCTION)
        purchasedLotto.amountOfLotto = calculateAmountOfLotto()
        repeat(purchasedLotto.amountOfLotto) {
            purchasedLotto.purchasedLotto.add(LottoNumbering().lottoNumbering())
        }
        when (Validation().isZero(purchasedLotto.amountOfLotto)) {
            true -> ioHandler.outputForZeroOfLotto()
            false -> ioHandler.outputForPurchasedLotto(purchasedLotto)
        }
    }

    private fun insertMoney(inputInstruction: String): Int {
        val input = ioHandler.inputToUser(inputInstruction)

        return getCorrectPayment(input)
    }

    private fun calculateAmountOfLotto(): Int {
        return payment / 1000
    }

    private fun getCorrectPayment(input: String): Int {
        return try {
            Validation().checkPayment(input)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            insertMoney(PAYMENTRETRYINSTRUCTION)
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