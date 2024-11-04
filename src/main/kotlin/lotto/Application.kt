package lotto

fun main() {
    val purchase_money = purchase_money()
    var lotto_number = MutableList<List<Int>>(purchase_money) { emptyList() }
    lotto_number = lottoNumberPrint(purchase_money)

    val winner_number = winNumberInput()
    val bonus_number = bonusNumberInput(winner_number)

    resultoutput(purchase_money, lotto_number, winner_number, bonus_number)
}











