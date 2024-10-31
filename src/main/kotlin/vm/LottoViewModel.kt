package vm

import domain.model.PurchaseState

class LottoViewModel(
) {
    private var state = PurchaseState()

    fun onCompleteInputPayment(pay: Int){
        state = state.copy(purchaseLottoCount = pay)
    }
}