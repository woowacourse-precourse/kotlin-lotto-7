package domain.enums

import util.toThousandUnit

enum class Output(private val msg: String) {
    PURCHASE("%d개를 구매했습니다.");
    
    override fun toString(): String = msg

    companion object {
        fun getPurchase(pay: String): Pair<String, Int> {
            val purchaseLottoCount = pay.toThousandUnit()
            return Pair(PURCHASE.toString().format(purchaseLottoCount), purchaseLottoCount)
        }
    }
}