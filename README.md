# kotlin-lotto-precourse

## 기능 요구 사항

---
간단한 로또 발매기를 구현한다.

- 로또 번호의 숫자 범위는 1~45까지이다.  
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.  
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.  
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.

>1등: 6개 번호 일치 / 2,000,000,000원  
2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원  
3등: 5개 번호 일치 / 1,500,000원  
4등: 4개 번호 일치 / 50,000원  
5등: 3개 번호 일치 / 5,000원
  
**로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.**  
- 로또 1장의 가격은 **1,000원**이다.  
- **당첨 번호**와 **보너스 번호**를 입력받는다.  
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 **당첨 내역** 및 **수익률**을 출력하고 로또 게임을 종료한다.  
- 사용자가 잘못된 값을 입력할 경우 **IllegalArgumentException**을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.  
  - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.  
---
## Flow
> 1. 구입 금액 입력
> 2. 로또 발행
> 3. 로또 구입 내역 출력
> 4. 당첨 번호 입력
> 5. 보너스 번호 입력
> 6. 로또 번호와 당첨 번호 비교
> 7. 당첨 통계
> 8. 수익률 계산 및 출력

## 기능 목록

### 로또
- [x] 로또 번호와 특정 번호 비교
- [x] 로또 번호 일치 개수 카운트
### 로또 판매자
- [x] 로또 발행
- [x] 로또 구매 개수 카운트
### 로또 결과 계산기
- [x] 로또 결과 계산
- [x] 로또 당첨 내역 통계
- [x] 로또 당첨금 계산
- [x] 수익률 계산

### InputPresenter
- [x] 구입 금액 입력 예외 처리
- [x] 로또 번호 입력 예외 처리
- [x] 보너스 번호 입력 예외 처리

### LottoPresenter
- [x] 로또 구매
- [x] 당첨 티켓 반환
- [x] 당첨 내역 계산
- [x] 당첨 내역 및 수익률 출력

### 입력 뷰
- [x] 구입 금액 입력
- [x] 로또 번호 입력
- [x] 당첨 번호 입력

### 출력 뷰
- [x] 로또 구매 내역 출력
- [x] 로또 당첨 내역 출력
- [x] 수익률 출력

### ApplicationFactory
- [x] LottoApplication 생성

### 검증자
***금액***
- [x] 금액이 1000원 미만인 경우
- [x] 금액이 1000원 단위가 아닌 경우
- [x] 금액이 숫자가 아닌 경우
- [x] 공백이 포함된 경우
- [x] 아무 금액을 입력하지 않은 경우
- [x] 최대 구입 가능 금액을 초과한 경우

***로또 번호***
- [x] 로또 번호가 1~45 범위를 벗어난 경우
- [x] 로또 번호가 6개가 아닌 경우
- [x] 로또 번호가 중복된 경우
- [x] 로또 번호가 숫자가 아닌 경우
- [x] 로또 번호에 공백이 포함된 경우
- [x] 아무 번호를 입력하지 않은 경우

---