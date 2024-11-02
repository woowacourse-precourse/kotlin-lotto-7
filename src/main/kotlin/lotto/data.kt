package lotto

data class PurchasedLotto(
    var amountOfLotto: Int = 0,
    var purchasedLotto: MutableList<List<Int>> = mutableListOf()
)
