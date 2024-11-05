## 기능 요구 사항
**간단한 로또 발매기를 구현한다.**

* 로또 번호의 숫자 범위는 1~45까지이다.
* 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
* 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
* 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
  * 1등: 6개 번호 일치 / 2,000,000,000원
  * 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
  * 3등: 5개 번호 일치 / 1,500,000원
  * 4등: 4개 번호 일치 / 50,000원
  * 5등: 3개 번호 일치 / 5,000원
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
* 로또 1장의 가격은 1,000원이다.
* 당첨 번호와 보너스 번호를 입력받는다.
* 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
* 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  * Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.


## 기능 구현 목록
* 입력
  * [x] 당첨 번호
    * 6개 입력
  * [x] 보너스 번호
    * 1개 입력
  * [x] 구매 금액
    * 1000 단위 입력
* 로또 발행 
  * [x] 생성 - 6개 번호를 저장
  * [x] 랜덤 번호 6개 생성 (1~45 중 6개)
* 당첨 통계
  * [x] 각 로또 번호와 당첨 번호 비교
  * [x] 당첨 내역 계산
    * 1등: 6개 번호 일치 / 2,000,000,000원
    * 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    * 3등: 5개 번호 일치 / 1,500,000원
    * 4등: 4개 번호 일치 / 50,000원
    * 5등: 3개 번호 일치 / 5,000원
  * [x] 수익률 계산
* 출력
  * [x] 당첨 내역 출력
  * [x] 수익률 출력
  * [x] 구매 금액 입력 출력
  * [x] 구매 내역 출력
  * [x] 당첨 번호 입력 출력
  * [x] 보너스 번호 입력 출력
  * [x] 구매 로또 번호 출력
* 잘못된 값 입력 - `IllegalArgumentException`
  * [x] 당첨과 보너스 중복
  * [x] 구매 금액 1000 단위 x
  * [x] 구매 금액 숫자 아님
  * [x] 구매 금액 0
  * [x] 보너스 번호 범위
  * [x] 당첨 번호 범위
  * [x] 당첨 번호 입력 형식
  * [x] 보너스 번호 숫자 아님

## class diagram
#### 코딩 전
<a href="https://ibb.co/z5LqwxK"><img src="https://i.ibb.co/GJ1zjpg/lotto-drawio-1.png" alt="lotto-drawio-1" border="0"></a><br /><a target='_blank' href='https://dedupelist.com/'>find duplicate lines</a><br />

#### 코딩 후
<a href="https://ibb.co/DtDSt28"><img src="https://i.ibb.co/SPX9PCd/package.png" alt="package" border="0"></a>