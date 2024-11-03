package lotto

import camp.nextstep.edu.missionutils.Randoms
import util.SettingValue


class RandomLottoGenerator {

    fun lottoPurchase(amount: Int): MutableList<List<Int>> {
        val lottoCount = (amount / SettingValue.LOTTO_PRICE)
        return repeatGenerator(lottoCount)
    }

    private fun repeatGenerator(lottoCount: Int): MutableList<List<Int>> {
        val randomLottoList = mutableListOf<List<Int>>()
        repeat(lottoCount) {
            val randomLottoNumber = randomLottoGenerate()
            randomLottoList.add(randomLottoNumber)
        }
        return randomLottoList
    }

    private fun randomLottoGenerate(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(
            SettingValue.LOTTO_NUMBER_MINIMUM,
            SettingValue.LOTTO_NUMBER_MAXIMUM,
            SettingValue.LOTTO_NUMBER_COUNT
        )
    }
}