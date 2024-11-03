package lotto

import lotto.WinCondition.entries
import java.util.*

enum class WinCondition(
    val matches: Int,
    val bonusMatch: Boolean) {
    FIRST_PRIZE(6, false) {
        override fun prize(): Int {
            return 2000000000
        }
    },
    SECOND_PRIZE(5, true) {
        override fun prize(): Int {
            return 30000000
        }
    },
    THIRD_PRIZE(5, false) {
        override fun prize(): Int {
            return 1500000
        }
    },
    FOURTH_PRIZE(4, false) {
        override fun prize(): Int {
            return 50000
        }
    },
    FIFTH_PRIZE(3, false) {
        override fun prize(): Int {
            return 5000
        }
    },
    NONE(0, true) {
        override fun prize(): Int {
            return 0
        }
    };

    abstract fun prize(): Int
}

fun findCondition(matchCount: Int, bonusCondition: Boolean): WinCondition {
    return Arrays.stream(entries.toTypedArray())
        .filter { v -> v.matches == matchCount }
        .filter { b -> b.bonusMatch == bonusCondition }
        .findAny()
        .orElseThrow { IllegalArgumentException(String.format("%s 일치 조건이 존재하지 않습니다.", matchCount)) }
}