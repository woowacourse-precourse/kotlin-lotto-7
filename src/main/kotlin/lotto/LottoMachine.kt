package lotto

class LottoMachine(private val payment: String) {

    fun calculateTotalLottoCount(): Int {
        return payment.toInt() / LOTTO_PRICE
    }


    companion object {
        const val LOTTO_PRICE = 1000
    }
}