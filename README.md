# kotlin-lotto-precourse

## 로또

## 기능 목록
입력
- [x] 로또 구입 금액을 입력 받는다. 1,000 원 단위로 나누어 떨어지지 않는 경우 예외 처리한다.
- [x] 당첨 번호를 입력 받는다. 쉼표(,) 를 기준으로 구분한다.
- [x] 보너스 번호를 입력 받는다.

출력
- [x] 금액에 따른 로또 수량 및 번호를 출력한다. 오름차순으로 정렬해서 보여준다.
- [x] 당첨 내역을 출력한다.
- [x] 수익률을 출력한다. 소수점 둘째 자리에서 반올림한다.
  예외
- [x] 예외 상황 시 "[ERROR]" 로 시작하는 에러 문구를 출력한다.

---

## 세부 기능 목록
### model
### `Lotto`
- 6개의 로또 번호

### `LottoMachine`
- 로또 발행

### `WinningLotto`
`object` 로 구현
- 당첨 번호
- 보너스 번호

### `Prize`
`object` 로 구현
- 총 상금
- 수익률 계산

### view
### `InputView`
- [x] 로또 구입 금액을 입력받는다.
- [x] 당첨 번호를 입력받는다.
- [x] 보너스 번호를 입력받는다.
### `OutputView`
- [x] 로또 개수를 출력한다.
- [x] 발행한 로또들을 출력한다.
- [x] 당첨 통계를 출력한다.
- [x] 수익률을 출력한다.


### controller
### `LottoController`
- [x] 로또 구입 금액을 구매 개수로 분리한다.
- [x] 로또 번호를 생성한다.
- [x] 로또 번호를 오름차순으로 정렬한다.
- [x] 당첨 통계를 계산한다.
- [x] 수익률을 계산한다.
 
### util
### `Validator`
- [x] 구입 금액 검증 `MoneyValidator`
- [x] 당첨 번호 검증 `WinnerNumberValidator`
- [x] 보너스 번호 검증 `BonusNumberValidator`

### `ErrorMessage`
### `InputMessage`
### `OutputMessage`
- 예외의 경우에 따라서 다양하게 출력

## 유효성 검증
### 구입 금액 유효성 검증
1. 금액은 숫자 형태이어야 한다.
2. 금액은 양수이어야 한다.
3. 금액은 1,000원 단위로 나누어 떨어져야 한다.
4. 금액은 Int.MAX_VALUE 보다 작아야 한다.

### 당첨 번호 유효성 검증
1. 당첨 번호는 쉼표(,)로 구분될 수 있어야 한다.
2. 당첨 번호는 6개여야 한다.
3. 당첨 번호는 1~45 사이의 숫자여야 한다.
4. 당첨 번호는 중복되어서는 안된다.

### 보너스 번호 유효성 검증
1. 보너스 번호는 1~45 사이의 숫자여야 한다.
2. 보너스 번호는 당첨 번호와 중복되면 안 된다.

## 프로그래밍 요구 사항

- indent depth를 3이 넘지 않도록 구현한다.
- 단일 책임 원칙을 최대한 준수한다.
- 함수 길이가 15라인을 넘지 않도록 구현한다.
- else 를 지양한다.
- Enum 클래스를 적용하여 구현한다.
- 기능 목록을 작성하고 정상적으로 작동하는 지 테스트 코드로 확인한다.
- 기능이 전체적으로 작동하는 지 단위 테스트로 확인한다.
- 

## 개인적 목표(신규)

- [x] 테스트 케이스에 assertj, junit5 잘 사용하기
- [x] 예외 사항을 미리 몇 가지 작성하고 시작하기
- [x] 기능 하나하나 테스트 케이스 작성하기 (자명한 것 제외)
- [x] 요구 사항을 더 자세하기 기술하기
- [x] 기능들을 완전 자세하기 나누기 (함수)

## 개인적 목표(기존)

- [x] 코틀린 문법들을 사용해 코드를 간결하게 짜기
- [x] MVC 패턴 적용하기
- [x] 입,출력메시지를 상수, 변수화 하기
- [x] 예외 케이스 다양하게 생각하기
- [x] 테스트 코드 다양하게 작성하기
