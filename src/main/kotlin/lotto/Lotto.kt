package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }

    fun getMatchCount(): MutableList<Int> {
        val winningNumber = LottoSystem.getWinningNumber()
        val bonusNumber = LottoSystem.getBonusNumber()
        val matchCountAndBonus = mutableListOf<Int>()
        var count = 0

        numbers.forEach {
            if(winningNumber.contains(it))count++
        }
        matchCountAndBonus.add(count)

        if(numbers.contains(bonusNumber)){
            matchCountAndBonus.add(1)
        }else{
            matchCountAndBonus.add(0)
        }
        return matchCountAndBonus
    }

}
