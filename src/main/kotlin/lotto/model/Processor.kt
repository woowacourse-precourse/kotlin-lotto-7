package lotto.model

object Processor {
    fun moneyProcess(money: Int?): Int {
        if (money == null) throw IllegalArgumentException("[ERROR] 잘못된 가격을 입력했습니다.")
        if (money % 1000 == 0) return money / 1000
        throw IllegalArgumentException("[ERROR] 1000원 단위로 입력하지 않았습니다.")
    }

    fun winningNumSplit(num: String): List<Int> {
        if (containsInvalidCharacters(num)) throw IllegalArgumentException("[ERROR] 숫자와 쉼표(,) 외에 다른 문자를 입력했습니다.")
        val numList = num.split(",").map { it.toInt() }

        return numList
    }

    fun containsInvalidCharacters(str: String): Boolean {
        val regex = Regex("^[0-9${Regex.escape(",")}]*$")
        return !regex.matches(str)
    }

    fun bonusNumValidate(bonusNum: Int?): Int {
        if (bonusNum == null) throw IllegalArgumentException("[ERROR] 보너스 번호를 잘못 입력했습니다.")
        return bonusNum
    }
}