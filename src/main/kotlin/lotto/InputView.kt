package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun inputPurchaseAmount(): String {
        val guideMessage = GuideMessage.PurchaseAmount
        guideMessage.printGuideMessage()
        return Console.readLine()
    }

    fun getPurchaseAmount(): Int {
        return inputPurchaseAmount().toInt()
    }

    fun inputLottoNumbers(): String {
        val guideMessage = GuideMessage.LottoNumbers
        guideMessage.printGuideMessage()
        return Console.readLine()
    }

    fun getLottoNumbers(): List<Int> {
        val lottoNumbers = inputLottoNumbers().split(",")
        return lottoNumbers.map { it.trim().toInt() }.sorted()
    }

    fun inputBonusNumber(): String {
        val guideMessage = GuideMessage.BonusNumber
        guideMessage.printGuideMessage()
        return Console.readLine()
    }

    fun getBonusNumber(): Int {
        return inputBonusNumber().toInt()
    }

    enum class GuideMessage(private val message: String) {
        PurchaseAmount("구입금액을 입력해 주세요."),
        LottoNumbers("당첨 번호를 입력해 주세요."),
        BonusNumber("보너스 번호를 입력해 주세요.");

        fun printGuideMessage() {
            println(message)
        }
    }
}