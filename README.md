# kotlin-lotto-precourse

## 📖 프로젝트 개요
이 프로젝트는 콘솔을 통해 사용자에게 구매할 로또 개수, 당첨번호, 보너스 번호를
입력 받아 당첨자 순위와 수익률을 출력해주는 게임이다.

## 🔍 주요 기능
- 구입 금액을 입력한다.
- 중복되지 않는 로또번호 6개를 입력받는다.
- 보너스 번호 1개를 입력받는다.
- 구입금액 만큼 1-45 사이의 중복되지 않는 숫자 6개씩 당첨번호를 발행한다.
- 당첨번호는 개당 1000원이다.
- 입력한 로또번호와 발행된 당첨번호를 비교한다.
- 당첨내역을 출력한다.
- 수익률을 소수점 둘째짜리에서 반올림하여 출력한다.

## 🛠️ 기능구현 목록

### 당첨번호, 보너스번호
- 당첨번호를 리스트로 변환
- 보너스 번호를 정수로 변환

### 로또번호 리스트
- 입력 받은 금액만큼 로또번호 객체 생성


### 로또번호(Lotto)
- 당첨번호와 로또번호 비교 후 일치하는 개수 반환
- 5개의 번호가 일치하는 경우 보너스 번호가 남은 숫자와 일치하는지 판단

### 랜덤 숫자 생성
- 1-45 사이의 중복되지 않는 랜덤 숫자 6자리 발행

### 랭킹 (Enum class)
- 로또 번호와 당첨 금액을 정의하는 enum 클래스

### 결과
- 일치하는 개수와 보너스 번호의 일치여부를 통해 랭킹을 반환한다.
- 반환된 랭킹을 통해 수익률 추출한다.

### 예외처리
- 구입 금액이 양의 정수가 아닐 경우
- 구입 금액이 1000원 단위가 아닐 경우
- 입력 받은 당첨번호에 중복된 숫자가 있을 경우
- 입력 받은 당첨번호의 범위가 1-45를 넘을 경우
- 입력 받은 당첨번호가 양의 정수가 아닐 경우
- 입력 받은 보너스번호에 중복된 숫자가 있을 경우
- 입력 받은 보너스번호의 범위가 1-45를 넘을 경우
- 입력 받은 보너스번호가 양의 정수가 아닐 경우

### 사용자 화면
- 구입금액 입력 메시지를 출력한다.
- 당첨번호 입력 메시지를 출력한다.
- 보너스번호 입력 메시지를 출력한다.
- 발행한 로또수량에 맞는 로또번호를 출력한다.
- 당첨내역을 출력한다.
- 수익률을 출력한다.