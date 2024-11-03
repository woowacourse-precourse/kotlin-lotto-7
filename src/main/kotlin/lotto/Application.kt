package lotto

fun main() {
    val purchaseView = PurchaseView()
    val purchasedLottoCount = purchaseView.getPurchaseLottoCount()
    val user = User(purchasedLottoCount)

}
