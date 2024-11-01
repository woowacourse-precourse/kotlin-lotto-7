package lotto
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

class LottoGame {
    fun inputCost(): Int {
        println("구입금액을 입력해 주세요.")
        return Console.readLine().toInt()
    }
    fun inputWinningLotto(): Lotto {
        println("당첨 번호를 입력해 주세요.")
        val winningLotto = Console.readLine().split(',').map { it.toInt() }
        return Lotto(winningLotto)
    }
    fun inputBonusNumber(): Int {
        println("보너스 번호를 입력해 주세요.")
        val bonusNumber = Console.readLine().toInt()
        return bonusNumber
    }



}