package lotto

fun main() {
    val lottoService = LottoService()

    val money = getLottoPurchaseAmount()
    lottoService.issueLottos(money)
    printPurchasedLottos(lottoService.lottos)

    val winningNumbers = getLottoWinningInfo()
}
