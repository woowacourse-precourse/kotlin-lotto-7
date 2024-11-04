package lotto.controller

import lotto.Lotto
import lotto.view.LottoView
import lotto.model.LottoPurchaseAmount
import lotto.model.LottoStore
import lotto.util.*

class LottoController(private val lottoView: LottoView) {
    fun run() {
        val lottoPurchaseAmount = payMoney()
        val lottos = purchaseLottos(lottoPurchaseAmount.money)
        val lottoResult = processLottoWinningNumbers()
        val bonus = processLottoBonusNumber(lottoResult)
    }

    private fun payMoney(): LottoPurchaseAmount {
        return try {
            lottoView.printLottoPurchaseRequest()
            LottoPurchaseAmount.from(lottoView.inputLottoPurchaseAmount())
        } catch (e: IllegalArgumentException) {
            lottoView.printError(e.message)
            return payMoney()
        }
    }

    private fun purchaseLottos(money: Int): List<Lotto> {
        val lottoCount = money / LottoStore.LOTTO_TICKET_PRICE
        val lottos = mutableListOf<Lotto>()
        lottoView.printLottoCount(lottoCount)
        repeat(lottoCount) { lottos.add(Lotto.fromList(LottoStore().buy())) }
        lottoView.printLottos(lottos)
        return lottos
    }

    private fun processLottoWinningNumbers(): Lotto {
        return try {
            lottoView.printWinningNumberRequest()
            Lotto.fromInput(lottoView.inputWinningNumber())
        } catch (e: IllegalArgumentException) {
            lottoView.printError(e.message)
            return processLottoWinningNumbers()
        }
    }

    private fun processLottoBonusNumber(lotto: Lotto): Int {
        return try {
            lottoView.printBonusNumberRequest()
            val bonus = lottoView.inputBonusNumber()
                .validateInt()
                .validateRange(LottoStore.LOTTO_MIN_NUMBER, LottoStore.LOTTO_MAX_NUMBER)

            if (lotto.isContain(bonus)) throw IllegalArgumentException("[ERROR] 중복되지 않는 숫자로 입력해 주세요.")
            bonus
        } catch (e: IllegalArgumentException) {
            lottoView.printError(e.message)
            return processLottoBonusNumber(lotto)
        }
    }

}

