# kotlin-lotto-precourse

# 기능 구현 목록

- [x] 로또를 발행한다.
    - [x] 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
    - [x] 오름차순으로 정렬한다.

- [x] 로또가 알맞은 형식인지 검사한다.
    - [x] [예외] 1~45사이의 숫자가 아닌 경우.
    - [x] [예외] 숫자가 중복인 경우.
    - [x] [예외] 6개의 숫자가 아닌 경우.
    - [x] [예외] 오름차순이 아닌 경우.

- [x] 구입 금액에 해당하는 만큼 로또를 발행한다.
- [x] 로또 1장의 가격은 1,000원이다.

- [x] 로또 구입 금액을 입력받는다.
    - [x] [예외] 가격이 숫자가 아닌 경우.
    - [x] [예외] 가격이 1000원 미만인 경우.

- [x] 당첨 번호를 입력받는다.
    - [x] [예외] 문자인 경우.
    - [x] [예외] 1~45사이의 숫자가 아닌 경우.
    - [x] [예외] 숫자가 중복인 경우.
    - [x] [예외] 6개의 숫자가 아닌 경우.

- [x] 보너스 번호를 입력받는다.
    - [x] [예외] 가격이 숫자가 아닌 경우.
    - [x] [예외] 1~45사이의 숫자가 아닌 경우.
    - [x] [예외] 당첨번호와 중복될 경우

- [x] 당첨 여부를 비교한다.

```
  - 1등: 6개 번호 일치 / 2,000,000,000원
  - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
  - 3등: 5개 번호 일치 / 1,500,000원
  - 4등: 4개 번호 일치 / 50,000원
  - 5등: 3개 번호 일치 / 5,000원
```

- [x] 사용자가 구매한 로또 번호와 당첨 번호를 비교한다.
    - [x] 당첨 내역을 구한다.

- [x] 수익률을 구한다.

- [x] 사용자가 잘못된 값을 입력할 경우
    - [x] `IllegalArgumentException`을 발생시킨다.
    - [x] "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - [x] `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

# 입출력 요구 사항

## 입력

- 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.

`14000`

- 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.

`1,2,3,4,5,6`

- 보너스 번호를 입력 받는다.

`7`

## 출력

- 발행한 로또 수량 및 번호를 출력한다.
    - 로또 번호는 오름차순으로 정렬하여 보여준다.

```
8개를 구매했습니다.
 [8, 21, 23, 41, 42, 43]
 [3, 5, 11, 16, 32, 38]
 [7, 11, 16, 35, 36, 44]
 [1, 8, 11, 31, 41, 42]
 [13, 14, 16, 38, 42, 45]
 [7, 11, 30, 40, 42, 43]
 [2, 13, 22, 32, 38, 45]
 [1, 3, 5, 14, 22, 45]
```                

- 당첨 내역을 출력한다.

```
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
```

- 수익률을 출력한다.
    - 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
    - `총 수익률은 62.5%입니다.`

- 예외 상황 시 에러 문구를 출력해야 한다.
    - 단, 에러 문구는 "[ERROR]"로 시작해야 한다.
      `[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.`

# 프로그래밍 요구 사항 1

- Kotlin 1.9.24에서 실행 가능해야 한다.
- Java 코드가 아닌 Kotlin 코드로만 구현해야 한다.
- 프로그램 실행의 시작점은 Application의 main()이다.
- build.gradle.kts 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 System.exit() 또는 exitProcess()를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 코틀린 코드 컨벤션을 지키면서 프로그래밍한다.
- 기본적으로 Kotlin Style Guide를 원칙으로 한다.

## 프로그래밍 요구 사항 2

- [x] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- [x] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.

- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
    - 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
  ```
    JUnit 5 User Guide
    AssertJ User Guide
    AssertJ Exception Assertions
    Guide to JUnit 5 Parameterized Tests
  ```

## 프로그래밍 요구 사항 3

- [x] 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- [x] 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- [x] else를 지양한다.
    - 때로는 if/else, when문을 사용하는 것이 더 깔끔해 보일 수 있다. 어느 경우에 쓰는 것이 적절할지 스스로 고민해 본다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
- [x] Enum 클래스를 적용하여 프로그램을 구현한다.
- [x] 구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
    - 단위 테스트 작성이 익숙하지 않다면 LottoTest를 참고하여 학습한 후 테스트를 작성한다.

# 피드백

- [x] 기능 목록을 재검토한다.
    - [x] 기능 목록을 작성할 때 클래스 설계와 구현, 메서드 설계와 구현 등은 포함하지 않는다.
    - [x] 예외상황도 함께 정리한다.
- [x] 기능 목록을 업데이트한다. 기능을 구현하면서 문서를 지속적으로 업데이트한다.
- [X] **문자열이나 숫자 값을 하드 코딩하지 않는다. 상수를 정의하고 의미있는 이름을 부여하여 해당 값이 어떤 역할을 하는지 명확히 드러낸다.**
- [x] 구현 순서도 코딩 컨벤션이다.
    - [x] 프로퍼티, init블록, 부 생성자, 메서드, 동반 객체 순으로 작성한다.
- [x] 변수 이름에 자료형은 사용하지 않는다. 변수 이름은 의미를 명확히 드러낼 수 있도록 한다.
- [ ] 테스트를 작성하는 이유에 대해 본인의 경험을 토대로 정리해본다. (회고때 포함)
    - [ ] 테스트 작성 과정을 통해 구현한 기능의 문제를 빠르게 발견할 수 있을 뿐만 아니라, 코드의 구조와 의도를 명확히 이해하는 데도 도움을 받을 수 있다. 학습 도구로도 활용할 수 있는데, 수 많은
      테스트의 장점 중 본인이 가장 공감하는 작성 이유를 작성해 본다.
- [x] 처음부터 큰 단위 테스트를 만들지 않는다. → 테스트 주도 개발을 하자
    - [x] 작은 단위 테스트 : 무작위 값이 4 이상이면 자동차가 전진한다.
    - [x] 큰 단위 테스트 : 자동차 경주 게임을 시작하여, 사용자가 이름과 진행횟수를 입력하고, 게임을진행한 후 결과를 확인한다.