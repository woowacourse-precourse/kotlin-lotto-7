package lotto

fun Purchase_money(): Int {
    val PURCHASE_MONEY_MESSAGE = "구입금액을 입력해주세요."
    var purchase_num: Int
    while (true) {
        println(PURCHASE_MONEY_MESSAGE)
        try {
            purchase_num = readLine()?.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 입력 값은 숫자로 입력해야 합니다.")
            require(purchase_num >= 0) { "[ERROR] 입력 값은 양수여야 합니다." }
            require(purchase_num % 1000 == 0) { "[ERROR] 입력 값은 1000단위이어야 합니다." }
            return purchase_num / 1000
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}