package lotto.controller

import lotto.adapter.BonusNumberAdapter.makeBonusNumberModel
import lotto.adapter.LottoAdapter.makeLottoModel
import lotto.adapter.PurchaseInfoAdapter
import lotto.domain.model.BonusNumber
import lotto.domain.model.Lotto
import lotto.domain.model.PurchaseInfo
import lotto.domain.usecase.LottoPrizeCalculator
import lotto.domain.usecase.MatchingLottoNumber
import lotto.domain.usecase.QuickPickLottoTickets
import lotto.util.validator.bonusnumber.BonusNumberValidator
import lotto.util.validator.purchaseamount.PurchaseAmountValidator
import lotto.util.validator.winningnumbers.WinningNumbersValidator
import lotto.view.InputView.closeInput
import lotto.view.InputView.getBonusNumber
import lotto.view.InputView.getPurchaseAmount
import lotto.view.InputView.getWinningNumbers
import lotto.view.OutputView.showCalculateInfo
import lotto.view.OutputView.showProfit
import lotto.view.OutputView.showPurchaseInfo

class LottoController {
    fun run() {
        try {
            val purchaseInfo = handlePurchaseInfo()
            val quickPickLottoTickets = handleQuickPickLottoTickets(purchaseInfo)
            showPurchaseInfo(purchaseInfo, quickPickLottoTickets)

            val winningLotto = handleWinningNumbers()
            val bonusNumber = handleBonusNumber(winningLotto)

            closeInput()

            val matchResult = MatchingLottoNumber(winningLotto, bonusNumber, quickPickLottoTickets).getMatchResult()
            val profitRate = LottoPrizeCalculator(matchResult, purchaseInfo).calculateProfitRate()

            showCalculateInfo(matchResult)
            showProfit(profitRate)
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    private fun handlePurchaseInfo(): PurchaseInfo {
        val inputPurchaseAmount: String = getPurchaseAmount()
        PurchaseAmountValidator(inputPurchaseAmount).validatePurchaseAmount()
        return PurchaseInfoAdapter.makePurchaseInfoModel(inputPurchaseAmount)
    }

    private fun handleQuickPickLottoTickets(purchaseInfo: PurchaseInfo): List<Lotto> {
        return QuickPickLottoTickets(purchaseInfo).quickPickLottoTickets()
    }

    private fun handleWinningNumbers(): Lotto {
        val inputWinningNumbers: String = getWinningNumbers()
        WinningNumbersValidator(inputWinningNumbers).validateLuckyNumbers()
        return makeLottoModel(inputWinningNumbers)
    }

    private fun handleBonusNumber(winningLotto: Lotto): BonusNumber {
        val inputBonusNumber = getBonusNumber()
        BonusNumberValidator(winningLotto, inputBonusNumber).validateBonusNumber()
        return makeBonusNumberModel(inputBonusNumber)
    }

}