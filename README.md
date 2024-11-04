# kotlin-lotto-precourse

## 목표

### 학습 목표

- 여러 역할을 수행하는 큰 함수를 단일 역할을 수행하는 작은 함수로 분리한다.
- 테스트 도구를 사용하는 방법을 배우고 프로그램이 제대로 작동하는지 테스트한다.
- 2주 차 공통 피드백을 최대한 반영한다.

## 프리코스 진행 방식

### 진행 방식

- 미션은 과제 진행 요구 사항, 기능 요구 사항, 프로그래밍 요구 사항 세 가지로 구성되어 있다.
- 세 개의 요구 사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만들고, 기능 단위로 커밋 하는 방식으로 진행한다.
- 기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.
- 매주 진행할 미션은 화요일 오후 3시부터 확인할 수 있으며, 다음 주 월요일까지 구현을 완료하여 제출해야 한다. 제출은 일요일 오후 3시부터 가능하다.
    - 정해진 시간을 지키지 않을 경우 미션을 제출하지 않은 것으로 간주한다.
    - 종료 일시 이후에는 추가 푸시를 허용하지 않는다.

### 미션 제출 방법

- 미션 구현을 완료한 후 GitHub을 통해 제출해야 한다.
    - GitHub을 활용한 제출 방법은 프리코스 과제 제출 문서를 참고해 제출한다.
- GitHub에 미션을 제출한 후 우아한테크코스 지원 플랫폼에 PR 링크를 포함하여 최종 제출한다.
    - 자세한 안내는 제출 가이드를 참고한다.
    - 과제를 수행하면서 느낀 점, 배운 점, 많은 시간을 투자한 부분 등 자유롭게 작성한다.

### 과제 제출 전 체크 리스트

- 기능을 올바르게 구현했더라도 요구 사항에 명시된 출력 형식을 따르지 않으면 0점을 받게 된다.
- 기능 구현을 완료한 후 아래 가이드에 따라 모든 테스트가 성공적으로 실행되는지 확인한다.
- 테스트가 실패하면 점수가 0점이 되므로 제출하기 전에 반드시 확인한다.

#### 테스트 실행 가이드

- IntelliJ IDEA 또는 Android Studio와 같은 IDE에서 Kotlin 1.9.24로 실행되는지 확인한다.
- 터미널에서 Mac 또는 Linux 사용자의 경우 `./gradlew clean test` 명령을 실행하고, Windows 사용자의
  경우 `gradlew.bat clean test` 또는
  `.\gradlew.bat clean test` 명령을 실행할 때 모든 테스트가 아래와 같이 통과하는지 확인한다.
  ```BUILD SUCCESSFUL in 0s```

# 로또

## 과제 진행 요구 사항

- 미션은 로또 저장소를 포크하고 클론하는 것으로 시작한다.
- 기능을 구현하기 전 `README.md`에 구현할 기능 목록을 정리해 추가한다.
- Git의 커밋 단위는 앞 단계에서 `README.md`에 정리한 기능 목록 단위로 추가한다.
    - AngularJS Git Commit Message Conventions을 참고해 커밋 메시지를 작성한다.
- 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고한다.

## 기능 요구 사항

간단한 로또 발매기를 구현한다.

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
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시
  받는다.
    - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

### 입출력 요구 사항

#### 입력

- 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
  ```14000```
- 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
  ```1,2,3,4,5,6```
- 보너스 번호를 입력 받는다.
  ```7```

#### 출력

- 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.

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

- 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
  ```총 수익률은 62.5%입니다.```
- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.
  ```[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.```

#### 실행 결과 예시

```
구입금액을 입력해 주세요.
8000

8개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[1, 3, 5, 14, 22, 45]

당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```

## 프로그래밍 요구 사항 1

- Kotlin 1.9.24에서 실행 가능해야 한다.
- Java 코드가 아닌 Kotlin 코드로만 구현해야 한다.
- 프로그램 실행의 시작점은 Application의 main()이다.
- build.gradle.kts 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 System.exit() 또는 exitProcess()를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 코틀린 코드 컨벤션을 지키면서 프로그래밍한다.
    - 기본적으로 Kotlin Style Guide를 원칙으로 한다.

## 프로그래밍 요구 사항 2

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
    - 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
        - JUnit 5 User Guide
        - AssertJ User Guide
        - AssertJ Exception Assertions
        - Guide to JUnit 5 Parameterized Tests

## 프로그래밍 요구 사항 3

- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- else를 지양한다.
    - 때로는 if/else, when문을 사용하는 것이 더 깔끔해 보일 수 있다. 어느 경우에 쓰는 것이 적절할지 스스로 고민해 본다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
- Enum 클래스를 적용하여 프로그램을 구현한다.
- 구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
    - 단위 테스트 작성이 익숙하지 않다면 `LottoTest`를 참고하여 학습한 후 테스트를 작성한다.

### 라이브러리

- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

#### 사용 예시

- 1에서 45 사이의 중복되지 않은 정수 6개 반환
  ```Randoms.pickUniqueNumbersInRange(1, 45, 6)```

### Lotto 클래스

- 제공된 `Lotto` 클래스를 사용하여 구현해야 한다.
- `Lotto`에 `numbers` 이외의 필드(인스턴스 변수)를 추가할 수 없다.
- `numbers`의 접근 제어자인 `private`은 변경할 수 없다.
- `Lotto`의 패키지를 변경할 수 있다.

```
package lotto

class Lotto(private val numbers: List<Int>) {
init {
require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
}

    // TODO: 추가 기능 구현

}
```

# 기능 목록

- [x] "구입금액을 입력해 주세요."를 출력하는 함수
- [x] 로또 구입 금액을 입력 받는 함수
- [x] 입력 받은 구입 금액을 검증하는 함수
    - [x] 1,000단위로 나누어 떨어지지 않으면 예외 "[ERROR] 구입 금액은 1,000원 단위 이상이어야 합니다."를 출력
    - [x] 숫자가 아닌 문자를 입력하면 예외 "[ERROR] 구매 가격은 숫자여야 합니다."를 출력
    - [x] 100,000만원 이상 입력하면 예외 "[ERROR] 1인 최대 구매 금액은 100,000원입니다."를 출력
    - [x] 출력 후 다시 입력 받는다.


- [x] 로또 수량을 계산하는 함수
- [x] 로또 수량을 출력하는 함수
    - [x] "X개를 구매했습니다."를 출력


- [x] 로또 번호를 추첨하는 함수
- [x] 로또 번호를 오름차순으로 정렬하는 함수
- [x] 로또 번호를 출력하는 함수
    - [x] "[1, 3, 5, 14, 22, 45]"를 출력


- [x] "당첨 번호를 입력해 주세요."를 출력하는 함수
- [x] 당첨 번호를 입력 받는 함수
- [x] 입력 받은 당첨 번호를 콤마로 구분하는 함수
- [x] 입력 받은 당첨 번호를 검증하는 함수
    - [x] 입력 받은 번호가 1~45 사이인가? "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다." 출력
    - [x] 입력 받은 번호의 개수가 6개인가? "[ERROR] 로또 번호는 6개여야 합니다." 출력
    - [x] 중복된 숫자가 없는가? "[ERROR] 로또 번호는 중복되지 않아야 합니다." 출력
    - [x] 숫자만 입력하였는가? "[ERROR] 로또 번호는 숫자여야 합니다." 출력
    - [x] 출력 후 다시 입력 받는다


- [x] "보너스 번호를 입력해 주세요."를 출력하는 함수
- [x] 보너스 번호를 입력 받는 함수
- [x] 입력 받은 보너스 번호를 검증하는 함수
    - [x] 입력 받은 번호가 1~45 사이인가? "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."
    - [x] 당첨 번호와 중복되지 않는가? "[ERROR] 보너스 번호와 로또 번호는 같을 수 없습니다."
    - [x] 하나의 숫자만 입력하였는가? "[ERROR] 보너스 번호는 숫자이며 하나여야 합니다." 출력
    - [x] 예외 처리 시 다시 입력 받는 함수 호출


- [x] 로또 당첨을 확인하는 함수
    - 보너스 번호도 로또 당첨 번호에 포함하는가? -> No, 실제 로또에서는 6개의 번호를 기준으로 당첨 여부를 확인한다.
    - 보너스 번호는 3등과 1등의 확률의 격차가 크기 때문에 그 격차를 줄이고자 도입한 것이다.
- [x] 5개 번호가 일치할 때 보너스 번호 당첨을 확인하는 함수


- [x] "당첨 통계"를 출력하는 함수
- [x] "---"를 출력하는 함수
- [x] 당첨 통계를 내역을 출력하는 함수
    - [x] "3개 일치 (5,000원) - X개"
    - [x] "4개 일치 (50,000원) - X개"
    - [x] "5개 일치 (1,500,000원) - X개"
    - [x] "5개 일치, 보너스 볼 일치 (30,000,000원) - X개"
    - [x] "6개 일치 (2,000,000,000원) - X개"

- [x] 수익률을 계산하는 함수
    - [x] 수익률 = 당첨금액 / 구매금액 * 100.0
    - [x] 소숫점 둘째 자리에서 반올림을 한다.
- [x] "총 수익률은 X%입니다."를 출력하는 함수

