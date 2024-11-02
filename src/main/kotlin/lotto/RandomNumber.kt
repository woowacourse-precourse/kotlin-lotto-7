package lotto

import camp.nextstep.edu.missionutils.Randoms

class RandomNumber {

    private  fun randomLotto(): MutableList<Int> {
        return Randoms.pickUniqueNumbersInRange(1,45,6)
    }

    fun randomLottos(count: Int): MutableList<MutableList<Int>> {
        val lottoNumbers = mutableListOf<MutableList<Int>>()
        for (i in 1..count){
            lottoNumbers.add(randomLotto())
        }
        return lottoNumbers
    }

}