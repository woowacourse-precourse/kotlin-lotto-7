package lotto

fun main() {
    val purchase_money = purchase_money()
    var lotto_number = MutableList<List<Int>>(purchase_money){ emptyList() }
    lotto_number=lottoNumberPrint(purchase_money)

    val winner_number = winNumberInput()

    return
}








