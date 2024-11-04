package lotto.domain.lotto

import lotto.domain.numbergenerator.NumberGenerator
import lotto.dto.MatchedInfoDto

class LottoTicket private constructor(private val lottoNumbers: List<Lotto>) {

    fun compareWinningLotto(winningLotto: Lotto, bonusNumber: BonusNumber): List<MatchedInfoDto> {
        val matchedInfos = mutableListOf<MatchedInfoDto>()
        lottoNumbers.forEach {
            matchedInfos.add(it.getMatchedInfo(winningLotto, bonusNumber))
        }
        return matchedInfos.toList()
    }

    fun count(): Int {
        return lottoNumbers.size
    }

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