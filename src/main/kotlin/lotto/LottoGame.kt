package lotto

import java.lang.IllegalArgumentException

class LottoGame {
    private val view = View()
    private val broadcast = Broadcast()

    private lateinit var inputPayment: Payment

    fun start() {
        inputPayment = tryInputPayment()

        val lottoMachine = LottoMachine(inputPayment.getPayment())
        val lottoList = lottoMachine.lottoList
        broadcast.printLottoNumbers(lottoList)

        val winningNumber = tryInputWinningNumber()
        val bonusNumber = tryInputBonusNumber(winningNumber)

        val winningResult = lottoMachine.winningLotteryResult(lottoList, bonusNumber)
        val prizeCount = lottoMachine.countPrize(winningResult)
        val winningMessage = lottoMachine.getWinningMessage(prizeCount)

        broadcast.printWinningStatistics(winningMessage)
        broadcast.printProfit(lottoMachine.getPrize(), inputPayment.getPayment())
    }

    private fun tryInputPayment(): Payment {
        while (true) {
            try {
                return view.inputPayment()
            } catch (e: IllegalArgumentException) {
                println("\n${e.message}")
            }
        }
    }

    private fun tryInputWinningNumber(): WinningNumber {
        while (true) {
            try {
                return view.inputWinningNumber()
            } catch (e: IllegalArgumentException) {
                println("\n${e.message}")
            }
        }
    }

    private fun tryInputBonusNumber(winningNumber: WinningNumber): BonusNumber {
        while (true) {
            try {
                return view.inputBonusNumber(winningNumber)
            } catch (e: IllegalArgumentException) {
                println("\n${e.message}")
            }
        }
    }
}