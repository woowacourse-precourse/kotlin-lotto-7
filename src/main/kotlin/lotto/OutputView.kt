package lotto

class OutputView {
    fun printLottoCount(count: Int, myLotto: List<List<Int>>) {
        println("\n${count}개를 구매했습니다.")
        myLotto.forEach { lottoNumbers ->
            println(lottoNumbers.joinToString(prefix = "[", postfix = "]", separator = ", "))
        }
    }

    fun printLottoRank(lotto: Lotto) {
        println("\n당첨 통계")
        println("---")
        println("3개 일치 (5,000원) - ${lotto.fifthRank}개")
        println("4개 일치 (50,000원) - ${lotto.fourthRank}개")
        println("5개 일치 (1,500,000원) - ${lotto.thirdRank}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${lotto.secondRank}개")
        println("6개 일치 (2,000,000,000원) - ${lotto.firstRank}개")
    }
}