package controller

import lotto.LottoService
import model.Lotto
import values.Content
import view.inputMessage
import view.outputMessage

class LottoController {
    private val inputMessage = inputMessage()
    private val outputMessage = outputMessage()
    private val lottoService = LottoService()

    fun lottoGenerate() {
        val moneyForLotto = getMoneyForLotto()
        val countForLotto = getCountForLotto(moneyForLotto)
        val randomLottoLists = generateRandomLottoLists(countForLotto)
        outputMessage.printLottoList(countForLotto, randomLottoLists)
        val winForLotto = getWinForLotto()
        val bonusForLotto = getBonusForLotto()
        lottoService.countForWin(randomLottoLists, winForLotto, bonusForLotto.toString(), countForLotto)
        outputMessage.statisticsForWinMessage()
        val earn = lottoService.calculateEarnPercentage(moneyForLotto)
        outputMessage.earnPercentMessage(earn)
    }

    private fun getMoneyForLotto(): Int {
        return try {
            val moneyForLotto = inputMessage.moneyForLotto()
            moneyForLotto.toInt()
        } catch (e: NumberFormatException) {
            println(Content.ERROR_OF_NUMBER)
            getMoneyForLotto()
        } catch (error:IllegalArgumentException) {
            getMoneyForLotto()
        }
    }

    private fun getWinForLotto(): List<Int> {
        return try {
            val winForLotto = inputMessage.winNumberForLotto()
            val winNumberForLotto = lottoService.stringToIntList(winForLotto)
            Lotto(winNumberForLotto).getNumbers()
        } catch (error:IllegalArgumentException) {
            getWinForLotto()
        }
    }

    private fun getBonusForLotto(): Int {
        return try {
            val bonusForLotto = inputMessage.bonusNumberForLotto()
            bonusForLotto.toInt()
        } catch (error:IllegalArgumentException) {
            getBonusForLotto()
        }
    }

    private fun getCountForLotto(moneyForLotto: Int): Int {
        return lottoService.countForLotto(moneyForLotto)
    }

    private fun generateRandomLottoLists(count: Int): MutableMap<Int, List<Int>> {
        return lottoService.randomLottoNumber(count)
    }
}