package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun getPurchaseAmount(): String {
        informPurchaseAmount()
        val purchaseAmount = getInput()
        return purchaseAmount
    }

    fun getLuckNumbers(): String {
        informLuckNumbers()
        val luckNumbers = getInput().trim()
        return luckNumbers
    }

    fun getBonusNumber(): String {
        informBonusNumber()
        val bonusNumber = getInput().trim()
        return bonusNumber
    }

    private fun getInput(): String {
        val userInput = Console.readLine()
        return userInput
    }

    fun closeInput() = Console.close()

    private fun informPurchaseAmount() {
        println(INPUT_INFORMATION_MESSAGE)
        println(INPUT_PURCHASE_AMOUNT_MESSAGE)
        println(INPUT_ONLY_NUMBER_MESSAGE)
        println(INPUT_OVER_1000_MESSAGE)
        println(INPUT_1000_UNITS_MESSAGE)
    }

    private fun informLuckNumbers() {
        println(INPUT_LUCKY_NUMBERS_MESSAGE)
        println(INPUT_NUMBERS_RANGE_MESSAGE)
        println(INPUT_POSITIVE_NUMBERS_MESSAGE)
        println(INPUT_6_NUMBERS_MESSAGE)
        println(INPUT_NO_DUPLICATE_NUMBER_MESSAGE)
        println(INPUT_COMMA_MESSAGE)
        println(INPUT_NO_BLANK_MESSAGE)
        println(INPUT_LUCKY_NUMBERS_EXAMPLE_MESSAGE)
    }

    private fun informBonusNumber() {
        println(INPUT_BONUS_NUMBER_MESSAGE)
        println(INPUT_BONUS_NUMBER_RANGE_MESSAGE)
        println(INPUT_POSITIVE_BONUS_NUMBER_MESSAGE)
        println(INPUT_NO_DUPLICATE_LUCKY_NUMBERS_MESSAGE)
        println(INPUT_NO_BLANK_MESSAGE)
    }

    companion object InputMessage {
        private const val INPUT_INFORMATION_MESSAGE = "안녕하세요!\n채채의 로또 판매점에 오신것을 환영합니다\n로또 번호 한줄당 1000원입니다\n오늘도 LUCKY한 하루되세요!"
        private const val INPUT_PURCHASE_AMOUNT_MESSAGE = "아래의 사항을 준수해 로또 구입 금액을 입력하고 enter를 눌러주세요."
        private const val INPUT_ONLY_NUMBER_MESSAGE = "• 숫자만 입력해 주세요."
        private const val INPUT_OVER_1000_MESSAGE = "• 구입 금액은 1000원 이상 입력해 주세요."
        private const val INPUT_1000_UNITS_MESSAGE = "• 구입 금액은 1000원 단위로 입력해 주세요."

        private const val INPUT_LUCKY_NUMBERS_MESSAGE = "아래의 사항을 준수해 당첨 번호 6개를 입력하고 enter를 눌러주세요."
        private const val INPUT_NUMBERS_RANGE_MESSAGE = "• 당첨 번호는 1부터 45까지 가능합니다."
        private const val INPUT_POSITIVE_NUMBERS_MESSAGE = "• 당첨 번호는 양의 정수만 입력해주세요."
        private const val INPUT_6_NUMBERS_MESSAGE = "• 당첨 번호는 6개 입력해주세요."
        private const val INPUT_NO_DUPLICATE_NUMBER_MESSAGE = "• 중복된 숫자 입력은 안됩니다."
        private const val INPUT_COMMA_MESSAGE = "• 숫자 사이에는 쉼표(,)를 넣어주세요"
        private const val INPUT_NO_BLANK_MESSAGE = "• 입력 시 공백은 자동으로 제거됩니다."
        private const val INPUT_LUCKY_NUMBERS_EXAMPLE_MESSAGE = "예시)1,2,3,4,5,6"

        private const val INPUT_BONUS_NUMBER_MESSAGE = "아래의 사항을 준수해 보너스 번호 1개를 입력하고 enter를 눌러주세요."
        private const val INPUT_BONUS_NUMBER_RANGE_MESSAGE = "• 보너스 번호는 1부터 45까지 가능합니다."
        private const val INPUT_POSITIVE_BONUS_NUMBER_MESSAGE = "• 보너스 번호는 양의 정수만 입력해주세요."
        private const val INPUT_NO_DUPLICATE_LUCKY_NUMBERS_MESSAGE = "• 당첨 번호와 중복된 숫자 입력은 안됩니다."
    }
}