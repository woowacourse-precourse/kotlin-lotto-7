package lotto.controller

import lotto.model.*
import lotto.service.RankService
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val lottoGenerator = LottoGenerator()

    fun run() {
        val purchaseAmount = getPurchaseAmount()
        val purchaseQuantity = purchaseAmount.calculatePurchaseQuantity()
        val lottoTickets = getLottoTickets(purchaseQuantity)
        outputView.printPurchaseLotto(lottoTickets, purchaseQuantity)

        val winningNumbers = getWinningNumbers()
        val winningLotto = getWinningLotto(winningNumbers)
        val rankCount = RankService.calculateLottoRank(winningLotto.winningNumbers, winningLotto.bonusNumber, lottoTickets)

        outputView.printMatchingResult(rankCount)
        val totalReturn = RankService.calculateTotalReturn(purchaseAmount)
        outputView.printTotalRateOfReturn(totalReturn)
    }

    private fun getPurchaseAmount(): PurchaseAmount {
        return try {
            outputView.printPurchaseAmountRequest()
            val userInput = inputView.readLine().toInt()
            PurchaseAmount(userInput)
        } catch(e:IllegalArgumentException) {
            println(e.message)
            getPurchaseAmount()
        }
    }

    private fun getLottoTickets(quantity: Int): List<Lotto> {
        val lottos = mutableListOf<Lotto>()
        repeat(quantity) {
            lottos.add(lottoGenerator.createLotto())
        }
        return lottos
    }

    private fun getWinningNumbers(): Lotto {
        return try{
            outputView.printWinningLottoRequest()
            val userInput = inputView.readLine().split(",").map { it.trim().toInt() }
            Lotto(userInput)
        } catch (e:IllegalArgumentException) {
            println(e.message)
            getWinningNumbers()
        }
    }

    private fun getWinningLotto(winningNumbers: Lotto): WinningLotto {
        return try {
            outputView.printBonusNumberRequest()
            val bonusNumber = inputView.readLine().trim().toInt()
            WinningLotto(winningNumbers, bonusNumber)
        } catch(e:IllegalArgumentException) {
            println(e.message)
            getWinningLotto(winningNumbers)
        }
    }



}