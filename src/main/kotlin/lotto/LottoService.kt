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
        for (i in Content.MIN_COUNT until count) {
            randomLottoList[i] = Randoms.pickUniqueNumbersInRange(Content.MIN_NUMBER_LOTTO, Content.MAX_NUMBER_LOTTO, Content.COUNT_FOR_LOTTO_NUMBER).sorted()
        }
        return randomLottoList
    }

    fun countForWin(randomLottoList: MutableMap<Int, List<Int>>, winNumberForLotto: List<Int>, bonusNumberForLotto: String, count: Int) {
        for (i in Content.MIN_COUNT until count) {
            val checkingLottoForWin = checkLottoForWin(randomLottoList, winNumberForLotto, count)
            val checkingLottoForBonus = checkLottoForBonus(randomLottoList, bonusNumberForLotto)
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

    fun stringToIntList(winForLotto: String): List<Int> {
        return winForLotto.split(",").map {it.trim().toInt()}
    }

    private fun checkLottoForWin(randomLottoList: MutableMap<Int, List<Int>>, winNumberForLotto: List<Int>, count: Int): Int {
        return randomLottoList[count]?.count { it in winNumberForLotto } ?: 0
    }

    private fun checkLottoForBonus(randomLottoList: MutableMap<Int, List<Int>>, bonusNumberForLotto: String): Boolean {
        return randomLottoList[Content.CORRECT_FIVE_NUMBER]?.any { it == bonusNumberForLotto.toInt() } ?: false
    }

    private fun calculateWinForLotto(checkLottoForWin: Int, checkLottoForBonus: Boolean) {
        if (checkLottoForWin == Content.CORRECT_THREE_NUMBER) {
            WinCount.THREE_NUMBER.increase()
        }
        if (checkLottoForWin == Content.CORRECT_FOUR_NUMBER) {
            WinCount.FOUR_NUMBER.increase()
        }
        if (checkLottoForWin == Content.CORRECT_FIVE_NUMBER) {
            if (checkLottoForBonus) {
                WinCount.FIVE_NUMBER_AND_BONUS.increase()
            }
            else WinCount.FIVE_NUMBER.increase()
        }
        if (checkLottoForWin == Content.CORRECT_SIX_NUMBER) {
            WinCount.SIX_NUMBER.increase()
        }
    }

}