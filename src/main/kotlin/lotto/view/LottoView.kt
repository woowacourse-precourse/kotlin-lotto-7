package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.model.BonusNumber
import lotto.model.Rank

class LottoView {

    fun readWinningNumbers(): List<Int?> {
        while (true) {
            println("당첨 번호를 입력해 주세요.")
            val input = Console.readLine()

            // 입력이 비어 있는 경우
            if (input.isBlank()) {
                println("[ERROR] 당첨 번호는 비워둘 수 없습니다.")
                continue  // 반복하여 재입력 요청
            }

            // 입력을 정수 리스트로 변환 시도
            val numbers = input.split(",")
                .map { it.trim().toIntOrNull() }

            if (numbers.any { it == null }) {
                println("[ERROR] 당첨 번호는 정수만 입력해야 합니다.")
                continue  // 반복하여 재입력 요청
            }

            return numbers
        }
    }

    fun readBonusNumber(): Int {
        while (true) {
            println("보너스 번호를 입력해 주세요.")
            val input = Console.readLine()

            if (input.isBlank()) {
                println("[ERROR] 보너스 번호는 비워둘 수 없습니다.")
                continue
            }

            val bonusNumber = input.toIntOrNull()
            if (bonusNumber == null || bonusNumber !in 1..45) {
                println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.")
                continue
            }

            return bonusNumber
        }
    }

    fun displayPurchaseCount(count: Int) {
        println()
        println("${count}개를 구매했습니다.")
    }

    fun displayStatistics(statistics: Map<Rank, Int>) {
        for (rank in Rank.values().reversed()) { // 역순으로 반복
            if (rank != Rank.MISS) { // MISS는 출력하지 않음
                println("${rank.message}${statistics.getOrDefault(rank, 0)}개") // "개" 추가
            }
        }
    }


    fun displayYield(yield: Double) {
        println("총 수익률은 ${"%.1f".format(yield)}%입니다.") // 소수점 1자리까지 포맷하여 출력
    }

    fun displayWinningStatistics() {
        println("당첨 통계")
        println("---")
    }
}
