# kotlin-lotto-precourse

## Lotto Game Flow

1. 사용자로부터 로또 구입금액을 입력받는다. [1장 :1000원]
2. 구입금액만큼 로또 번호를 생성 후 출력한다.
3. 사용자로부터 로또 당첨 번호를 입력받는다.
4. 사용자로부터 보너스 번호를 입력받는다.
5. 당첨 결과를 출력한다. [모든 등수 결과를 출력]
6. 총 수익률을 출력한다.

## 구현 기능 목록

### 입출력

- [x] 구입금액 **<span style="color:red;">입력</span>** 안내 메시지를 출력한다.
- [x] 당첨 번호 **<span style="color:red;">입력</span>** 안내 메시지를 출력한다.
- [x] 보너스 번호 **<span style="color:red;">입력</span>** 안내 메시지를 출력한다.
- [x] 사용자로부터 값을 **<span style="color:red;">입력</span>** 받는다.


- [ ] 로또 숫자를 **<span style="color:green;">출력</span>** 한다.
- [ ] 로또 결과를 **<span style="color:green;">출력</span>** 한다.
- [ ] 로또 수익률을 **<span style="color:green;">출력</span>** 한다.

### 구입

- #### 구입 로직

    - [x] 입력 구매금액(문자열)을 받아 생성한다.
    - [x] <span style="color:red;">구매금액</span>, <span style="color:red;">구매횟수</span>를 가져야한다.
    - [x] 입력 구매금액(문자열)을 숫자로 변환한다.
        - [x] 입력 구매금액이 빈 문자열인경우 예외를 발생시킨다.
        - [x] 입력 구매금액이 숫자가 아닌 경우 예외를 발생시킨다.

    - [x] 구매금액을 통해 지정된 단위[1000원]를 기준으로 구매수량을 구한다.
    - [x] 변환된 구매금액이 1,000원 단위로 나누어 떨어지는지 검증한다.
        - [x] 나머지가 있는 경우 예외를 발생시킨다.
        - [x] 니머지가 0인 경우 몫을 반환한다.

- #### 구입 테스트

    - [x] 구매 금액이 숫자가 아닌 경우 예외 테스트
    - [x] 구매 금액이 빈 값인 경우 예외 테스트
    - [x] 구매 금액이 음수인 경우 예외 테스트
    - [x] 구매 금액이 1,000원 단위가 아닌 경우 예외 테스트
    - [x] 올바른 금액이 주어진 경우 올바른 횟수를 반환하는지 테스트
    - [x] 올바른 금액이 주어진 경우 올바른 구입금액를 반환하는지 테스트

### 랜덤숫자

- [x] `Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.
- [x] 1 ~ 45 범위내에서 6개의 숫자를 생성한다.

### 로또

#### 로직

- [x] 숫자 리스트를 가지고 생성된다.
- [x] 숫자 리스트를 검증한다.
    - [x] 숫자 리스트가 비어있는지
    - [x] 숫자가 6개인지
    - [x] 중복된 숫자가 있는지
- [x] 숫자 리스트를 반환하는 기능 구현

#### 로또 테스트

- [x] 빈 숫자 리스트가 주어진 경우 예외 발생 테스트
- [x] 숫자 리스트 중복 요소가 있는 경우 예외 발생 테스트
- [x] 숫자리스트의 크기가 6인지 테스트
- [x] 올바른 숫자 리스트가 주어진 경우 올바른 숫자 리스트를 반환하는지 테스트

### 로또목록

#### 구현

- [ ] 로또 수량을 가지고 생성된다.
- [ ] 로또 수량을 검증한다.
    - [ ] 로또 수량이 1이상인지
- [ ] 로또 목록을 가진다.
- [ ] 로또 수량만큼 로또를 생성한다.
    - [ ] 랜덤 숫자를 생성한다.
    - [ ] 랜덤 숫자로 로또를 생성한다.
- [ ] 생성된 로또를 로또 목록에 저장한다.

#### 로또 목록테스트

- [ ] 로또 수량이 1미만인 경우 예외 발생 테스트
- [ ] 올바른 수량이 주어진 경우 주어진 수량만큼의 로또를 생성하는지

### 당첨

- 필수: 사용자가 입력한 당첨번호(문자열), 로또목록
- 반환: 당첨번호 리스트(숫자형 리스트)
- 필요한 작업:
    - 변환(문자열 -> 숫자형 리스트)

### 보너스 번호

- 필수: 사용자가 입력한 보너스 번호(문자열)
- 반환: 숫자형 보너스 번호
- 필요한 작업:
    - 변환(문자열 -> 숫자형)
    - 검증

### 수익률

- 구매가격, 상금
- [ ] 
