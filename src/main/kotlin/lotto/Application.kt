package lotto

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange
import java.math.BigDecimal
import java.math.RoundingMode

fun main() {
    startLotto()
}

/* 로또 실행 함수 */
fun startLotto() {
    val lottoCnt = inputMoney() //구입한 로또 개수
    val lottos = mutableListOf<Lotto>() //발행한 로또 리스트

    repeat(lottoCnt) {
        pickLottoNumbers(lottos)
    }

    showLottoInfo(lottos)

    val winningNumbers = inputWinningNumbers()
    val bonusNumber = inputBonusNumber()

    val lottoResults = checkResult(lottos, winningNumbers, bonusNumber) //로또 당첨 결과
    val profitRate = calculateProfit(lottoCnt, lottoResults)
}

/* 로또 구입 금액 입력 함수 */
fun inputMoney(): Int {
    while (true) {
        try {
            println("구입금액을 입력해 주세요.")
            val money = readLine()?.toInt() ?: throw IllegalArgumentException("[ERROR] 입력 값이 없습니다.")

            if (money % 1000 != 0) {
                throw IllegalArgumentException("[ERROR] 금액이 1000으로 나누어 떨어지지 않습니다.")
            }

            return money / 1000
        } catch(e: IllegalArgumentException) {
            println(e.message)
        } catch (e: NumberFormatException) {
            println("[ERROR] 숫자를 입력해 주세요.")
        }
    }
}

/* 로또 발행 함수 */
fun pickLottoNumbers(lottos: MutableList<Lotto>) {
    val lottoNumbers = pickUniqueNumbersInRange(1, 45, 6)
    lottos.add(Lotto(lottoNumbers))
}

/* 발행한 로또 정보 출력 함수 */
fun showLottoInfo(lottos: MutableList<Lotto>) {
    println("\n${lottos.size}개를 구매했습니다.")
    lottos.forEach { println(it.toString()) }
}

/* 당첨 번호 입력 함수 */
fun inputWinningNumbers(): List<Int> {
    while (true) {
        try {
            println("\n당첨 번호를 입력해 주세요.")
            val input = readLine() ?: throw IllegalArgumentException("[ERROR] 입력 값이 없습니다.")

            val numbers = input.split(",")
                .map { it.trim().toIntOrNull() } //숫자로 변환
                .filterNotNull() //null 제거

            if (numbers.size != 6) {
                throw IllegalArgumentException("[ERROR] 6개를 입력해 주세요.")
            }

            return numbers
        } catch (e: IllegalArgumentException) {
            println(e.message)
        } catch (e: NumberFormatException) {
            println("[ERROR] 숫자를 입력해 주세요.")
        }
    }
}

/* 보너스 번호 입력 함수 */
fun inputBonusNumber(): Int {
    while(true) {
        try {
            println("\n보너스 번호를 입력해 주세요.")
            val bonusNumber = readLine().toInt()

            return bonusNumber
        } catch (e: NumberFormatException) {
            println("[ERROR] 숫자를 입력해 주세요.")
        }
    }
}

/* 당첨 순위 확인 함수 */
fun checkLottoRank(lotto: List<Int>, winningNumbers: List<Int>, bonusNumber: Int): LottoRank? {
    val matchingCnt = lotto.intersect(winningNumbers.toSet()).size //일치한 숫자의 개수
    val hasBonusNumber = lotto.contains(bonusNumber)

    return LottoRank.from(matchingCnt, hasBonusNumber)
}

/* 당첨 결과 확인 함수 */
fun checkResult(lottos: MutableList<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): LottoResult {
    val lottoResults = LottoResult()

    for (lotto in lottos) {
        val rank = checkLottoRank(lotto.getNumbers(), winningNumbers, bonusNumber)

        if (rank != null) {
            lottoResults.addWinners(rank)
        }
    }

    lottoResults.showResult()

    return lottoResults
}

/* 수익률 계산 함수 */
fun calculateProfit(lottoCnt: Int, lottoResults: LottoResult): Double {
    val totalPrize = lottoResults.getTotalPrize()
    val profitRate = totalPrize / lottoCnt * 1000 * 100 //수익률 = 당첨 금액 / 구입 금액 * 100
    return BigDecimal(profitRate).setScale(2, RoundingMode.HALF_UP).toDouble()
}