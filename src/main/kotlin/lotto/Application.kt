package lotto

import lotto.config.ApplicationFactory

fun main() {
    val lottoApplication = ApplicationFactory.createLottoApplication()
    lottoApplication.run()
}