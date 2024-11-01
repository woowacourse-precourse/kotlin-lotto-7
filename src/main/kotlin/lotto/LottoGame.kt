package lotto
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

class LottoGame {
    fun inputCost(): Int {
        println("구입금액을 입력해 주세요.")
        val cost = Console.readLine().toInt()
        return cost
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
    fun buyLottos(cost: Int): List<Lotto> {
        val lottoCount = cost / 1000
        println("${lottoCount}개를 구매했습니다.")
        return List(lottoCount) {
            val lottoNumbers = Randoms.pickUniqueNumbersInRange(1,45,6).sorted()
            val lotto = Lotto(lottoNumbers)
            println(lotto)
            lotto
        }
    }



}