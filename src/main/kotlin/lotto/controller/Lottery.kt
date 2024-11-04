package lotto.controller

import lotto.model.Lotto
import lotto.model.randomNums
import lotto.view.InputView.getBonusNum
import lotto.view.InputView.getCost
import lotto.view.InputView.getWinNum
import lotto.view.OutputView.printNumbers


fun playLotto() {
    val lottoCost = getCost()
    val count = lottoCost/1000
    if(lottoCost%1000 != 0){
        throw IllegalArgumentException("[ERROR] 로또 구매 금액은 1,000원 단위이어야 합니다.")
    }
    printNumbers(count)
    for(i in 0..<count){
        val l0 = Lotto(randomNums())
        l0.printNumbers()
    }

    val winNumber = getWinNum()
    val bonus = getBonusNum()
}
