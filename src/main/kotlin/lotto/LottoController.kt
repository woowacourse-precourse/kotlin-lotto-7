package lotto

import lotto.View.InputView
import lotto.View.OutputView

class LottoController {

    private var inputView = InputView()
    private var outputView = OutputView()


    fun run() {
        val lottoAmount = inputView.inputPurchaseLotto()
        val outputLottoNum = outputView.outputLottoNum(lottoAmount)
        val lottoNum = inputView.inputLottoNum().map { it.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 당첨 번호는 정수로 입력해야 합니다.")}
        val bonusLottoNum = inputView.inputBonusLottoNum(lottoNum)

        outputView.outputResult(lottoAmount*1000, outputLottoNum, lottoNum, bonusLottoNum)
    }
}