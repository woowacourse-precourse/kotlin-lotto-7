package controller

import lotto.LottoShop
import lotto.Processer
import validator.BillValidator
import validator.InputValidator
import validator.LottoValidator
import view.OutputView

class Controller() {
    private val inputValidator = InputValidator()
    private val billValidator = BillValidator()
    private val lottoValidator = LottoValidator()
    private val lottoShop = LottoShop()
    private val outputView = OutputView()
    private val processer = Processer()

    fun buyLotto(input: String): Boolean {
        if(inputValidator.inputCheck(input)) {
            return true
        }
        val bills = input.toInt()
        if(billValidator.billCheck(bills)) {
            return true
        }
        val lottoCount = bills / 1000
        outputView.printLottoNumbers(lottoCount, lottoShop.sellLotto(lottoCount))
        return false
    }

    fun checkWinNumbers(input: String): Boolean {
        val winInput = processer.splitLottoNumber(input)
        for (i in 0..winInput.lastIndex) {
            if (inputValidator.inputCheck(winInput[i])) {
                return true
            }
        }
        val winNumbers = processer.convertLottoNumber(winInput)
        if (lottoValidator.lottoCheck(winNumbers)) {
            return true
        }
        lottoShop.setWinNumber(winNumbers)
        return false
    }

    fun checkBonusNumbers(input: String): Boolean {
        if (inputValidator.inputCheck(input)) {
            return true
        }
        val bonusNumber = input.toInt()
        if (lottoValidator.lottoBonusCheck(bonusNumber, lottoShop.getWinNumber())) {
            return true
        }
        checkWins(bonusNumber)
        return false
    }

    private fun checkWins(bonusNumber: Int) {
        val winInfo = lottoShop.winLotto(bonusNumber)
        outputView.printLottoWins(winInfo)
    }

}