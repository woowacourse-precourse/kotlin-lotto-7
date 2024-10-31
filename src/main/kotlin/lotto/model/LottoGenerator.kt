package lotto.model
import camp.nextstep.edu.missionutils.*

class LottoGenerator {

    fun generateLotto(numberOfLotto : Int) : List<List<Int>>{
        val randomLotto : MutableList<List<Int>> = mutableListOf()

        for(i in 0 until numberOfLotto){
            randomLotto.add(getRandomNumbers())
        }
        return randomLotto
    }
    fun getNumberOfLotto(money : String) : Int {
        val deleteCommaMoney = money.replace(",","")
        return deleteCommaMoney.toInt() / 1000
    }
    private fun getRandomNumbers():List<Int>{
        return Randoms.pickUniqueNumbersInRange(1,45,6)
    }


}
