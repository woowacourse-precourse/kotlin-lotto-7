package lotto

val input = Input()
val output = Output()
val lottoMaker = LottoMaker()

fun main() {
    val inputAmount = input.getAmount()
    val lottos = lottoMaker.makeLottos(inputAmount)

    val inputNumbers = input.getLottoNumbers()
    val inputBonusNumber = input.getLottoBonusNumbers()

    val lottoRound = LottoRound(lottos, inputNumbers, inputBonusNumber)
    val ranks = lottoRound.getRankCount()
    output.printPrize(ranks, lottoRound.getRate(inputAmount))
}
