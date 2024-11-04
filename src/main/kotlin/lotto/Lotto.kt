package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        numbers.forEach {
            require(it in 1..45){"[ERROR] 유효하지 않은 범위의 숫자가 포함되어 있습니다."}
        }
        require(numbers.toSet().size == 6) { "[ERROR] 중복된 숫자가 있습니다." }
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
