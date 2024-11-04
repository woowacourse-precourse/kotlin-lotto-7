package lotto

import camp.nextstep.edu.missionutils.Randoms

class RandomNumber {

    private  fun randomLotto(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1,45,6).sorted()
    }

    fun randomLottos(count: Int): MutableList<List<Int>> {
        val lottoNumbers = mutableListOf<List<Int>>()
        for (i in 1..count){
            lottoNumbers.add(randomLotto())
        }
        return lottoNumbers
    }

}