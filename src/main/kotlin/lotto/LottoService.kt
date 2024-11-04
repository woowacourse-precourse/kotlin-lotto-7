package lotto

import camp.nextstep.edu.missionutils.Randoms
import model.WinCount
import values.Content

class LottoService {
    fun countForLotto(moneyForLotto: Int): Int {
        return moneyForLotto / Content.LOTTO_PRICE
    }

    fun randomLottoNumber(count: Int): MutableMap<Int, List<Int>> {
        val randomLottoList = mutableMapOf<Int, List<Int>>()
        for (i in 0 until count) {
            randomLottoList[i] = Randoms.pickUniqueNumbersInRange(Content.MIN_NUMBER_LOTTO, Content.MAX_NUMBER_LOTTO, Content.COUNT_FOR_LOTTO_NUMBER)
        }
        return randomLottoList
    }

    fun countForWin(fiveNumberLottoList: List<Int>, randomLottoList: MutableMap<Int, List<Int>>, winNumberForLotto: List<Int>, bonusNumberForLotto: String, count: Int) {
        for (i in 0 until count) {
            val checkingLottoForWin = checkLottoForWin(randomLottoList, winNumberForLotto, count)
            val checkingLottoForBonus = checkLottoForBonus(fiveNumberLottoList, bonusNumberForLotto)
            calculateWinForLotto(checkingLottoForWin, checkingLottoForBonus)
        }
    }

    fun calculateEarnPercentage(moneyForLotto: Int): Double {
        val threeNumber = WinCount.THREE_NUMBER.getWinCount()
        val fourNumber = WinCount.FOUR_NUMBER.getWinCount()
        val fiveNumber = WinCount.FIVE_NUMBER.getWinCount()
        val fiveNumberAndBonus = WinCount.FIVE_NUMBER_AND_BONUS.getWinCount()
        val sixNumber = WinCount.SIX_NUMBER.getWinCount()

        val totalMoney = (threeNumber * Content.THREE_NUMBER_PRIZE) +
                (fourNumber * Content.FOUR_NUMBER_PRIZE) +
                (fiveNumber * Content.FIVE_NUMBER_PRIZE) +
                (fiveNumberAndBonus * Content.FIVE_NUMBER_AND_BONUS_PRIZE) +
                (sixNumber * Content.SIX_NUMBER_PRIZE)

        return (totalMoney / moneyForLotto).toDouble() * Content.POINT_TO_PERCENT
    }
    private fun checkLottoForWin(randomLottoList: MutableMap<Int, List<Int>>, winNumberForLotto: List<Int>, count: Int): Int {
        return randomLottoList[count]?.filter { it in winNumberForLotto }?.count() ?: 0
    }

    private fun checkLottoForBonus(randomLottoList: List<Int>, bonusNumberForLotto: String): Boolean {
        return randomLottoList.any { it == bonusNumberForLotto.toInt() }
    }

    private fun calculateWinForLotto(checkLottoForWin: Int, checkLottoForBonus: Boolean) {
        if (checkLottoForWin == Content.CORRECT_THREE_NUMBER) {
            WinCount.THREE_NUMBER.increse()
        }
        if (checkLottoForWin == Content.CORRECT_FOUR_NUMBER) {
            WinCount.FOUR_NUMBER.increse()
        }
        if (checkLottoForWin == Content.CORRECT_FIVE_NUMBER) {
            if (checkLottoForBonus) {
                return WinCount.FIVE_NUMBER_AND_BONUS.increse()
            }
            WinCount.FIVE_NUMBER.increse()
        }
        if (checkLottoForWin == Content.CORRECT_SIX_NUMBER) {
            WinCount.SIX_NUMBER.increse()
        }
    }

}