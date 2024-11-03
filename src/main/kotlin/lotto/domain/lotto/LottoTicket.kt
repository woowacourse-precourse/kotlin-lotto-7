package lotto.domain.lotto

import lotto.domain.numbergenerator.NumberGenerator

class LottoTicket private constructor(private val lottoNumbers: List<Lotto>) {

    override fun toString(): String {
        return buildString {
            lottoNumbers.forEach {
                appendLine(it.toString())
            }
        }.trimEnd()
    }

    companion object {
        fun publish(count: Int, numberGenerator: NumberGenerator): LottoTicket {
            val lottoNumbers = mutableListOf<Lotto>()
            repeat(count) {
                lottoNumbers.add(Lotto(numberGenerator.generateLottoNumbers()))
            }
            return LottoTicket(lottoNumbers.toList())
        }
    }

}