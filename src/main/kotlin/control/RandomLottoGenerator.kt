package control

import camp.nextstep.edu.missionutils.Randoms
import util.SettingValue
import view.Output


class RandomLottoGenerator {

    fun generate(amount: Int): MutableList<List<Int>> {
        val lottoTickets = (amount.toString().toInt() / SettingValue.LOTTO_PRICE)
        Output().lottoPurchase(lottoTickets)
        return repeat(lottoTickets)
    }

    private fun repeat(lottoTickets: Int): MutableList<List<Int>> {
        val randomLottoList = mutableListOf<List<Int>>()
        repeat(lottoTickets) {
            val randomLottoNumber = randomRange()
            randomLottoList.add(randomLottoNumber)
        }
        Output().randomLottoList(randomLottoList)
        return randomLottoList
    }

    private fun randomRange(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(
            SettingValue.LOTTO_NUMBER_MINIMUM,
            SettingValue.LOTTO_NUMBER_MAXIMUM,
            SettingValue.LOTTO_NUMBER_COUNT
        )
    }
}