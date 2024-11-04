package lotto.controller

import lotto.model.*
import lotto.view.InputView.getBonusNum
import lotto.view.InputView.getCost
import lotto.view.InputView.getWinNum
import lotto.view.OutputView.printLottoNumbers
import lotto.view.OutputView.printNumbers
import lotto.view.OutputView.printResults


fun playLotto() {
    val lottoCost = getCost()
    val count = lottoCost/1000
    if(lottoCost%1000 != 0){
        throw IllegalArgumentException("[ERROR] 로또 구매 금액은 1,000원 단위이어야 합니다.")
    }
    printNumbers(count)
    val lottoTickets = generateLottoTickets(count)
    printLottoNumbers(lottoTickets.map { it.getNumbers() })

    val winNumber = getWinNum().toSet()
    val bonus = getBonusNum()

    val results = calculateResults(lottoTickets, winNumber, bonus)
    val totalPrize = calculateTotalPrize(results)

    printResults(results, totalPrize, lottoCost)
}

