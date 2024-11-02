package controller

import lotto.LottoShop
import validator.BillValidator
import validator.InputValidator
import validator.LottoValidator
import view.OutputView

class BillsController(private val input: String) {
    private val inputValidator = InputValidator()
    private val billValidator = BillValidator()
    private val lottoValidator = LottoValidator()
    private val lottoShop = LottoShop()
    private val outputView = OutputView()

    fun showLotto(): Boolean {
        if(inputValidator.inputCheck(input)) {
            return true
        }
        val bills = input.toInt()
        if(billValidator.billCheck(bills)) {
            return true
        }
        val lottoCount = bills / 1000
        outputView.printLottoNumbers(lottoCount, buyLotto(lottoCount))
        return false
    }

    private fun buyLotto(count: Int): List<List<Int>> {
        val lottos = lottoShop.sellLotto(count)
        val lottoNumbers = ArrayList<List<Int>>()
        for (i in 0..lottos.lastIndex) {
            lottoNumbers.add(lottos[i].getLottoNumber())
        }
        return lottoNumbers.toList()
    }
}