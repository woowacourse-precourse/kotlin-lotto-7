package lotto.view

class OutputView {

    fun printPurchasedLottoCount(number: Int) {
        println("\n" + PURCHASE_NUMBER_PROMPT.format(number))
    }

    fun printPurchasedLottoNumbers(lottoNumbers: List<List<Int>>) {
        lottoNumbers.forEach { println(it) }
    }

    companion object {
        private const val PURCHASE_NUMBER_PROMPT = "%s개를 구매했습니다."
    }
}
