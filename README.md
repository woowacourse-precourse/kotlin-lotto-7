# kotlin-lotto-precourse

### 로또 발매기 로직

**1. 구입 금액으로 발행할 수 있는 로또의 개수를 계산한다.**

**2. 개수만큼 로또를 발행한다.**

**3. 발행한 로또 번호를 당첨 번호, 보너스 번호와 비교한다.**

**4. 일치하는 번호의 개수에 따라 당첨 여부를 판단하고 총 수익률을 계산한다.**

### 입력

- **구입 금액**
  - [x] 1,000원 단위로 입력해야 한다.
  - [x] 1,000원 이상이어야 한다.
  - [x] 숫자만 입력해야 한다.
- **당첨 번호**
  - [x] 1~45 범위에서 6개를 입력해야 한다.
  - [x] 당첨 번호 6개가 중복되지 않아야 한다.
  - [x] 쉼표(,)를 기준으로 구분해서 입력해야 한다.
  - [x] 숫자와 쉼표(,)만 입력해야 한다.
- **보너스 번호**
  - [x] 1~45 범위에서 1개를 입력해야 한다.
  - [x] 당첨 번호와 중복되지 않아야 한다.
  - [x] 숫자만 입력해야 한다.

### 출력

- **발행한 로또의 수량 및 번호**
  - [x] 번호는 오름차순으로 정렬한다.
- **당첨 통계 및 수익률**
  - [x] 수익률은 소수점 둘째 자리에서 반올림한다.
- **예외 상황, 에러 메시지**
  - [x] 에러 문구는 `[ERROR]`로 시작해야 한다.