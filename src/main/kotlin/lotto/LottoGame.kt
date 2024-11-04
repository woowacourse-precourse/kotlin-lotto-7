package lotto
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

class LottoGame(
    private val readLine: () -> String = { Console.readLine() }
) {
    fun start(): LottoResult {
        val cost = inputCost()
        val winningLotto = inputWinningLotto()
        val bonusNumber = inputBonusNumber(winningLotto)
        val lottoList = buyLottos(cost)
        val result = calculateResult(lottoList, winningLotto, bonusNumber)
        printResults(result)
        printTotalReturn(result,cost)

        return result
    }

    fun inputCost(): Int {
        println("구입금액을 입력해 주세요.")
        return try {
            val input = readLine()
            parseCost(input)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            inputCost()
        }
    }
    // 테스트 코드에 접근할 수 있도록 하기 위해 internal 로 설정
    internal fun parseCost(input: String): Int {
        val cost =
            input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 금액은 숫자로 입력해야 합니다.")
        if (cost < 1000 || cost % 1000 != 0) throw IllegalArgumentException("[ERROR] 금액은 1,000원 단위로 입력해야 합니다.")
        return cost
    }

    fun inputWinningLotto(): Lotto {
        println("당첨 번호를 입력해 주세요.")
        val input = readLine()
        return try {
            parseWinningLotto(input)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            inputWinningLotto()
        }
    }

    internal fun parseWinningLotto(input: String): Lotto {
        val winningLotto = input.split(',')
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 당첨번호는 숫자로 입력해야 합니다.") }
        return Lotto(winningLotto)
    }

    fun inputBonusNumber(winningLotto: Lotto): Int {
        println("보너스 번호를 입력해 주세요.")
        val input = readLine()
        return try {
            parseBonusNumber(input, winningLotto)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            inputBonusNumber(winningLotto)
        }
    }

    internal fun parseBonusNumber(input: String, winningLotto: Lotto): Int {
        val bonusNumber = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 보너스 번호는 숫자로 입력해야 합니다.")
        if (bonusNumber !in 1..45) {
            throw IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.")
        }
        if (bonusNumber in winningLotto.getNumbers()) {
            throw IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.")
        }
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

    fun calculateResult(lottoList: List<Lotto>, winningLotto: Lotto, bonusNumber: Int
    ): LottoResult {
        val result = LottoResult()
        for (lotto in lottoList) {
            val matchCount = lotto.getMatchCount(winningLotto)
            val rank = LottoRank.getRank(matchCount, lotto.containBonusNum(bonusNumber))
            result.addRank(rank)
        }
        return result
    }

    fun printResults(result: LottoResult) {
        println("3개 일치 (5,000원) - ${result.countRank(LottoRank.FIFTH)}개")
        println("4개 일치 (50,000원) - ${result.countRank(LottoRank.FOURTH)}개")
        println("5개 일치 (1,500,000원) - ${result.countRank(LottoRank.THIRD)}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${result.countRank(LottoRank.SECOND)}개")
        println("6개 일치 (2,000,000,000원) - ${result.countRank(LottoRank.FIRST)}개")
    }

    fun printTotalReturn(result: LottoResult, cost: Int) {
        val totalPrize = result.calculateTotalPrize()
        val totalReturn = Math.round((totalPrize.toDouble() / cost) * 100 * 10) / 10.0
        println("총 수익률은 ${totalReturn}%입니다.")
    }
}