package lotto.controller

import lotto.model.Lotto
import lotto.model.randomNums
import lotto.view.InputView.getBonusNum
import lotto.view.InputView.getCost
import lotto.view.InputView.getWinNum
import lotto.view.OutputView.printLottoNumbers
import lotto.view.OutputView.printNumbers


fun playLotto() {
    val lottoCost = getCost()
    val count = lottoCost/1000
    if(lottoCost%1000 != 0){
        throw IllegalArgumentException("[ERROR] 로또 구매 금액은 1,000원 단위이어야 합니다.")
    }
    printNumbers(count)
    val lottoTickets = generateLottoTickets(count)
    printLottoNumbers(lottoTickets.map { it.numbers })

    val winNumber = getWinNum()
    val bonus = getBonusNum()
}

fun generateLottoTickets(count: Int): List<Lotto> {
    return List(count) { Lotto(randomNums()) }
}
