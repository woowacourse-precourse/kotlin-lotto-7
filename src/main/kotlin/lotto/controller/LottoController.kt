package lotto.controller

import lotto.converter.LottoArgumentConverter
import lotto.domain.lotto.BonusNumber
import lotto.domain.lotto.Lotto
import lotto.domain.lotto.LottoFactory
import lotto.domain.numbergenerator.NumberGenerator
import lotto.domain.purchase.Purchase
import lotto.domain.winning.WinningManager
import lotto.view.*

class LottoController(
    private val numberGenerator: NumberGenerator
) {
    fun draw() {
        val purchase = getPurchaseAmount()
        val lottoTicket = LottoFactory.buyLottoTicket(purchase, numberGenerator)
        purchaseLottoView(purchase.getNumberOfLotto(), lottoTicket)

        val winningNumber = getWinningNumber()
        val bonusNumber = getBonusNumber(winningNumber)

        val winningManager = WinningManager(purchase, lottoTicket, winningNumber, bonusNumber)
        printWinningStatistics(winningManager.getWinningStatistics())
        printProfitRate(winningManager.getProfitRate())
    }

    private fun getPurchaseAmount(): Purchase {
        return runCatching {
            Purchase.valueOf(purchaseAmountView())
        }.onFailure { exception ->
            println(exception.message)
        }.getOrElse {
            consumeResource()
            getPurchaseAmount()
        }
    }

    private fun getWinningNumber(): Lotto {
        return runCatching {
            val winningNumberArgument = LottoArgumentConverter.toLottoArgument(winningNumberView())
            LottoFactory.getWinningLotto(winningNumberArgument)
        }.onFailure { exception ->
            println(exception.message)
        }.getOrElse {
            consumeResource()
            getWinningNumber()
        }
    }

    private fun getBonusNumber(winningNumber: Lotto): BonusNumber {
        return runCatching {
            val bonusNumberArgument = LottoArgumentConverter.toBonusNumberArgument(bonusNumberView())
            LottoFactory.getBonusNumber(bonusNumberArgument, winningNumber)
        }.onFailure { exception ->
            println(exception.message)
        }.getOrElse {
            consumeResource()
            getBonusNumber(winningNumber)
        }
    }

}