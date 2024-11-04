package lotto.dto

import lotto.Lotto

class LottoPrinter {
    companion object {
        fun printLotto(lotto: Lotto) {
            println("[${lotto.getLotto().joinToString()}]")
        }
    }
}