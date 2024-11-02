package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.util.LottoConstants
import lotto.util.LottoOutputText

fun main() {
    // TODO: 예외 발생 후에도 항상 해당 부분 부터 다시 입력을 받는다.
    println(LottoOutputText.INPUT_PURCHASE_PRICE_TEXT)
    val purchasePrice = Console.readLine().toInt()  // TODO: 입력 예외 처리 필요
    println()

    val lottoGenerator = LottoGenerator(purchasePrice)
    val lottoList = lottoGenerator.generate()
    val lottoListSize = lottoList.size
    println("${lottoListSize}${LottoOutputText.LOTTO_GENERATE_FINISH_TEXT}")
    lottoList.forEach { lotto ->
        println(lotto.getSortedNumbers())
    }
    println()

    println(LottoOutputText.INPUT_WINNING_NUMBERS)
    val winningNumbers = Console.readLine()
        .split(LottoConstants.WINNING_NUMBERS_DELIMITER)
        .map { it.toInt() }
    println()

    println(LottoOutputText.INPUT_BONUS_NUMBER)
    val trimBonusNumber = Console.readLine().trim() // TODO: 입력 예외 처리 필요
    val bonusNumber = trimBonusNumber.toInt()
    println()

    val lottoResult = LottoResult(lottoList, winningNumbers, bonusNumber)
    val lottoResultDetail = lottoResult.getResult()
    println("lottoResultDetail.lottoRankList: ${lottoResultDetail.lottoRankList}")
    println("lottoResultDetail.rateOfReturn: ${lottoResultDetail.roundedRateOfReturn}")
}
