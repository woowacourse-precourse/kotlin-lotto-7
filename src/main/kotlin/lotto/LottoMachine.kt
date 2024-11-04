package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import lotto.constant.Comment
import lotto.dto.Bonus
import lotto.dto.LottoPrinter
import lotto.dto.Money
import lotto.dto.WinningNumber

class LottoMachine {

    private val lottos: MutableList<Lotto> = mutableListOf()
    private lateinit var money: Money
    private lateinit var winningNumbers: WinningNumber

    fun run() {
        inputMoney()
        winningNumbers = WinningNumber(inputWinningNumber() to inputBonusNumber())
    }

    private fun inputMoney() {
        println(Comment.INPUT_MONEY.comment)
        money = Money.validateMoney(Console.readLine())

        println("${money.calculateNumberOfLotto()}개를 구매하였습니다.")
        repeat(money.calculateNumberOfLotto()) {
            val newLotto = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted())
            lottos.add(newLotto)
            LottoPrinter.printLotto(newLotto)
        }
    }

    private fun inputWinningNumber(): Lotto {
        println(Comment.INPUT_WINNING_NUMBER.comment)
        return Lotto.validateLotto(Console.readLine())
    }

    private fun inputBonusNumber(): Bonus {
        println(Comment.INPUT_BONUS_NUMBER.comment)
        return Bonus.validateBonus(Console.readLine())
    }



}