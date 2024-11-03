package lotto

import lotto.values.Consts

enum class LottoRank(val prize: Int) {
    NONE(Consts.NONE_PRIZE),
    FIRST(Consts.FIRST_PRIZE),
    SECOND(Consts.SECOND_PRIZE),
    THIRD(Consts.THIRD_PRIZE),
    FOURTH(Consts.FOURTH_PRIZE),
    FIFTH(Consts.FIFTH_PRIZE)
}