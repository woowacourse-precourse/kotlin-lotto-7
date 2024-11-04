package lotto.controller

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.model.WinningNumber
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
            val buyLottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            buyLottoNumber.add(Lotto(buyLottoNumbers))
        }
        OutputBuyLottoNumber(buyLottoNumber)
//        validate.validateBuyLotto(buyLottoNumber)
        return inputWinningNumber()
    }


    fun inputWinningNumber() {
        while (true) {
            try {
                val winningNumber = InputView.inputWinningNumber().trim()
                validate.validateInputWiningNumber(winningNumber)
                val notAddBonusBumber =
                    WinningNumber(winningNumber.split(",").map { it.trim() }.map { it.toInt() })
                return inputBonusNumber(notAddBonusBumber)
            } catch (e: IllegalArgumentException) {
                println(e)
            }
        }
    }

    fun inputBonusNumber(notAddBonusNumber: WinningNumber) {
        while (true) {
            try {
                val bonusNumber = InputView.inputBonusNumber().trim()
                validate.validateBonusNumber(bonusNumber)

                notAddBonusNumber.addBonusNumber(bonusNumber.toInt())
            } catch (e: IllegalArgumentException) {
                println(e)
            }
        }
    }

}