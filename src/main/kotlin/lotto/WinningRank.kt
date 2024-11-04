package lotto

import java.text.NumberFormat

enum class WinningRank(val price: Long = 0, val desc: String = ""){
    PLACE_1st(2000000000L, "6개 일치" ),
    PLACE_2nd(30000000L, "5개 일치, 보너스 볼 일치"),
    PLACE_3rd(1500000L, "5개 일치"),
    PLACE_4th(50000L, "4개 일치"),
    PLACE_5th(5000L, "3개 일치"),
    PLACE_Fail(0L, "");

    fun str(): String {
        return desc + price.toPriceStr()
    }

    private fun Long.toPriceStr(): String {
        val formatter = NumberFormat.getNumberInstance()
        return "(${formatter.format(this)}원)"
    }

    companion object {
        const val MATCH_COUNT_1st = 6
        const val MATCH_COUNT_2nd = 5
        const val MATCH_COUNT_3rd = 5
        const val MATCH_COUNT_4th = 4
        const val MATCH_COUNT_5th = 3
        /**
         * 로또 당첨 등수를 리턴한다.
         * * 1st : 당첨번호 [MATCH_COUNT_1st]개 일치
         * * 2nd : 당첨번호 [MATCH_COUNT_2nd]개 일치 + 보너스 번호 일치
         * * 3rd : 당첨번호 [MATCH_COUNT_3rd]개 일치 + 보너스 번호 불일치
         * * 4th : 당첨번호 [MATCH_COUNT_4th]개 일치
         * * 5th : 당첨번호 [MATCH_COUNT_5th]개 일치
         * * fail : 그외
         * @return WinningRank
         */
        fun getWinningRank(
            lottoNumber: List<Int>,
            winningNumbers: List<Int>,
            bonusNumber: Int,
        ): WinningRank {
            val matchCount = lottoNumber.count { it in winningNumbers }
            val hasBonus = bonusNumber in lottoNumber
            return when {
                matchCount == MATCH_COUNT_1st -> PLACE_1st
                matchCount == MATCH_COUNT_2nd && hasBonus -> PLACE_2nd
                matchCount == MATCH_COUNT_3rd -> PLACE_3rd
                matchCount == MATCH_COUNT_4th -> PLACE_4th
                matchCount == MATCH_COUNT_5th -> PLACE_5th
                else -> PLACE_Fail
            }
        }
    }
}