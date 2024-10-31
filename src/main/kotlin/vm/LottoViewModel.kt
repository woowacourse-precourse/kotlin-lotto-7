package vm

import domain.model.PurchaseState

class LottoViewModel(
) {
    private var state = PurchaseState()

    fun onCompleteInputPayment(pay: Int){
        state = state.copy(purchaseLottoCount = pay)
    }

    fun onCompleteInputWinningNumber(winningNumber: List<Int>){
        state = state.copy(winningNumber = winningNumber)
    }

    fun onCompleteInputBonusNumber(bonusNumber: Int){
        state = state.copy(bonusNumber = bonusNumber)
    }

}