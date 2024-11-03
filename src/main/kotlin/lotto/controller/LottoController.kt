package lotto.controller

import lotto.converter.LottoArgumentConverter
import lotto.domain.lotto.BonusNumber
import lotto.domain.lotto.Lotto
import lotto.domain.lotto.LottoFactory
import lotto.domain.numbergenerator.NumberGenerator
import lotto.domain.purchase.Purchase
import lotto.view.bonusNumberView
import lotto.view.purchaseAmountView
import lotto.view.purchaseLottoView
import lotto.view.winningNumberView

class LottoController(
    private val numberGenerator: NumberGenerator
) {
    fun draw() {
        val purchase = getPurchaseAmount()
        val lottoTicket = LottoFactory.buyLottoTicket(purchase, numberGenerator)
        purchaseLottoView(purchase.getNumberOfLotto(), lottoTicket)
        val winningNumber = getWinningNumber()
        val bonusNumber = getBonusNumber(winningNumber)
    }

    private fun getPurchaseAmount(): Purchase {
        return runCatching {
            Purchase.valueOf(purchaseAmountView())
        }.onFailure { exception ->
            println(exception.message)
        }.getOrElse {
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
            getBonusNumber(winningNumber)
        }
    }

}