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
    val bonusNumber = inputBonusNumber(winningNumbers)
    val lottoResults = checkResult(lottos, winningNumbers, bonusNumber) //로또 당첨 결과

    calculateProfit(lottoCnt, lottoResults)
}

/* 로또 구입 금액 입력 함수 */
fun inputMoney(): Int {
    while (true) {
        try {
            println("구입금액을 입력해 주세요.")
            val input = readLine()

            //입력 값이 없는 경우 예외 처리
            if (input.isNullOrEmpty()) {
                throw IllegalArgumentException("[ERROR] 입력 값이 없습니다.")
            }

            //입력 값이 숫자가 아닌 경우 예외 처리
            val money = input.toIntOrNull()
            if (money == null) {
                throw IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.")
            }

            //입력한 숫자가 1000으로 나누어 떨어지지 않는 경우 예외 처리
            if (money % 1000 != 0) {
                throw IllegalArgumentException("[ERROR] 금액이 1000으로 나누어 떨어지지 않습니다.")
            }

            return money / 1000
        } catch (e: IllegalArgumentException) {
            println(e.message)
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
            val input = readLine()

            //입력 값이 없는 경우 예외 처리
            if (input.isNullOrEmpty()) {
                throw IllegalArgumentException("[ERROR] 입력 값이 없습니다.")
            }

            val numbers = input.split(",").map { it.trim() }

            for (number in numbers) {
                if (!number.all { it.isDigit() }) {
                    throw IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.")
                }
            }

            val intNumbers = numbers.map { it.toInt() }

            //6개를 입력하지 않은 경우 예외 처리
            if (intNumbers.size != 6) {
                throw IllegalArgumentException("[ERROR] 6개를 입력해 주세요.")
            }

            //중복된 숫자를 입력한 경우 예외 처리
            if (intNumbers.distinct().size != intNumbers.size) {
                throw IllegalArgumentException("[ERROR] 중복된 숫자가 포함되어 있습니다.")
            }

            //범위 밖의 숫자를 입력한 경우 예외 처리
            if (!intNumbers.all { it in 1..45 }) {
                throw IllegalArgumentException("[ERROR] 1에서 45 사이의 숫자를 입력해 주세요.")
            }

            return intNumbers
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

/* 보너스 번호 입력 함수 */
fun inputBonusNumber(winningNumbers: List<Int>): Int {
    while(true) {
        try {
            println("\n보너스 번호를 입력해 주세요.")
            val input = readLine()

            //입력 값이 없는 경우 예외 처리
            if (input.isNullOrEmpty()) {
                throw IllegalArgumentException("[ERROR] 입력 값이 없습니다.")
            }

            //입력 값이 숫자가 아닌 경우 예외 처리
            val bonusNumber = input.toIntOrNull()
            if (bonusNumber == null) {
                throw IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.")
            }

            //입력한 숫자가 당첨 번호와 중복되는 경우 예외 처리
            if (bonusNumber in winningNumbers) {
                throw IllegalArgumentException("[ERROR] 로또 번호와 중복되는 숫자입니다.")
            }

            return bonusNumber
        } catch (e: IllegalArgumentException) {
            println(e.message)
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
fun calculateProfit(lottoCnt: Int, lottoResults: LottoResult) {
    val totalPrize = lottoResults.getTotalPrize().toDouble()
    val purchaseAmount = (lottoCnt * 1000).toDouble()
    val profitRate = (totalPrize / purchaseAmount) * 100 //수익률 = 당첨 금액 / 구입 금액 * 100
    println("총 수익률은 ${String.format("%.1f", roundToTwo(profitRate))}%입니다.")
}

/* 소수점 두번째에서 반올림 계산 함수 */
fun roundToTwo(number: Double): Double {
    return BigDecimal(number).setScale(2, RoundingMode.HALF_UP).toDouble()
}