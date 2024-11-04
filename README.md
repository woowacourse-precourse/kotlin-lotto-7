# kotlin-lotto-precourse

---

## 이번 프리코스 목표
- TDD 염두한 코드 작성
- 확장 함수 적극 활용
- 정확한 구조와 역할 분리

## 요구사항 Check
- [x] indent 2까지만 허용
- [ ] 함수가 하나의 일만 하기
- [x] 함수 15라인 이내 작성
- [x] else 지양
- [x] Enum 클래스 사용
- [x] UI 로직 제외한 테스트 코드 작성
- [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.

## 기능
- 입력
    - 구입 금액 (1,000원으로 나누어 떨어질 것)
    - 당첨 번호 (쉼표를 기준으로 구분할 것)
    - 보너스 번호
- 출력
    - 8개의 로또 당첨 번호 리스트
    - 당첨 통계 (일치 개수, 수익률)
- LottoService
    - ~~당첨 번호 저장~~
    - 로또 당첨 확인 matchAllLotto
    - 로또 생성 createRandomLotto
    - 구입 금액만큼 로또 구매 purchaseLottos
    - 당첨 로또 현황 업데이트 winStatusUpdate
    - 최종 수익 구하기 getResultMoney
    - 수익률 계산 getProfitRate

## 클래스
- Lotto 클래스
    - 6개가 아니면 throw IllegalArgumentException
    - 당첨 여부(일치 개수) 확인
- enum class WinningLotto(당첨금: Int, 당첨개수: Int)
    - Three, Four, Five, FiveBonus, Six

## Lotto 예외 테스트
- [x] 로또 번호의 개수가 6개가 넘어가면 예외가 발생한다
- [x] 로또 번호에 중복된 숫자가 있으면 예외가 발생한다
- [x] 로또 번호의 개수가 6개보다 적으면 예외 발생
- [x] 로또 번호가 범위를 벗어나면 예외 발생

## LottoValidator 예외 테스트
- [x] 금액이 문자열인 예외
- [x] 금액이 1000원 미만이거나, 1000으로 나누어 떨어지지 않는 예외
- [x] 당첨 번호 문자열이 정수가 아닌 예외
- [x] 보너스 번호가 정수가 아닌 예외
- [x] 보너스 번호가 범위 벗어나는 예외

## LottoService 테스트
- [x] 하나 구매한 로또 번호가 6개인지 확인
- [x] 금액에 따라 로또 구매 수량이 맞는지 확인
- [x] 당첨 로또 현황 업데이트 확인
- [x] 당첨 로또 수령 금액 확인
- [x] 수익률 계산 확인