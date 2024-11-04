package lotto.controller

import lotto.model.*
import lotto.view.LottoView
import lotto.util.*

class LottoController(private val lottoView: LottoView) {
    fun run() {
        val lottoPurchaseAmount = payMoney()
        val lottos = purchaseLottos(lottoPurchaseAmount.money)
        val lottoResult = processLottoWinningNumbers()
        val bonus = processLottoBonusNumber(lottoResult)
        val results = checkResults(lottos, lottoResult, bonus)
        calculateRanks(results)
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
        repeat(lottoCount) { lottos.add(Lotto.fromList(LottoStore().sell())) }
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
    private fun checkResults(myLotto: List<Lotto>, answer: Lotto, bonus: Int): List<LottoResult> {
        val ranks = mutableListOf<LottoResult>()
        for (lotto in myLotto) {
            val count = lotto.toList().intersect(answer.toList().toSet()).size
            val hasBonus = lotto.isContain(bonus)
            ranks.add(LottoResult.of(count, hasBonus))
        }
        return ranks
    }

    private fun calculateRanks(lottoResults: List<LottoResult>) {
        lottoView.printLottoRankHeader()
        val ranks = LottoRanking.of(lottoResults)

        for ((rank, count) in ranks.countByRanking) {
            if (rank == LottoResult.MISS) continue
            lottoView.printLottoRank(rank, count)
        }
        lottoView.printRevenue(ranks.totalRevenue)
    }
}

