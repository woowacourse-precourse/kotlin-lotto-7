package lotto

class Lotto(private val numbers: List<List<Int>>) {
    init {
        numbers.forEach { lotto -> println(lotto) }
    }
}
//
//    fun winningNumber(): List<Int> {
//        while (!validatorTest) {
//            winningNumberException()
//        }
//        return winningNumber
//    }
//
//    private fun winningNumberException(): Any {
//        try {
//            winningNumber = validateWinningNumber(separateWinningNumber())
//            validatorTest = true
//            return winningNumber
//        } catch (ex: Exception) {
//            return println(ex.message)
//        }
//    }
//
//    private fun winningNumberInput(): String {
//        return Console.readLine()
//    }
//
//    private fun validateWinningNumber(userInput: List<String>): List<Int> {
//
//        if (userInput.size != 6) {
//            throw IllegalArgumentException(ExceptionMessage.NOT_INPUT_SIX_NUMBER)
//        }
//        if (userInput.indexOf(Regex("^[0-9]*$"))) {
//            throw IllegalArgumentException(ExceptionMessage.NOT_NUMBERS)
//        }
//        if (userInput.toInt()>SettingValue.LOTTO_NUMBER_MAXIMUM || userInput.toInt()<SettingValue.LOTTO_NUMBER_MINIMUM) {
//            throw IllegalArgumentException(ExceptionMessage.NOT_LOTTO_NUMBER_RANGE)
//        }
////        if (userInput) {
////            throw IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_INPUT)
////        }
//        return userInput
//    }
//    private fun separateWinningNumber(): List<String> {
//        return winningNumberInput().split(SettingValue.NUMBER_DELIMITER)
//    }
//    private fun winningNumberMessege() {
//        return println(Message.ENTER_WINNING_NUMBER)
//    }
//}
////    fun start(numbers: List<Int>) {
////        if (numbers.size > 6) {
////            throw IllegalArgumentException(ExceptionMessage.NOT_DIVIDE_THOUSAND)
////        }
////    }
////
////    fun amount(): Int {
////        return PurchaseAmount().lottoPurchased()
////    }
////
////    fun winningNumber() {
////        return WinningNumber().winningNumber()
////    }
////
////    fun bonusNumber() {
////        return BonusNumber().bonusNumber()
////    }
////
////
////    fun random(numbers: List<Int>): MutableList<List<Int>> {
////        val listlotto = MutableList<List<Int>>()
////        repeat(amount()) {
////            listlotto.add(numbers)
////        }
////        return listlotto
////    }
////}
