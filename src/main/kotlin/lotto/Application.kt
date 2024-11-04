package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("구입금액을 입력해 주세요.")
    val amount = readLine()?.toIntOrNull() ?: 0
    val lottoCount = amount / 1000

    println("\n${lottoCount}개를 구매했습니다.")
    val lottoTickets = generateLottoTickets(lottoCount)
    lottoTickets.forEach { println(it.sorted()) }

    println("\n당첨 번호를 입력해 주세요.")
    val winningNumbers = readLine()
        ?.split(",")
        ?.map { it.trim().toInt() }
        ?.take(6)
        ?: emptyList()

    println("\n보너스 번호를 입력해 주세요.")
    val bonusNumber = readLine()?.toIntOrNull() ?: 0

    // 당첨 결과 확인
    val results = checkWinningTickets(lottoTickets, winningNumbers, bonusNumber)
    printResults(results)
}

// 개수만큼 로또 발행
fun generateLottoTickets(count: Int): List<List<Int>> {
    val tickets = mutableListOf<List<Int>>()
    repeat(count) {
        tickets.add(generateLottoTicket())
    }
    return tickets
}

// 랜덤 로또 번호 생성
fun generateLottoTicket(): List<Int> {
    return Randoms.pickUniqueNumbersInRange(1, 45, 6).toList()
}

// 당첨 번호 확인 및 결과 계산
fun checkWinningTickets(
    tickets: List<List<Int>>,
    winningNumbers: List<Int>,
    bonusNumber: Int
): Map<String, Int> {
    val results = mutableMapOf("1등" to 0, "2등" to 0, "3등" to 0, "4등" to 0, "5등" to 0)

    tickets.forEach { ticket ->
        val matchCount = ticket.count { it in winningNumbers }
        val isBonusMatched = bonusNumber in ticket

        when (matchCount) {
            6 -> results["1등"] = results.getValue("1등") + 1
            5 -> {
                if (isBonusMatched) results["2등"] = results.getValue("2등") + 1
                else results["3등"] = results.getValue("3등") + 1
            }
            4 -> results["4등"] = results.getValue("4등") + 1
            3 -> results["5등"] = results.getValue("5등") + 1
        }
    }
    return results
}

// 당첨 결과 출력
fun printResults(results: Map<String, Int>) {
    println("\n당첨 통계")
    println("---")
    println("3개 일치 (5,000원) - ${results["5등"]}개")
    println("4개 일치 (50,000원) - ${results["4등"]}개")
    println("5개 일치 (1,500,000원) - ${results["3등"]}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${results["2등"]}개")
    println("6개 일치 (2,000,000,000원) - ${results["1등"]}개")
}