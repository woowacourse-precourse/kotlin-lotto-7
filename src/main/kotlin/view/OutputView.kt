package view

import lotto.Lotto
import model.Prize

object OutputView {
    fun printLotto(count: Int, lottoes: List<Lotto>) {
        println("${count}개를 구매했습니다.")
        lottoes.forEach { println(it) }
    }

    fun printWinningStatistics() {
        println("당첨 통계")
        println("---")
        Prize.entries.forEach{
            when(it){
                Prize.SECOND -> println(
                    "${it.matchCount}개 일치, 보너스 볼 일치(${it.prize}${it.winningCount}개"
                )
                else -> println(
                    "${it.matchCount}개 일치 (${it.prize}원) - ${it.winningCount}개"
                )
                // Prize 클래스에 toString 을 정의하는 것도 고민해봤지만, 이 방식이 더 간결해서 else 를 사용했습니다.
                // else 를 사용하지 않고, 간결성을 챙길 수 있다면 편하게 제안해주시면 감사하겠습니다 !
            }
        }
    }

}
