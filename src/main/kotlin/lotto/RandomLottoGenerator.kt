package lotto

import camp.nextstep.edu.missionutils.Randoms


class RandomLottoGenerator(amount: Int) {
    init {
        println()
        println(lottoCountCalculate(amount).toString() + Message.NUMBER_OF_LOTTO)
    }

    fun lottoPurchase(amount: Int): MutableList<List<Int>> {
        val lottoCount = lottoCountCalculate(amount)
        return repeatGenerator(lottoCount)

    }

    private fun repeatGenerator(lottoGame: Int): MutableList<List<Int>> {
        val randomLottoList = mutableListOf<List<Int>>()
        repeat(lottoGame) {
            val randomLottoNumber = randomLottoGenerate()
            randomLottoList.add(randomLottoNumber)
        }
        return randomLottoList
    }

    private fun lottoCountCalculate(amount: Int): Int {
        return (amount / SettingValue.LOTTO_PRICE)
    }

    private fun randomLottoGenerate(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(
            SettingValue.LOTTO_NUMBER_MINIMUM,
            SettingValue.LOTTO_NUMBER_MAXIMUM,
            SettingValue.LOTTO_NUMBER_COUNT
        )
    }
}