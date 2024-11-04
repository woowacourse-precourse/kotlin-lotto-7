# kotlin-lotto-precourse

## 구현할 기능
- [X] Lotto Class
    - [X] 값을 반환하는 getLottoValue()
- [ ] 결과값을 갖는 enum class LottoResult
- [ ] LottoController
    - [X] 랜덤으로 6개의 숫자를 만들고 이를 Lotto에 저장하는 releaseLotto()
    - [ ] 값을 입력받고 정상적인 입력인지 확인후 저장
    - [ ] 입력받은 가격에 따른 로또 구매
    - [ ] 로또 결과를 확인
    - [ ] 최종 결과값 반환
- [ ] 입력과 결과를 다루는 LottoView

## 구현 과정
### releaseLotto()
Lotto 목록을 저장하는 ArrayList lottos에 getLottoNumber()를 통해 랜덤 로또 번호를 반환하여 만든 Lotto를 add한다.
```
private fun releaseLotto() {
        lottos.add(Lotto(getLottoNumber()))
    }
    
    private fun getLottoNumber(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
}
```