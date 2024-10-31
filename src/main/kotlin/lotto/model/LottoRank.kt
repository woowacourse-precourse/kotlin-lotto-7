package lotto.model

/**
 * 모델은 컨트롤러나 뷰에 의존하면 안된다.
 * 컨트롤러나 뷰의 코드가 있으면 안된다
 */

// 프로퍼티를 받아 어떤 등급이랑 일치하는지 확인?
enum class LottoRank {
    FIRST,
    SECOND,
    THIRD,
    FOURTH,
    FIFTH,
    NONE,
}