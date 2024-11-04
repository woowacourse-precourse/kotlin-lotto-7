# kotlin-lotto-precourse

---

## 개요

원하는 금액만큼 무작위 번호로 로또 구매시 당첨통계와 총 수익률을 알려주는 프로그램입니다.

기존 로또와 같은 숫자범위로 설계됐으며 당첨조건과 당첨확률은 같습니다.

기존 로또의 1~3등 당첨금액은 변동이 있으나 해당 프로그램의 당첨금액은 고정값입니다.

참고용으로 이용하시기 바랍니다.

---

## 사용자 입력 사항

#### 1. 로또 구매 금액 입력하기

- 로또 1게임의 가격은 천원이며 천원단위로 입력합니다.
- 최대 입력 금액 (2,147,483,000원)

#### 2. 당첨번호 입력하기

- 숫자는 쉼표(,)로 구분하여 총 6개의 로또 범위안의 숫자를 입력합니다.

#### 3. 보너스번호 입력하기

- 1~45의 숫자 중 당첨번호 6개를 제외한 숫자를 1개 입력합니다.

---

## 기능 목록

- 진행 순서에 맞게 정렬
- 사용된 class 목록 ()안에 작성

#### 로또 구매한 금액 입력 (Input)

- Console API 사용

#### 금액 입력 오류 확인 (PurchaseAmountValidator)

- 오류시 해당되는 `Exception`이 발생하며 해당하는 "[ERROR]" 메시지 출력후 재입력
- 오류조건
    - 미입력 `IllegalArgumentException`
    - 숫자아닌 문자입력 `NumberFormatException`
    - 12자리 이상의 숫자 `IllegalArgumentException`
    - Int 최대값(2,147,483,647) 초과한 11자리 이하 숫자 `ArithmeticException`
    - 천원단위로 안떨어짐 (예: "5600") `IllegalArgumentException`

#### 구매한 로또 수만큼 무작위 생성 (RandomLottoGenerator)

- Randoms API 사용
- 구매한 로또 수량 출력
- 로또 번호 오름차순 정렬

#### 당첨번호 입력 (Input)

- Console API 사용
- 쉼표(,)로 숫자 구분

#### 당첨번호 입력 오류 확인 (WinningNumberValidator)

- 오류시 해당되는 `Exception`이 발생하며 해당하는 "[ERROR]" 메시지 출력후 재입력
- 오류조건
    - 미입력 `IllegalArgumentException`
    - 구분자가 아닌 문자 입력 `NumberFormatException`
    - 0또는 46이상의 숫자 입력 `IllegalArgumentException`
    - 6개 번호 미입력 `IllegalArgumentException`
    - 숫자 중복 입력 `IllegalArgumentException`

#### 보너스 번호 입력 (Input)

- Console API 사용

#### 보너스 번호 입력 오류 확인 (BonusNumberValidator)

- 오류시 해당되는 `Exception`이 발생하며 해당하는 "[ERROR]" 메시지 출력후 재입력
- 오류조건
    - 미입력 `IllegalArgumentException`
    - 숫자아닌 문자입력 `NumberFormatException`
    - 0 또는 46이상 숫자입력 `IllegalArgumentException`
    - 당첨 번호 입력 `IllegalArgumentException`

#### 구매한 로또, 당첨 번호, 보너스 번호 데이터 캡슐화(RandomLotto, Lotto, Bonus)

- 맞춘 번호 개수에 따라 분류

#### 당첨결과 갱신을 위한 enum class 사용 (WinningCount)

- 당첨시 등수에 맞게 당첨수 갱신

#### 로또 분석 (LottoAnalyzer)

- 당첨여부 및 수익률 계산

#### 당첨 통계 및 수익률 출력 (Output)

- 등수 마다 당첨금 및 당첨수 출력
- 총 수익률 출력 (수익률은 소수점 둘째 자리 반올림 (ex. 150.55% -> 150.6%)

#### 로또 실행기 (Application, LottoController)

- 실행 및 제어

#### 기타사항

- 이 외 클래스
    - SettingValue: Input, OutPut 에서 사용하는 출력값을 제외한 고정된 설정값 모음
    - ErrorMessage: 고정된 오류 메시지 모음

#### 수익률 (출처: [네이버 지식백과](https://terms.naver.com/entry.naver?docId=1918326&cid=50304&categoryId=50304))

기업 · 재무나 증권투자 등에서, 투자액에 대한 수익의 비율

일반적으로 일정기간의 최초의 투자 원금에 대한 수익의 비율로 나타냄

#### 수익률 계산

프로젝트에 설명된 예시에 맞게 계산하였다. 

사용된 계산법 : (최종 수익 / 투자 금액 ) × 100

올바른 계산법 : ((최종 수익 - 투자 금액) / 투자 금액 ) × 100