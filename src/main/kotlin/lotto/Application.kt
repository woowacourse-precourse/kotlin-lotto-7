package lotto

fun main() {
    val purchase_money = Purchase_money()
    var lotto_number = MutableList<List<Int>>(purchase_money){ emptyList() }

    lotto_number=LottoNumberPrint(purchase_money)

    return
}






