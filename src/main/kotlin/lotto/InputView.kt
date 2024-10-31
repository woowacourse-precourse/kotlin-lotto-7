package lotto

class InputView {
  private fun informPurchaseAmount() {
    println(INPUT_INFORMATION_MESSAGE)
    println(INPUT_PURCHASE_AMOUNT_MESSAGE)
    println(INPUT_ONLY_NUMBER_MESSAGE)
    println(INPUT_OVER_1000_MESSAGE)
    println(INPUT_1000_UNITS_MESSAGE)
  }


  companion object InputMessage {
    const private val INPUT_INFORMATION_MESSAGE = "안녕하세요!\n채채의 로또 판매점에 오신것을 환영합니다\n로또 번호 한줄당 1000원입니다\n오늘도 LUCKY한 하루되세요!"
    const private val INPUT_PURCHASE_AMOUNT_MESSAGE = "아래의 사항을 준수해 로또 구입 금액을 입력하고 enter를 눌러주세요."
    const private val INPUT_ONLY_NUMBER_MESSAGE = "• 숫자만 입력해 주세요."
    const private val INPUT_OVER_1000_MESSAGE = "• 구입 금액은 1000원 이상 입력해 주세요."
    const private val INPUT_1000_UNITS_MESSAGE = "• 구입 금액은 1000원 단위로 입력해 주세요."
  }
}