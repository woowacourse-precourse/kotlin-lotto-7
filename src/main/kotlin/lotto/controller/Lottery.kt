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
    printNumbers(count)
    val lottoTickets = generateLottoTickets(count)
    printLottoNumbers(lottoTickets.map { it.getNumbers() })

    val winNumber = getWinNum().toSet()
    val bonus = getBonusNum(lottoTickets.map { it.getNumbers() })

    val results = calculateResults(lottoTickets, winNumber, bonus)
    val totalPrize = calculateTotalPrize(results)

    printResults(results, totalPrize, lottoCost)
}

