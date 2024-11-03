package control

import camp.nextstep.edu.missionutils.Randoms
import util.SettingValue
import view.Output


class RandomLottoGenerator() {

    fun purchase(amount: Int): MutableList<List<Int>> {
        val lottoCount = (amount.toString().toInt() / SettingValue.LOTTO_PRICE)
        Output().lottoPurchase(lottoCount)
        return repeat(lottoCount)
    }

    private fun repeat(lottoCount: Int): MutableList<List<Int>> {
        val randomLottoList = mutableListOf<List<Int>>()
        repeat(lottoCount) {
            val randomLottoNumber = randomLottoGenerate()
            randomLottoList.add(randomLottoNumber)
        }
        Output().randomLottoList(randomLottoList)
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