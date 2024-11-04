package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun getPurchaseAmount(): Int {
        printGuideMessage(GuideMessage.PurchaseAmount)
        return Console.readLine().toInt()
    }

    fun getLottoNumbers(): List<Int> {
        printGuideMessage(GuideMessage.LottoNumbers)
        val lottoNumbers = Console.readLine().split(",")
        return lottoNumbers.map { it.trim().toInt() }.sorted()
    }

    fun getBonusNumber(): Int {
        printGuideMessage(GuideMessage.BonusNumber)
        return Console.readLine().toInt()
    }

    private fun printGuideMessage(guideMessage: GuideMessage) {
        println(guideMessage.message)
    }

    enum class GuideMessage(val message: String) {
        PurchaseAmount("구입금액을 입력해 주세요."),
        LottoNumbers("\n당첨 번호를 입력해 주세요."),
        BonusNumber("\n보너스 번호를 입력해 주세요.");
    }
}