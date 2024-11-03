package lotto

import camp.nextstep.edu.missionutils.Randoms

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

    // [*] 시각화 함수
    fun showLottoTickets(){
        for(i in lottoTickets.indices){
            println(lottoTickets[i].getLottoNumbers())
        }
        println()
    }
}