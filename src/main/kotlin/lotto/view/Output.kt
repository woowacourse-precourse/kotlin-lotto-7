package lotto.view

import lotto.model.Lotto

class Output {
    fun printLottoNumbers(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        repeat(lottos.size) { idx ->
            println(lottos[idx].getLottoNumbers())
        }
        println()
    }
}