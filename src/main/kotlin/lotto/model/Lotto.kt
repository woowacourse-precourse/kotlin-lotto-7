package lotto.model

/**
 * 모델은 컨트롤러나 뷰에 의존하면 안된다.
 * 컨트롤러나 뷰의 코드가 있으면 안된다
 */

// 입력 값이 , 구분 되는지 판단
// 문자 아닌지 판단
// 공백 아닌지 판단 후 받음
class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.all { it in 1..45 }) { "[ERROR] 로또 번호는 1에서 45 이내여야 합니다." }
        require(numbers.distinct().size == numbers.size) { "중복 안돼" }
    }

    fun getLottoNumbers() = numbers

    // TODO: 추가 기능 구현
    // 여기선 뭘 해야하지????
    // 위 초기화를 보면 내가 입력한 당첨 번호에 대한 예외 처리
    // LottoTest를 보면 중복된 값에 대한 예외 처리해야 하고

    // 여기서 예외 처리를 하고, 당첨 번호와 맞는지 판단 해야할 듯?
    /**
     * 모델이 수행할 기능 목록
     *
     * 로또 번호 생성 -> 제네레이터
     * 로또 번호와 당첨 번호 비교 -> 여기서 번호가 유효하면
     * enum 클래스와 비교해서 일치한 정보 전달 -> 위와 같이
     * 총 수익률 계산
     */
}
