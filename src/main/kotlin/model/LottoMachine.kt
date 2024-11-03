package model

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

object LottoMachine {

    fun issueLottoes(lottoCount: Int): List<Lotto> {
        val lottoes = mutableListOf<Lotto>()

        for (i in 1..lottoCount) {
            lottoes.add(
                generateLotto()
            )
        }

        return lottoes
    }

    private fun generateLotto(): Lotto {
        val lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)

        return Lotto(lottoNumbers)
    }

}