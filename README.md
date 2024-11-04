# kotlin-lotto-precourse
## ☑️ 기능 구현 목록

*MVC 패턴을 이용하여 구현하였습니다.

### [입력]

### 구입 금액 입력

- 사용자가 로또를 구입할 금액을 입력받는다.
- 유효한 구매 금액이 아닐 시 Exception을 발생 시킨다.
    - 입력이 비어있는 경우 IllegalStateException 발생
    - 입력 숫자 아닌 경우 **`IllegalArgumentException`** 발생
    - 입력 0, 00 ,000 등 0인 경우 IllegalArgumentException 발생
    - 입력 소수인 경우 **`IllegalArgumentException` 발생**
    - 입력 음수인 경우 **`IllegalArgumentException` 발생**
    - 입력 Int 범위 초과하는 경우 **`IllegalArgumentException` 발생**
    - 입력이 1000 단위가 아닐 경우 **`IllegalArgumentException` 발생**

### 당첨 번호 입력

- 로또 당첨 번호 6개를 , 기준으로 입력 받는다.
- 유효한 당첨 번호가 아닐 시 Exception을 발생 시킨다.
    - 입력이 빈 경우 **`IllegalStateException`** 발생
    - 입력 번호를 쉼표로 구분하지 않는 경우 **`IllegalArgumentException` 발생**
    - 입력이 숫자가 아닌 경우 **`IllegalArgumentException` 발생**
    - 입력 번호가 1 ~ 45 범위가 아닌 경우 **`IllegalArgumentException` 발생**
    - 입력 번호가 6개가 아닌 경우 **`IllegalArgumentException` 발생**
    - 입력 번호 중 중복이 있을 경우 **`IllegalArgumentException` 발생**

### 보너스 번호 입력

- 보너스 번호 1개를 입력 받는다.
- 유효한 보너스 번호가 아닐 시 Exception을 발생 시킨다.
    - 입력이 빈 경우 **`IllegalStateException`** 발생
    - 입력이 숫자가 아닌 경우 **`IllegalArgumentException` 발생**
    - 입력 번호가 1 ~ 45 범위가 아닌 경우 **`IllegalArgumentException` 발생**
    - 입력 번호가 당첨 번호와 중복되는 번호가 있는 경우 **`IllegalArgumentException` 발생**

### [로또]

### 사용자 로또 번호 발행

- 구입한 로또 금액 만큼 (1000원에 1장) 사용자의 로또 번호를 랜덤으로 발행해준다.
    - 1장에 1 ~ 45 범위의 숫자 6개를 중복 없이 발행한다.
    - 로또 번호가 6개가 아닐 시 **`IllegalArgumentException` 발생**
    - 로또 번호 중 중복되는 번호가 있을 시 **`IllegalArgumentException` 발생**

### 사용자 로또 번호와 당첨 번호 비교

- 구입한 로또 번호들과 당첨 번호를 비교한다.
    - 구입한 로또와 당첨 번호가 일치하는 횟수를 확인한다.
    - 구입한 로또와 보너스 번호가 일치하는지 여부를 확인한다.
    - 구입 번호와 당첨 번호가 5개 일치 할 시 보너스 번호의 일치 여부에 따라 등수를 달리한다.
        - 5개 번호 일치 = 3등
        - 5개 번호 일치 + 보너스 번호 일치 = 2등

### 사용자 수익률 계산

- 사용자의 로또 수익률을 계산한다.
    - (수익 금액 / 구입 금액 ) * 100 의 식으로 계산한다.

### [출력]

### 발행 로또 수량 번호 출력

- 발행 로또 수량 및 번호를 출력한다.
    - (구입 금액 / 1000) 으로 계산한 발행 로또 수량을 출력한다.
    - 발행한 로또 1장당 오름차순으로 6개 번호를 출력한다.

### 당첨 통계 출력

- 당첨 내역을 출력한다.
    - 구입한 모든 로또에서 당첨 번호와 일치하는 횟수를 출력한다.

### 수익률 출력

- 총 수익률을 출력한다.
    - 총 수익률은 소수점 둘째 자리에서 반올림 하여 출력한다.

### 예외 출력

- Exception이 발생할 시 [Error]와 함께 에러 문구를 출력한다.
