package vm

import domain.model.PurchaseState
import sam.LottoFactory

class LottoViewModel(
    private val lottoFactory: LottoFactory
) {
    var state = PurchaseState()
        private set

    fun onCompleteInputPayment(pay: Int){
        state = state.copy(purchaseLottoCount = pay)
        pickLotto()
    }

    fun onCompleteInputWinningNumber(winningNumber: List<Int>){
        state = state.copy(winningNumber = winningNumber)
    }

    fun onCompleteInputBonusNumber(bonusNumber: Int){
        state = state.copy(bonusNumber = bonusNumber)
    }

    private fun pickLotto(){
        val purchaseLottoAmount = state.purchaseLottoCount
        val pickedLotto = mutableListOf<List<Int>>()
        repeat(purchaseLottoAmount) {
            pickedLotto.add(lottoFactory())
        }
        state = state.copy(pickedLotto = pickedLotto)
    }
}