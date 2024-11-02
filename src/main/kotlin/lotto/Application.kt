package lotto

import camp.nextstep.edu.missionutils.Randoms




const val LOTTO_AMOUNT = 1000

fun main() {

    val input = Input()
    val output = Output()
    val randomNumber = RandomNumber()

    val inputAmount = input.getAmount()

    val lottoCount = inputAmount.toInt().div(LOTTO_AMOUNT)
    val lottoNumber = randomNumber.randomLottos(lottoCount)
    output.printLottoNumbers(lottoNumber)

    val lottos = lottoNumber.map { Lotto(it) }

    val inputNumbers = input.getLottoNumbers()
    val inputBonusNumber = input.getLottoBonusNumbers()

    lottos.forEach{ println(it.getRank(inputNumbers, inputBonusNumber)) }


}
