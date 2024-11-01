package lotto.model

/**
 * 모델은 컨트롤러나 뷰에 의존하면 안된다.
 * 컨트롤러나 뷰의 코드가 있으면 안된다
 */

// 프로퍼티를 받아 어떤 등급이랑 일치하는지 확인?
enum class LottoRank(val matchCount: Int, val reward: Int) {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(6, 5000),
    NONE(0, 0);

    fun getRank() {}
}