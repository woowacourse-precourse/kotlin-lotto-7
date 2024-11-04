package model

import camp.nextstep.edu.missionutils.Randoms
import utils.LottoUtils

fun interface RandomNumberGenerator {
    fun generateRandomNumber(): Int
}

object LottoMaker: RandomNumberGenerator {
    override fun generateRandomNumber(): Int {
        return Randoms.pickNumberInRange(LottoUtils.MIN_VALUE, LottoUtils.MAX_VALUE)
    }

    fun makeLotto(): Lotto {
        val ticket = mutableListOf<Int>()
        repeat(LottoUtils.LOTTO_NUMBER_COUNTS) {
            var number = generateRandomNumber()
            while(number in ticket)
                number = generateRandomNumber()
            ticket.add(number)
        }
        return Lotto(ticket)
    }
}