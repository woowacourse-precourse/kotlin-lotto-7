package lotto.domain.rank

import lotto.dto.MatchedInfoDto

private const val PRICE_DELIMITER = ","
private const val REPLACE_DELIMITER = ""
private const val SECOND_CORRECT_COUNT = 5

enum class LottoRank(
    private val price: String = "0",
    private val correctCount: Int = 0,
    private val isCorrectBonusNumber: Boolean = false,
) {
    FIRST("2,000,000,000", 6, false),
    SECOND("30,000,000", 5, true),
    THIRD("1,500,000", 5, false),
    FOURTH("50,000", 4, false),
    FIFTH("5,000", 3, false),
    NONE
    ;

    companion object {
        fun getRank(matchedInfo: MatchedInfoDto): LottoRank {
            if (!isSecondPlaceCandidate(matchedInfo.correctCount)) matchedInfo.isCorrectBonusNumber = false
            return entries.firstOrNull {
                it.correctCount == matchedInfo.correctCount &&
                        it.isCorrectBonusNumber == matchedInfo.isCorrectBonusNumber
            } ?: NONE
        }

        private fun isSecondPlaceCandidate(correctCount: Int): Boolean {
            return correctCount == SECOND_CORRECT_COUNT
        }
    }

    fun calculatePrice(count: Int): Long {
        return this.price.replace(PRICE_DELIMITER, REPLACE_DELIMITER).toLong() * count
    }

    fun toStatistics(count: Int): String {
        return "${correctCount}개 일치${secondComment()}(${price}원) - ${count}개"
    }

    private fun secondComment(): String {
        return when (this) {
            SECOND -> ", 보너스 볼 일치 "
            else -> " "
        }
    }

}