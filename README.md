# 🔖 우아한테크코스 7기 3주차 프리코스 - 로또 프로그램

***

## 📃 Info
- 간단한 로또 발매기를 구현하기.

***

## 🛠️ Funtion
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
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다. 
  - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

***

## 📁 Structure
```bash
lotto/
├── Controller/
│   ├── CalculateResults.kt
│   └── LottoController.kt
├── Model/
│   ├── Lotto.kt
│   └── Prize.kt
├── View/
│   ├── InputBonusNumber.kt
│   ├── InputPurchaseAmount.kt
│   ├── InputWinningNumbers.kt
│   ├── PrintLottoInfo.kt
│   └── PrintResults.kt
└── Application.kt
```

***

## ✨ Implement
- **Model**
    1. `Lotto.kt`: 로또 번호를 나타내는 클래스, 유효성 검사를 통해 제대로 된 로또 번호만 생성
       - numbers 리스트를 인자로 받아 로또 번호 초기화
       - 유효성 검사: 번호의 개수가 6개인지, 번호가 1부터 45 사이인지, 중복이 없는지
       - getNumbers 메서드: 로또 번호 정렬 후 반환
    2. `Prize.kt`: 각 당첨 등수를 정의하는 enum class
       - 각 상금의 매칭 개수와 보너스 여부&상금 금액 저장
       - getPrize 메서드: 당첨 번호 개수와 보너스 번호 여부에 따라 적절한 상금 반환
       - getPrizesToPrint 메서드:  3개 이상의 번호가 일치하는 상금들만 필터링하여 반환, 화면에 출력할 상금 정렬
- **View**
    1. `InputBonusNumber.kt`: 보너스 번호를 입력받는 함수
       - inputBonusNumber 함수: 사용자에게 보너스 번호 입력 요청, 입력된 값의 유효성 검사 후 반환
       - readAndValidateBonusNumber 함수: 보너스 번호가 1~45 사이의 정수인지 확인, 잘못된 입력 시 에러 메시지를 출력&재입력
    2. `InputPurchaseAmount.kt`: 로또 구매 금액을 입력받는 함수
       - inputPurchaseAmount 함수: 사용자에게 구매 금액 입력 요청, 입력된 값의 유효성 검사 후 반환
       - readAndValidateAmount 함수: 구매 금액이 1000원 이상이며 1000원 단위인지 확인, 잘못된 입력 시 에러 메시지를 출력&재입력
    3. `InputWinningNumbers.kt`: 당첨 번호 6개를 입력받는 함수
       - inputWinningNumbers 함수: 사용자에게 당첨 번호 입력 요청, 입력값의 유효성 검사 후 반환
       - readAndValidateNumbers 함수: 입력된 당첨 번호가 6개이며 각 번호가 1~45 사이인지 확인, 잘못된 입력 시 에러 메시지를 출력&재입력
    4. `PrintLottoInfo.kt`: 구매한 로또 티켓 개수&번호 목록을 출력하는 함수, 구매한 모든 로또 티켓 번호를 콘솔에 출력.
    5. `PrintResults.kt`: 당첨 결과&수익률을 출력하는 함수
       - resultPrinter 함수: 당첨 개수, 상금, 보너스 여부를 포맷팅하여 출력
- **Controller**
    1. `CalculateResults.kt`: 로또 결과를 계산하는 함수
       - 구매한 로또 목록과 당첨 번호, 보너스 번호를 받아 각 로또의 당첨 결과 계산
       - 등수별 당첨 횟수: Map<Prize, Int> 형태로 반환
       - Prize.getPrize 함수: 매칭 개수와 보너스 일치 여부에 따라 해당 로또의 당첨 등수를 구함
    2. `LottoController.kt`: 로또 프로그램 전체 흐름 관리 클래스
       - run 함수: 구매 금액 입력-로또 발행-로또 정보 출력-당첨 번호 입력-결과 계산&출력
       - generateLottos 함수: 주어진 개수만큼 로또를 생성하는 함수
       - calculateProfitRate 함수: 총 당첨 금액을 기반으로 수익률을 계산하는 함수, purchaseAmount로 나눈 후 퍼센트 형태로 수익률 반환

***

## 💥 Exception
- `LottoTest.kt`
  - 로또 번호 개수가 6개 이상/이하일 경우
  - 중복된 로또 번호
  - 로또 번호 오류(1~45의 값이 아닌 경우)
  - 로또 번호가 음수인 경우
- `View.InputBonusNumber.kt`
  - 보너스 번호가 숫자가 아닐 경우
  - 입력된 보너스 번호가 1에서 45 사이의 숫자가 아닌 경우
- `View.InputPurchaseAmount.kt`
  - 구매 금액이 숫자로 입력되지 않았을 경우
  - 입력된 금액이 1000원 이상이고 1000원 단위가 아닐 경우
- `View.InputWinningNumbers.kt`
  - 당첨 번호가 숫자가 아닌 값으로 입력되었을 경우
  - 입력된 번호 개수가 6개가 아닌 경우
  - 중복 번호가 있는 경우
  - 번호가 1에서 45 사이의 숫자가 아닐 경우

***

## 📺 View
- Input
  - 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
    > 1400
  - 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
    > 1,2,3,4,5,6
  - 보너스 번호를 입력 받는다.
    > 7

- OutPut
  - 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.
    > 8개를 구매했습니다.
    > 
    > [8, 21, 23, 41, 42, 43]
    > 
    > [3, 5, 11, 16, 32, 38]
    > 
    > [7, 11, 16, 35, 36, 44]
    > 
    > [1, 8, 11, 31, 41, 42]
    > 
    > [13, 14, 16, 38, 42, 45]
    > 
    > [7, 11, 30, 40, 42, 43]
    > 
    > [2, 13, 22, 32, 38, 45]
    > 
    > [1, 3, 5, 14, 22, 45]
  - 당첨 내역을 출력한다.
    > 3개 일치 (5,000원) - 1개
    > 
    > 4개 일치 (50,000원) - 0개
    > 
    > 5개 일치 (1,500,000원) - 0개
    > 
    > 5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    > 
    > 6개 일치 (2,000,000,000원) - 0개
  - 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
    > 총 수익률은 62.5%입니다.
  - 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.
    > [ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.

- 실제 코드 구현
  - 정상 작동 시
    > ![](https://velog.velcdn.com/images/seoyoun8694/post/91ce28ad-6a98-44cd-81e9-ba6a6c1ca81e/image.jpg)

  - 구입 금액 오류
    > ![](https://velog.velcdn.com/images/seoyoun8694/post/4c2851ef-689a-40a5-8d12-8b9d90db4b31/image.jpg)

  - 당첨 번호 오류
    > ![](https://velog.velcdn.com/images/seoyoun8694/post/96c4ccb1-1428-47ce-91bf-270210a65f23/image.jpg)

  - 보너스 번호 오류
    > ![](https://velog.velcdn.com/images/seoyoun8694/post/24ca9e59-3677-4baa-9a88-f5f0ab4da795/image.jpg)

***

## ⚙️ Requirements
- Kotlin 1.9.24에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 `Application`의 `main()`이다`.
- `build.gradle.kts` 파일은 변경할 수 없으며, **제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.**
- 프로그램 종료 시 `System.exit()` 또는 `exitProcess()`를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 코틀린 코드 컨벤션을 지키면서 프로그래밍한다.
- 기본적으로 Kotlin Style Guide를 원칙으로 한다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- else를 지양한다.
- Enum 클래스를 적용하여 프로그램을 구현한다.
- 구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다

***

## 📘 Library
- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
  - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

***

## 🔗 Velog
- https://velog.io/@seoyoun8694/%EC%9A%B0%ED%85%8C%EC%BD%94-7%EA%B8%B0-3%EC%A3%BC%EC%B0%A8-%ED%94%84%EB%A6%AC%EC%BD%94%EC%8A%A4-%ED%9A%8C%EA%B3%A0