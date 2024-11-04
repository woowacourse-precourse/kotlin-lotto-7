package lotto

import camp.nextstep.edu.missionutils.Randoms

// [#] 로또 매니저 클래스
class LottoManager (private val lottoCount : Int) {

    private lateinit var lottoTickets : List<Lotto>

    init{
        initLottoManager()
    }

    // [*] 초기화 : 로또 티켓 발행 (중복 제거, 오름차순 정렬)
    fun initLottoManager(){
        lottoTickets = List(lottoCount) {
            val numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN, LOTTO_MAX, 6).sorted()
            Lotto(numbers)
        }
    }

    // [*] 당첨 비교 및 통계 출력
    fun compareResults(winningNumbers: List<Int>, bonusNumber: Int) {
        val statistics = mutableMapOf<Rank, Int>()

        for (ticket in lottoTickets) {
            val matchCount = ticket.getLottoNumbers().count { it in winningNumbers }
            val isBonusMatched = ticket.getLottoNumbers().contains(bonusNumber)
            val rank = Rank.of(matchCount, isBonusMatched)
            statistics[rank] = statistics.getOrDefault(rank, 0) + 1
        }

        // 당첨 통계 출력
        val resultStringBuilder = StringBuilder()
        resultStringBuilder.append("\n당첨 통계\n---\n")

        // 3개, 4개, 5개 일치 통계 출력
        val prizes = mapOf(
            Rank.FIFTH to "(%,d원)".format(Rank.FIFTH.prize),
            Rank.FOURTH to "(%,d원)".format(Rank.FOURTH.prize),
            Rank.THIRD to "(%,d원)".format(Rank.THIRD.prize),
            Rank.SECOND to "(%,d원)".format(Rank.SECOND.prize),
            Rank.FIRST to "(%,d원)".format(Rank.FIRST.prize)
        )

        // 3개, 4개, 5개 일치 통계 출력
        for (rank in listOf(Rank.FIFTH, Rank.FOURTH, Rank.THIRD)) {
            val count = statistics.getOrDefault(rank, 0)
            resultStringBuilder.append("${rank.matchCount}개 일치 ${prizes[rank]} - $count" + "개\n")
        }

        // 보너스 일치와 함께 5개 일치 통계 출력
        val bonusCount = statistics.getOrDefault(Rank.SECOND, 0)
        resultStringBuilder.append("${Rank.SECOND.matchCount}개 일치, 보너스 볼 일치 ${prizes[Rank.SECOND]} - $bonusCount" + "개\n")

        // 6개 일치 통계 출력
        val firstCount = statistics.getOrDefault(Rank.FIRST, 0)
        resultStringBuilder.append("${Rank.FIRST.matchCount}개 일치 ${prizes[Rank.FIRST]} - $firstCount" + "개\n")

        // 총 수익률 계산 및 출력
        val purchaseAmount = lottoCount * 1000 // 예시: 로또 1장 가격을 1000원으로 가정
        val profitRate = statistics.entries.sumOf { (rank, count) -> rank.prize * count } / purchaseAmount.toDouble() * 100
        resultStringBuilder.append("총 수익률은 ${"%.1f".format(profitRate)}%입니다.\n")

        // 결과 출력
        println(resultStringBuilder.toString())
    }


    // [*] 로또 티켓 시각화 함수
    fun showLottoTickets(){
        for(i in lottoTickets.indices){
            println(lottoTickets[i].getLottoNumbers())
        }
        println()
    }
}

// [#] 등수 Enum 클래스
enum class Rank(val matchCount: Int, val prize: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    companion object {
        fun of(matchCount: Int, isBonusMatched: Boolean): Rank {
            return when (matchCount) {
                6 -> FIRST
                5 -> if (isBonusMatched) SECOND else THIRD
                4 -> FOURTH
                3 -> FIFTH
                else -> NONE
            }
        }
    }
}