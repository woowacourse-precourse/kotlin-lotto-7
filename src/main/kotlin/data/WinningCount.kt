package data

import util.SettingValue

enum class LottoMatchingCount(var count: Int, val prize: Double, val message: String) {
    FIFTH(0, 5_000.0, SettingValue.FIFTH),
    FOURTH(0, 50_000.0, SettingValue.FOURTH),
    THIRD(0, 1_500_000.0, SettingValue.THIRD),
    SECOND(0, 30_000_000.0, SettingValue.SECOND),
    FIRST(0, 2_000_000_000.0, SettingValue.FIRST),
    NONE(0, 0.0, "")
}