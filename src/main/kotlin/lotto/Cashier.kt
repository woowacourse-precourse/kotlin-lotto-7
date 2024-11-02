package lotto

class Cashier {

    fun calculateLottoCount(amount: LottoAmount): Int {
        return amount.lottoAmount / 1_000
    }
}