package lotto

fun main() {
    val lottoInput = LottoInput()
    val lottoPurchaseAmount = lottoInput.retryPurchaseAmount()
    val lottoMachine = LottoMachine(lottoPurchaseAmount)
    println(lottoMachine.receipt())
    val lottoNumbers = lottoInput.retryNumbers()
    val lottoBonusNumber = lottoInput.retryBonusNumber()
    println(lottoMachine.result(lottoNumbers, lottoBonusNumber))
}
