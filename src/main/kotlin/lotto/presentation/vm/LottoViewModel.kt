package lotto.presentation.vm

import lotto.domain.calculator.Calculate
import lotto.domain.enums.Output.Companion.totalRateOfReturnFormat
import lotto.domain.enums.Rank
import lotto.domain.lotto.Lotto
import lotto.domain.repository.LottoRepository
import lotto.domain.validator.InputValidate
import lotto.presentation.vm.model.PurchaseState
import java.util.TreeSet

class LottoViewModel(
    private val validator: InputValidate,
    private val calculator: Calculate,
    private val lottoRepository: LottoRepository
) {

    private var _state = PurchaseState()
    val state: PurchaseState get() = _state

    fun checkPaymentValidation(pay: String) {
        validator.payValidation(pay)
        calculateLottoCount(pay.toInt())
    }

    fun checkWinningNumberValidation(winningNumber: String) {
        val validWinningNumber = validator.winningNumberValidation(winningNumber)
        _state = _state.copy(winningNumber = validWinningNumber)
    }

    fun checkBonusNumberValidation(bonusNumber: String) {
        val validBonusNumber = validator.bonusNumberValidation(bonusNumber)
        _state = _state.copy(bonusNumber = validBonusNumber)
        getLottoResult()
    }

    fun pickLotto() {
        val purchaseLottoAmount = _state.purchaseInfo.purchaseLottoCount
        val pickedLotto = mutableListOf<TreeSet<Int>>()
        repeat(purchaseLottoAmount) {
            val lottoNumber = lottoRepository.generateLottoNumbers()
            pickedLotto.add(lottoNumber)
        }
        setPickedLotto(pickedLotto)
    }

    private fun getLottoResult() {
        val lotto = Lotto(_state.winningNumber)
        val updatedWinningResult = _state.winningResult.winning.toMutableMap()

        _state.lotto.pickedLotto.map {
            val matches = lotto.getMatches(it, _state.bonusNumber)
            modifyWinningByMatches(matches, updatedWinningResult)
        }

        setLottoResult(updatedWinningResult)
    }

    fun getRateOfReturn() {
        val winningMoney = calculator.calculateWinningMoney(_state.winningResult.winning)

        if (winningMoney != 0L) {
            val purchaseAmount = _state.purchaseInfo.purchaseLottoCount
            val rateOfReturn = calculator.calculateRateOfReturn(winningMoney, purchaseAmount)
            _state = _state.copy(rateOfReturn = totalRateOfReturnFormat(rateOfReturn))
        }
    }

    private fun modifyWinningByMatches(matches: Rank, currentWinning: MutableMap<Rank, Int>) {
        if (matches != Rank.NONE) {
            currentWinning[matches] = currentWinning.getOrDefault(matches, 0) + 1
        }
    }

    private fun calculateLottoCount(pay: Int) {
        val purchaseLottoCount = calculator.calculatePurchaseLottoCount(pay)
        _state = _state.copy(
            purchaseInfo = _state.purchaseInfo.copy(
                purchaseLottoCount = purchaseLottoCount,
            )
        )
    }

    private fun setPickedLotto(lotto: List<TreeSet<Int>>) {
        _state = _state.copy(
            lotto = _state.lotto.copy(
                pickedLotto = lotto
            )
        )
    }

    private fun setLottoResult(result: Map<Rank, Int>) {
        _state = _state.copy(
            winningResult = _state.winningResult.copy(
                winning = result
            )
        )
    }
}