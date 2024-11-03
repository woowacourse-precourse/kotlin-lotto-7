package lotto.controller

import lotto.adapter.BonusNumberAdapter.makeBonusNumberModel
import lotto.adapter.LottoAdapter.makeLottoModel
import lotto.adapter.PurchaseInfoAdapter
import lotto.domain.model.Lotto
import lotto.domain.model.Prize
import lotto.domain.model.PurchaseInfo
import lotto.domain.usecase.LottoPrizeCalculator
import lotto.domain.usecase.MatchingLottoNumber
import lotto.domain.usecase.QuickPickLottoTickets
import lotto.util.validator.bonusnumber.BonusNumberValidator
import lotto.util.validator.purchaseamount.PurchaseAmountValidator
import lotto.util.validator.winningnumbers.WinningNumbersValidator
import lotto.view.InputView.getBonusNumber
import lotto.view.InputView.getPurchaseAmount
import lotto.view.InputView.getWinningNumbers
import lotto.view.OutputView.showCalculateInfo
import lotto.view.OutputView.showProfit
import lotto.view.OutputView.showPurchaseInfo

class LottoController {
    fun run() {
        try {
            val inputPurchaseAmount: String = getPurchaseAmount()
            PurchaseAmountValidator(inputPurchaseAmount).validatePurchaseAmount()
            val purchaseInfo: PurchaseInfo = PurchaseInfoAdapter.makePurchaseInfoModel(inputPurchaseAmount)
            val quickPickLottoTickets: List<Lotto> = QuickPickLottoTickets(purchaseInfo).quickPickLottoTickets()
            showPurchaseInfo(purchaseInfo, quickPickLottoTickets)

            val inputWinningNumbers: String = getWinningNumbers()
            WinningNumbersValidator(inputWinningNumbers).validateLuckyNumbers()
            val winningLotto: Lotto = makeLottoModel(inputWinningNumbers)

            val inputBonusNumber = getBonusNumber()
            BonusNumberValidator(winningLotto, inputBonusNumber).validateBonusNumber()
            val bonusNumber = makeBonusNumberModel(inputBonusNumber)

            val matchResult: List<Prize> = MatchingLottoNumber(winningLotto, bonusNumber, quickPickLottoTickets).getMatchResult()
            val profitRate = LottoPrizeCalculator(matchResult, purchaseInfo).calculateProfitRate()
            showCalculateInfo(matchResult)
            showProfit(profitRate)

        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}