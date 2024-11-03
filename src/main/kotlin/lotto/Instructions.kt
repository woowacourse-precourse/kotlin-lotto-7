package lotto

object Instructions {
    fun purchaseAmountInstructions(){
        println("구입금액을 입력해 주세요.")
    }

    fun numberOfPurchasesInstructions(purchaseAmount:Int){
        println("\n${purchaseAmount}개를 구매했습니다.")
    }

    fun winningNumberInstructions(){
        println("\n당첨 번호를 입력해 주세요.")
    }

    fun bonusNumberInstructions(){
        println("\n보너스 번호를 입력해 주세요.")
    }

}