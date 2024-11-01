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
    fun calculateResult(
        lottoList: List<Lotto>,
        winningLotto: Lotto,
        bonusNumber: Int
    ): LottoResult {
        val result = LottoResult()
        for (lotto in lottoList) {
            val matchCount = lotto.getMatchCount(winningLotto)
            val rank = LottoRank.getRank(matchCount, lotto.contains(bonusNumber))
            result.addRank(rank)
        }
        return result
    }
    fun printResults(result: LottoResult) {
        println("3개 일치 5,000원) - ${result.countRank(LottoRank.FIFTH)}개")
        println("4개 일치 50,000원) - ${result.countRank(LottoRank.FOURTH)}개")
        println("5개 일치 1,500,000원) - ${result.countRank(LottoRank.THIRD)}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${result.countRank(LottoRank.SECOND)}개")
        println("6개 일치 (2,000,000,000원) - ${result.countRank(LottoRank.FIRST)}개")
    }
    



}