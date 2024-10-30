# kotlin-lotto-precourse

# 구현 기능 목록

- 로또 구입 금액 입력을 안내하는 기능
- 로또 구입 금액을 입력 받는 기능


- 당첨 번호 입력을 안내하는 기능
- 당첨 번호를 입력받는 기능


- 보너스 번호 입력을 안내하는 기능
- 보너스 번호를 입력받는 기능


- 발행 가능한 로또 수량을 계산하는 기능
- 발행한 로또 수량을 출력하는 기능
- 구입 금액이 설정된 로또 1장 가격과 나누어 떨이지지 않는 경우 예외 처리 기능


- 지정된 범위에서 로또 번호 6개를 무작위로 뽑는 기능
    - 중복 불가
- 무작위로 뽑은 로또 번호 6개를 정렬하는 기능
    - 오름차순
- 구입가능한 로또 갯수에 따라 로또를 여러 번 뽑는 기능
- 정렬된 로또 번호를 발행한 로또 수량에 따라 출력하는 기능


- 사용자의 로또 번호들과 지정된 당첨 번호의 일치 갯수(등수)를 알려주는 기능
- 당첨 번호 5개와 일치한 사용자(3등)의 로또 번호들과 보너스 번호가 일치하는 지 알려주는 기능
- 당첨 통계를 출력하는 기능
    - 일치 갯수(등수)와 그에 해당하는 갯수


- 수익률 (로또 구입 금액 / 당첨금 * 100)을 계산하는 기능
- 수익률을 출력하는 기능

# 기능 요구 사항

- 로또 번호의 숫자 범위 ; 1~45


- 번호 추첨은 `중복되지 않는` 숫자 6개


- 당첨은 1등 ~ 5등
    - 1등 ; 전부 일치 ; 2,000,000,000원
    - 2등 ; 5개 + `보너스` 번호 일치 ; 30,000,000원
    - 3등 ; 5개 ; 1,500,000원
    - 4등 ; 4개 ; 50,000원
    - 5등 ; 3개 ; 5,000원


- 로또 1장 가격 1,000원
- 로또 구입 금액 입력 시 해당하는 만큼의 로또 발행
    - 로또 가격으로 나누어 떨어지지 않는 경우 예외
    - 구매한 `로또 번호` 출력
        - 오름차 순


- 당첨 번호 + 보너스 번호를 `입력`받는다.
    - `,` 기준 입력
    - 당첨번호와 보너스 번호는 나눠서 입력 받기


- 사용자의 로또 번호와 당첨 번호를 비교하여
    - `당첨내역` 출력
        - 5등~1등 순
    - `수익률` 출력
        - 소수점 둘째 자리 `반올림`


- 잘못된 값 입력 시
    - `IllegalArgumentException`을 발생시키고,
    - `[ERROR]`로 시작하는 에러 메시지를 출력 후
    - 그 부분부터 입력을 다시 받는다.

## 입력값

- 구입금액
- 당첨 번호
- 보너스 번호

## 출력값

- 구매 갯수
- 구매된 로또 번호
- 당첨 통계
    - 당첨내역
    - 수익률

# 프로그래밍 요구 사항

- `indent depth` 2까지 허용
- 한 가지 일 함수
    - 각 함수의 코드길이는 15 이하
- 테스트 코드 작성
    - 단위 테스트
- `else` 지양
- `Enum` 사용
- 제공된 `Lotto` 클래스 사용
    - `numbers` 이외 필드 추가 금지
    - `numbers`의 접근 제어자 변경 금지
    - `Lotto`의 패키지 변경은 무관

## 라이브러리

- `camp.nextstep.edu.missionutils`
    - `Console.readLine()`
    - `Randoms.pickUniqueNumbersInRange()`

---

# 예외 케이스

- 구입 금액 입력 시..
    - 음수값 ; -1
    - 0
    - 로또 가격으로 나누어 떨어지지 않는 경우 (과제 지정 조건)
    - 잘못된 타입 ; `String`, `Double` 등

- 당첨 번호 입력 시..
    - 음수값 ; -1
    - 과제 지정 범위 초과 ; 1~45
    - 잘못된 타입 ; `String`, `Double` 등
    - 중복된 번호 입력 (사용자의 추첨이 중복 불가능이므로)
    - 보너스 번호와 같은 경우

# 슈도 코드 작성

