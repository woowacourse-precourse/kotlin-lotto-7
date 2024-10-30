# 🎯 로또

---

## 🗂️ 기능 요구 사항

- 로또 발매기
    - [ ] 로또 번호 숫자 범위 1~45
    - [ ] 1개 로또 발행 시 중복되지 않는 6개 숫자

- 로또 추첨
    - [ ] 당첨 번호는 중복되지 않는 6개 숫자 + 보너스 번호 1개
    - [ ] 당첨 기준
        - 1등: 6개 번호 일치 / 2,000,000,000원
        - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
        - 3등: 5개 번호 일치 / 1,500,000원
        - 4등: 4개 번호 일치 / 50,000원
        - 5등: 3개 번호 일치 / 5,000원

- 로또 구매
    - [ ] 구입 금액 입력 시 구입 금액 만큼 로또 발행
    - [ ] 1장 가격 1,000원

- 로또 확인
    - [ ] 구매한 로또 번호와 당첨 번호를 비교
    - [ ] 당첨 내역 및 수익률을 출력 (소수점 둘째 자리에서 반올림)

- **문제 발생** 시 `IllegalArgumentException` 및 `[ERROR]`로 시작하는 에러 메시지를 출력 후 그 부분부터 다시 입력 받기
    - 로또 구입 금액
        - [ ] 양의 정수가 아닐 경우
        - [ ] 1,000원으로 나누어 떨어지지 않는 경우

    - 당첨 번호
        - [ ] 당첨 번호 개수가 6개가 아닐 경우
        - [ ] 당첨 번호가 1~45 사이의 양의 정수가 아닐 경우
        - [ ] 당첨 번호가 중복이 있을 경우

    - 보너스 번호
        - [ ] 보너스 번호가 1~45 사이의 야의 정수가 아닐 경우
        - [ ] 보너스 번호가 당첨 번호 중 하나 일 경우

### ✅ 체크리스트

- [ ] 시작점이 application의 main 함수인가?
- [ ] 프로그램 종료 시 System.exit() 또는 exitProcess()를 호출하지 않았는가?
- [ ] 요구사항에 명시된 출력 형식을 따랐는가?
- [ ] 기능 별로 커밋했는가?
- [ ] [코틀린 코드 컨벤션](https://kotlinlang.org/docs/coding-conventions.html)을 지키며 프로그래밍했는가?
- [ ] intent가 depth 3을 넘지 않는가? (2까지만 가능)
- [ ] 함수 길이가 15라인을 넘지는 않는가?
- [ ] else를 지양했는가? (얼리리턴 사용하기)
- [ ] Enum class를 사용했는가?
- [ ] 함수가 한 가지 일만 하는가?
- [ ] Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange()`를 활용하는가?
- [ ] 사용자가 입력하는 값은 ```camp.nextstep.edu.missionutils.Console```의 ```readLine()```을 활용했는가?
- [ ] `Unit 5`와 `AssertJ`를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인했는가?
- [ ] UI 로직은 제외하고 단위 테스트를 작성한다.
- [ ] 연속된 숫자를 덧붙이거나(a1, a2, ..., aN), 불용어(Info, Data, a, an, the)를 사용하지 않았는가?
- [ ] 축약하지 않았는가?
- [ ] 의미없는 공백이 있지는 않은가?
- [ ] Lotto 클래스 내 필드를 추가하진 않았는가?
- [ ] Lotto 클래스 내 numbers의 접근 제어자를 변경하지는 않았는가?