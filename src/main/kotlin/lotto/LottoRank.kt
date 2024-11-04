package lotto

import lotto.constants.ResultConstants

enum class LottoRank(val matchCount: Int, val prize: Int, val requiresBonus: Boolean = false) {
  FIRST(ResultConstants.FIRST_MATCH_COUNT, ResultConstants.FIRST_PRIZE),
  SECOND(ResultConstants.SECOND_MATCH_COUNT, ResultConstants.SECOND_PRIZE, true),
  THIRD(ResultConstants.SECOND_MATCH_COUNT, ResultConstants.THIRD_PRIZE),
  FOURTH(ResultConstants.FOURTH_MATCH_COUNT, ResultConstants.FOURTH_PRIZE),
  FIFTH(ResultConstants.FIFTH_MATCH_COUNT, ResultConstants.FIFTH_PRIZE),
  NONE(0, 0);

  val description: String
    get() = when (this) {
      FIRST -> ResultConstants.FIRST_DESCRIPTION
      SECOND -> ResultConstants.SECOND_DESCRIPTION
      THIRD -> ResultConstants.THIRD_DESCRIPTION
      FOURTH -> ResultConstants.FOURTH_DESCRIPTION
      FIFTH -> ResultConstants.FIFTH_DESCRIPTION
      NONE -> ""
    }

  companion object {
    fun fromMatchCountAndBonus(matchCount: Int, matchBonus: Boolean): LottoRank {
      return values().firstOrNull {
        it.matchCount == matchCount && (it.requiresBonus == matchBonus || !it.requiresBonus)
      } ?: NONE
    }
  }
}
