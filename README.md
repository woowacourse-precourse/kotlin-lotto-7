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
- [x] 로또 랜덤 구입 기능
- [x] 당첨 여부 확인 기능
- [x] 당첨 통계 기능
- [x] 출력 기능
- [ ] 예외 처리

## 문제 해결 과정

### 입력 기능

#### Instructions 클래스

```kotlin
object Instructions {
    fun purchaseAmountInstructions(){
        println("구입금액을 입력해 주세요.")
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
        LottoSystem.savePurchaseAmount(purchaseAmount)
    }

    private fun inputWinningNumber(){
        Instructions.winningNumberInstructions()
        val winningNumber = readLine()!!.split(",").map { it.trim().toInt() }
        LottoSystem.saveWinningNumber(winningNumber)
    }

    private fun inputBonusNumber(){
        Instructions.bonusNumberInstructions()
        val bonusNumber = readln().toInt()
        LottoSystem.saveBonusNumber(bonusNumber)
    }

}
```

- 사용자에게 입력을 받는 클래스
- 구입 금액, 당첨 번호, 보너스 번호를 입력 받음
- 싱글톤 객체로 작성
- 객체 생성시 Instructions 객체를 통해 안내 문구를 출력 후 `readln()`, `readLine()`함수로 입력을 받음
- 입력받은 값은 LottoSystem 객체에 저장

### 로또 랜덤 구입 기능

#### LottoSystem

```kotlin
object LottoSystem {
    private lateinit var winningNumber: List<Int>
    private var bonusNumber: Int = 0
    private var purchaseAmount: Int = 0
    private var numberOfPurchases: Int = 0
    private var randomNumbers = mutableListOf<MutableList<Int>?>()

    init {
        Input
    }
    ...
}
```
- 로또의 전반적인 시스템을 관리하는 싱글톤 객체
- `LottoSystem` 객체 생성시 즉, 시스템 실행 시 `Input` 객체를 생성해 사용자로부터 입력을 받음

##### 구입 개수 저장

```kotlin
object LottoSystem {
    ...
    fun savePurchaseAmount(purchaseAmount: Int) {
        this.purchaseAmount = purchaseAmount
        saveNumberOfPurchases()
    }
    private fun saveNumberOfPurchases() {
        numberOfPurchases = purchaseAmount / 1000
        PrintResult.numberOfPurchasesInstructions(numberOfPurchases)
        saveRandomNumbers(numberOfPurchases)
    }
    ...
}
```
- `Input` 객체에서 호출한 `savePurchaseAmount()` 함수에서 구입 금액을 받은 후 `saveNumberOfPurchases()` 함수를 호출해 구입 개수를 구한 후 저장
- 저장된 구입 개수는 `PrintResult` 객체를 통해 출력
- `saveNumberOfPurchases()` 함수에서 `saveRandomNumbers()` 함수를 호출하여 구입 개수 만큼 랜덤 번호를 생성


##### 구입 개수 만큼 랜덤 구입

```kotlin
object LottoSystem {
    ...
    private fun saveRandomNumbers(numberOfPurchases: Int) {
        repeat(numberOfPurchases) {
            val randomNumber = pickRandomNumbers()
            randomNumbers.add(randomNumber!!.sorted().toMutableList())
        }
        PrintResult.printRandomNumbers()
    }

    private fun pickRandomNumbers(): MutableList<Int>? = Randoms.pickUniqueNumbersInRange(1, 45, 6)

    ...
}
```
- `saveRandomNumbers()` 함수에서 `pickRandomNumbers()` 함수를 호출하여 랜덤한 번호를 구입한 개수 만큼 생성
- `pickRandomNumbers()` 함수에서 1~45 사이의 값중 중복이 되지 않는 6개의 수를 뽑은 리스트를 리턴
- 리턴하여 받은 랜덤 번호를 정렬후 `randomNumbers` 리스트에 저장
- 생성된 랜덤 번호를 `PrintResult` 객체를 통해 출력

#### PrintResult

```kotlin
object PrintResult {
    fun printRandomNumbers() {
        val randomNumbers = LottoSystem.getRandomNumbers()
        randomNumbers.forEach { println(it) }
    }

    fun numberOfPurchasesInstructions(purchaseAmount:Int){
        println("\n${purchaseAmount}개를 구매했습니다.")
    }
    
}
```
- 결과를 출력하는 싱글톤 객체
- 구입한 로또 개수, 생성된 로또 번호 등을 출력

### 당첨 여부 확인 기능

#### LottoRank

```kotlin
enum class LottoRank(val priceONE:String,val price:Int,val matchCount:Int,val bonusMatch:Boolean) {
    ONE("2,000,000,000원",2000000000,6,false),
    TWO("30,000,000원",30000000,5,true),
    THREE("1,500,000원",1500000,5,false),
    FOUR("50,000원",50000,4,false),
    FIVE("5,000원",5000,3,false),
    LOSE("0원",0,0,false)
}
```
- 로또의 순위를 나타내는 enum 클래스
- 해당 순위에 맞는 당첨금액, 맞춘 숫자 개수를 포함

#### Lotto

```kotlin
class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }

    fun getMatchCount(): MutableList<Int> {
        val winningNumber = LottoSystem.getWinningNumber()
        val bonusNumber = LottoSystem.getBonusNumber()
        val matchCountAndBonus = mutableListOf<Int>()
        var count = 0

        numbers.forEach {
            if(winningNumber.contains(it))count++
        }
        matchCountAndBonus.add(count)

        if(numbers.contains(bonusNumber)){
            matchCountAndBonus.add(1)
        }else{
            matchCountAndBonus.add(0)
        }
        return matchCountAndBonus
    }
    
}
```
- 매개 변수로 로또 번호 6개를 입력 받음
- `LottoSystem` 객체로부터 당첨 번호와 보너스 번호를 받음
- `getMatchCount()` 함수에서 매개변수로 전달받은 로또 번호와 당첨 번호를 대조후 맞는 숫자의 개수와 보너스 번호 일치 여부를 포함하는 리스트를 리턴

#### LottoSystem 당첨 여부 확인

```kotlin
object LottoSystem {
    ...
    private fun checkWinning(){
        randomNumbers.forEach {
            val lotto = Lotto(it!!.toList())
            val matchCount = lotto.getMatchCount()
            matchCounts.add(matchCount)
        }
        saveRanks(matchCounts)
    }

    private fun saveRanks(matchCounts: MutableList<MutableList<Int>>) {
        setRanks()
        matchCounts.forEach {
            if(it[0]==6){
                ranks[LottoRank.ONE] = ranks[LottoRank.ONE]!! + 1
            }else if(it[0]==5&&it[1]==1){
                ranks[LottoRank.TWO] = ranks[LottoRank.TWO]!! + 1
            }else if(it[0]==5&&it[1]==0){
                ranks[LottoRank.THREE] = ranks[LottoRank.THREE]!! + 1
            }else if(it[0]==4){
                ranks[LottoRank.FOUR] = ranks[LottoRank.FOUR]!! + 1
            }else if(it[0]==3){
                ranks[LottoRank.FIVE] = ranks[LottoRank.FIVE]!! + 1
            }
        }
    }
    ...
}
```
- `checkWinning()` 함수에서 저장된 랜덤 번호 리스트에 담긴 번호를 통해 `Lotto` 클래스를 생성
- 각각의 로또 클래스를 생성 후 맞춘 번호 수를 `getMatchCount()` 함수를 통해 얻음
- 각 로또 번호에 대한 맞춘 개수들을 저장하는 `matchCounts` 리스트에 맞춘 개수를 추가
- 각 로또 번호에 대한 맞춘 개수를 모두 저장한 후 `saveRanks()` 함수를 호출
- `saveRanks()` 함수에서 각 로또 번호에 대한 맞춘 개수에 맞는 순위를 확인
- `ranks` 맵에 각 로또 번호에 대한 맞는 순위에 더하여 각 순위별 당첨 개수를 저장

### 당첨 통계 기능

#### LottoSystem

```kotlin
object LottoSystem {
    ...
    private fun saveRateOfReturn(){
        ranks.entries.forEach { if(it.value > 0) rateOfReturn += it.key.price.toLong()*it.value }
        rateOfReturn = (rateOfReturn/purchaseAmount.toDouble())*100.0
    }
    ...
}
```
- 순위별 당첨 개수가 저장된 `ranks` 맵을 통해 당첨된 모든 금액을 더함
- 더한 모든 당첨 금액을 구입금액으로 나눈후 100을 곱해 수익률을 계산

### 결과 출력 기능

#### PrintResult

```kotlin
object PrintResult {
...
    fun printWinningStatistics(){
        val ranks = LottoSystem.getRanks()
        println("당첨 통계")
        println("---")
        ranks.forEach {
            if(it.key.bonusMatch&&it.key.matchCount==5)
                println("${it.key.matchCount}개 일치, 보너스 볼 일치 (${it.key.priceONE}) - ${it.value}개")
            else println("${it.key.matchCount}개 일치 (${it.key.priceONE}) - ${it.value}개")
        }
        val rateOfReturn = round((LottoSystem.getRateOfReturn() * 100)) /100
        println("총 수익률은 ${rateOfReturn}%입니다.")
    }
    
}
```
- `LottoSystem` 객체를 통해 각 순위별 당첨 개수를 저장한 맵 `ranks`를 얻음
- `ranks` 맵을 통해 당첨 결과를 출력
- `LottoSystem` 객체를 통해 총 수익률 값을 얻고 출력

## 실행 결과 
<img width="333" alt="image" src="https://github.com/user-attachments/assets/efe89d74-590c-4d94-b112-8c957fb59830">
