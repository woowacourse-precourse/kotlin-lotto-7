package view

import lotto.model.lotto.Lotto

class OutputView {
    fun displayPurchaseLottoNumbers(lottoNumbers: List<Lotto>) {
        println()
        println("${lottoNumbers.size}개를 구매했습니다.")
        lottoNumbers.forEach { println(it.getNumbers()) }
    }

}