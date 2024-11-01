package lotto.view

/**
 * 뷰는 모델에만 의존해야 하고, 컨트롤러에는 의존하면 안된다.
 * 뷰 내부는 모델 코드만 있을 수 있다.
 * 뷰가 모델로부터 데이터를 받을 때는 사용자마다 다르게 보여주어야 하는데이터에 한해 받는다
 * 모델로부터 데이터를 받을 때는 컨트롤러에서 받아야한다.
 */

class OutputView {

    fun showPurchasedLottoCount(count: Int) = println("\n${count}개를 구매했습니다.")

    // 컨트롤러 -> 모델(LottoGenerator) -> 매개변수 받기 -> 컨트롤러에서 수행
    fun showPurchasedLottoList(count: Int) = println()

    // 당첨 통계 --- 간단 출력도 여기서?

    // 컨트롤러에서 LottoRank 값을 받아 통계 출력

    // 수익률 출략
}