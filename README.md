# kotlin-lotto-precourse

## 기능 요구 사항

- 간단한 로또 발매기를 구현한다.
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
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

## 프로그래밍 요구 사항

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- else를 지양한다.
- Enum 클래스를 적용하여 프로그램을 구현한다.
- 구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.

## 입출력 요구 사항

### 입력

- 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
- 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
- 보너스 번호를 입력 받는다.

### 출력

- 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.
- 당첨 내역을 출력한다.
- 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.

## 구현할 기능 목록

- [x] 입력 기능
- [ ] 로또 랜덤 구입 기능
- [ ] 당첨 여부 확인 기능
- [ ] 당첨 통계 기능
- [ ] 출력 기능
- [ ] 예외 처리

## 문제 해결 과정

### 입력 기능

#### Instructions 클래스

```kotlin
object Instructions {
    fun purchaseAmountInstructions(){
        println("구입금액을 입력해 주세요.")
    }

    fun numberOfPurchasesInstructions(purchaseAmount:Int){
        println("\n${purchaseAmount}개를 구매했습니다.")
    }

    fun winningNumberInstructions(){
        println("\n당첨 번호를 입력해 주세요.")
    }

    fun bonusNumberInstructions(){
        println("\n보너스 번호를 입력해 주세요.")
    }

}
```
- 사용자에게 입력을 받을 때 안내 문구를 출력하는 클래스
- 싱글톤 객체로 작성

#### Input 클래스

```kotlin
object Input {

    init {
        inputPurchaseAmount()
        inputWinningNumber()
        inputBonusNumber()
    }
    private fun inputPurchaseAmount(){
        Instructions.purchaseAmountInstructions()
        val purchaseAmount = readln().toInt()
    }

    private fun inputWinningNumber(){
        Instructions.winningNumberInstructions()
        val winningNumber = readLine()!!.split(",").map { it.trim().toInt() }
    }

    private fun inputBonusNumber(){
        Instructions.bonusNumberInstructions()
        val bonusNumber = readln().toInt()
    }

}
```

- 사용자에게 입력을 받는 클래스
- 구입 금액, 당첨 번호, 보너스 번호를 입력 받음
- 싱글톤 객체로 작성
- 객체 생성시 Instructions 객체를 통해 안내 문구를 출력 후 `readln()`, `readLine()`함수로 입력을 받음
