# kotlin-lotto-precourse
### 기능 요구 사항

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
- 로또 1장의 가격은 1,000원이다. 
- 당첨 번호와 보너스 번호를 입력받는다. 
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다. 
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다. 
  - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

### 기능 목록

> 로또 게임 기능을 구현하자.

### Application

- [ ] 로또 게임을 시작한다.

### LottoMachine

- [x] 구매한 로또의 개수를 구한다.
- [x] 로또 번호를 생성한다.
- [ ] 당첨 번호를 입력받는다.
- [ ] 보너스 번호를 입력받는다.
- [ ] 통계 출력

### Lotto

- [ ] 로또 번호 생성한다.
- 로또 번호 예외
    - [x] 숫자가 중복이 될 때
    - [x] 1 ~ 45 사이의 숫자가 아닐 때
    - [x] 숫자가 6개가 아닐 때
    - [ ] 숫자가 오름차순 정렬이 아닐 때
- [ ] 로또 번호를 리턴한다.

### BonusNumber

- [ ] 보너스 번호를 생성한다.
- 보너스 번호 예외
    - [ ] 숫자가 아닐 떄
    - [ ] 1 ~ 45 사이의 숫자가 아닐 때
    - [ ] 당첨번호와 중복이 될 때

### Payment

- [ ] 당첨 금액을 생성한다.
  - 당첨 금액 예외
      - [x] 숫자가 아닐 때
      - [ ] 1000원 단위로 나누어 떨어지지 않을 때
      - [x] 0이하의 숫자일 때

### View

- [ ] 로또를 구매할 돈 입력받는다.
- [ ] 로또 구입 개수를 출력한다.
- [ ] 구입한 로또를 출력한다.
- [ ] 당첨 번호를 입력받는다.
- [ ] 보너스 번호를 입력받는다.
- [ ] 결과를 출력한다.

### Rank

- [ ] 당첨 금액에 대한 열거형 클래스

### Prize

- [ ] 상금 관리를 위한 클래스