package lotto.controller

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.utils.Validator
import lotto.view.OutputView.OutputBuyLottoNumber
import lotto.viewm.InputView


object Controller {
    val validate = Validator()
    private var lottoBuyNumber = 0
    fun run() {
        while (true) {
            try {
                val purchaseAmount = InputView.inputPurchaseAmount().trim()
                validate.validateInputAmount(purchaseAmount)
                lottoBuyNumber = purchaseAmount.toInt() / 1000
                return printBuyLottoNumber()
            } catch (e: IllegalArgumentException) {
                println(e)
            }
        }
    }

    fun printBuyLottoNumber() {
        val buyLottoNumber = mutableListOf<Lotto>()
        println("${lottoBuyNumber}개를 구매했습니다")

        repeat(lottoBuyNumber) {
            val buyLottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            buyLottoNumber.add(Lotto(buyLottoNumbers))
        }
        OutputBuyLottoNumber(buyLottoNumber)
    }


//    fun inputWinningNumber() {
//        while (true) {
//            try {
//
//            } catch (e: IllegalArgumentException) {
//                println(e)
//            }
//        }
//    }

}