package domain.model

data class PurchaseState (
    val purchaseLottoCount: Int = 0,
    val winningNumber: List<Int> = emptyList(),
    val bonusNumber: Int = 0,
    val pickedLotto: List<List<Int>> = emptyList()
)