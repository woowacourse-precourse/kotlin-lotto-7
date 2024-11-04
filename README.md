# kotlin-lotto-precourse

## 서비스 소개

여러 이름의 자동차와 진행할 라운드를 입력받아, 각 라운드마다 랜덤하게 전진하여 진행되는 자동차 경주 서비스입니다.

## 기능 요구 사항

- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 로또 1장의 가격은 1,000원이다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

## 생각해볼 것

## 설계

### 1. 로또 구입 금액을 입력 받는다.

`View`의 책임

### 2. 로또 구입 금액과 발행할 개수를 저장한다.

`ViewModel`의 책임

### 3. 발행할 개수 만큼 로또를 발행한다.

`Lotto`의 책임

### 4. 발행된 로또를 저장한다.

`ViewModel`의 책임

### 5. 발행된 로또를 출력한다.

`View`의 책임

### 6. 구매한 로또의 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.

`View`의 책임

### 7. 입력받은 당첨 번호를 저장한다.

`ViewModel`의 책임

### 8. 구매한 로또의 보너스 번호를 입력 받는다.

`View`의 책임

### 9. 입력받은 보너스 번호를 저장한다.

`ViewModel`의 책임

### 10. 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역을 계산한다.

`LottoOperator`의 책임

### 10. 당첨 내역을 출력한다.

`View`의 책임

### 11. 당첨 내역에 따른 금액을 계산한다.

`LotteryOperator`의 책임

### 12. 수익률을 계산한다.

`ProfitCalculator`의 책임

### 13. 계산된 수익률을 출력한다.

`View`의 책임

## 학습 노트

