package lotto.presentation.vm.model

data class PurchaseState(
    val purchaseInfo: PurchaseInfo = PurchaseInfo(),
    val winningNumber: List<Int> = emptyList(),
    val bonusNumber: Int = 0,
    val lotto: PurchasedLottoInfo = PurchasedLottoInfo(),
    val winningResult: WinningResult = WinningResult(),
    val rateOfReturn: String = "",
)