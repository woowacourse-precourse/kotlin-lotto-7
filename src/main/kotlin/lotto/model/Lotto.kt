package lotto.model

import lotto.util.ErrorMessage
import java.util.random.RandomGenerator

class Lotto(private val numbers: List<LottoNumber>) : List<LottoNumber> by numbers {
    init {
        validateLotto(numbers)
    }

    private fun validateLotto(lottoNumbers: List<LottoNumber>) {
        validateLottoSize(lottoNumbers)
        validateDuplicateLottoNumber(lottoNumbers)
    }

    private fun validateLottoSize(lottoNumbers: List<LottoNumber>) {
        require(lottoNumbers.size == LOTTO_SIZE) {
            ErrorMessage.LOTTO_SIZE.getMessage()
        }
    }

    private fun validateDuplicateLottoNumber(lottoNumbers: List<LottoNumber>) {
        require(lottoNumbers.distinct().size == LOTTO_SIZE) {
            ErrorMessage.LOTTO_DUPLICATE.getMessage()
        }
    }

    companion object {
        const val LOTTO_SIZE = 6

        fun createRandomLotto(randomGenerator: NumberGenerator): Lotto {
            val numbers = randomGenerator.generateNumber(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER, LOTTO_SIZE)
                .map { LottoNumber(it) }
            return Lotto(numbers)
        }
    }
}
