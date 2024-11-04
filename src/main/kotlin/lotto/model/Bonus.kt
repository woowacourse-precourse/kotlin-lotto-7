package lotto.model

class Bonus(private val bonus: Int) {
    init {
        require(bonus > 0 && bonus < 46)
        require(bonus.toInt() != null)
        //TODO: 당첨 번화와 중복검사
    }

    fun returnBonus(): Int {
        return bonus
    }
}