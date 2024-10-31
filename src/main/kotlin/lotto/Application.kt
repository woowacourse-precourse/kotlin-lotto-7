package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.util.LottoOutputText

fun main() {
    // TODO: 예외 발생 후에도 항상 해당 부분 부터 다시 입력을 받는다.
    println(LottoOutputText.INPUT_PURCHASE_PRICE_TEXT)
    val purchasePrice = Console.readLine().toInt()  // TODO: 입력 예외 처리 필요
    println()

    val lottoGenerator = LottoGenerator(purchasePrice)
    lottoGenerator.generate()
}
