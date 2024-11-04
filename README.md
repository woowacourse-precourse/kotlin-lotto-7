# kotlin-lotto-precourse

### 사용자 모델

- 구매비용을 검증하는 기능을 통해 구매비용의 예외를 처리한다
- 돈을 통해 로또들을 구매한다
- 로또들의 복사본을 반환한다(초기화 이전에 반활 할때 상태 에러 호출)

### 로또 모델

- 로또 번호들을 검증하는 기능을 통해 로또 번호들의 예외를 처리한다
- 로또 번호들의 복사본을 반환한다

### 당첨 번호들 모델

- 당첨 번호들을 검증하는 기능을 통해 당첨 번호들의 예외를 처리한다
- 당첨 번호들의 복사본을 반환한다

### 보너스 숫자 모델

- 보너스 번호를 검증하는 기능을 통해 예외를 처리한다

### 구매비용 예외 처리

- 돈이 1000원 단위로 나누어 떨어지지 않는다면 예외 발생
- 돈이 1000원 보다 작을 경우 예외 발생

### 로또 숫자들 예외 처리

- 로또 번호들이 6개가 아닐 경우 예외가 발생
- 로또 번호의 숫자 범위가 1~45까지가 아닐 경우 예외 발생
- 로또 번호에 중복이 있을 경우 예외 발생
- 로또 번호들이 오름차순이 아닐 경우 예외 발생

### 보너스 숫자들 예외처리

- 보너스 번호의 숫자 범위가 1~45까지가 아닐 경우 예외 발생
- 보너스 번호의 숫자가 당첨 번호와 중복이 있을 경우 예외 발생

### 로또의 등수를 계산

- 로또의 등수를 계산한다

### 로또의 수익률 계산

- 로또의 수익률을 계산한다

### 보너스 숫자 객체를 생성

- 사용자에게 입력 받은 함수의 반환값을 보너스 숫자로 변환한다
- 보너스 숫자를 생성할때 예외가 발생한다면 에러 메세지를 출력하고
  사용자에게 입력 받는 함수를 반복한다

### 로또 객체를 생성

- 1~45의 수를 6개 가진 로또 숫자들을 생성한다
- 로또 숫자들을 통해 로또를 생성해서 반환한다

### 사용자 객체를 생성

- 사용자에게 입력 받은 함수의 반환값을 구매비용으로 변환한다
- 구매비용으로 사용자를 생성할때 예외가 발생한다면 에러 메세지를 출력하고
  사용자에게 입력 받는 함수를 반복한다

### 당첨 숫자들 객체를 생성

- 사용자에게 입력 받은 함수의 반환값을 당첨 번호들로 변환한다
- 당첨 번호들로 당첨 번호들 객체를 생성할때 예외가 발생한다면 에러 메세지를 출력하고
  사용자에게 입력 받는 함수를 반복한다

### 문자열을 확장하는 기능을 가진 파일

- 문자열을 숫자로 변환하고 실패시 예외를 발생시킨다

### 로또의 순위 정보를 가진 열거형 객체

- 로또의 랭킹을 열거형으로 가진다

### 상수 선언 파일

- 앱의 전반에 사용할 상수를 가진다.

### 도메인 객체를 인스턴스화 해서 상태로 가지는 객체

- 의존성 주입을 받는 도메인 UseCase들을 상태로 가지고 사용할때 생성해서 반환한다.

### 로또 구매에 필요한 화면을 구성

- 구입금액을 안내 한다
- 구입금액을 입력 받는다
- 구매 개수를 안내 한다
- 구매한 로또의 번호를 출력한다

### 당첨 번호의 정보들을 입력 받는 화면을 구성

- 당첨 번호를 입력 받는다
- 보너스 번호를 입력 받는다

### 로또의 결과를 출력 하는 화면을 구성

- 당첨 통계를 반환한다
- 총 수익률을 반환한다

### 앱의 전체 흐름을 관리하고 실행

앱의 전체 흐름을 관리한다

- 사용자에게 안내문을 출력하고 구매비용을 입력 받는다
- 사용자가 로또 티켓을 구매한다
- 구매한 로또의 정보를 안내한다
- 당첨 번호들을 입력 받는다
- 보너스 숫자를 입력 받는다
- 당첨된 로또들의 개수를 안내한다
- 로또의 총 수익률을 반환한다