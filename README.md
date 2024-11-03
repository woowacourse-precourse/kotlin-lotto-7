# kotlin-lotto-precourse

## 로또 발매기
사용자가 입력한 금액만큼 로또를 구매하고 당첨 번호와 비교하여 당첨 여부와 수익률을 계산해서 보여주는 로또 시뮬레이션

```text
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

## 기능 목록
### 입력
- [x] 구매할 로또 금액 입력
- [x] 당첨 번호 입력
  - 쉼표(,)를 기준으로 구분
- [x] 보너스 번호 입력

### 출력
- [x] 로또 번호 랜덤 발행
  - [X] 구매 금액만큼 로또 발행
  - [x] 숫자 범위는 1~45
  - [x] 중복되지 않는 6개의 숫자
  - [x] 오름차순으로 정렬
- [ ] 당첨 통계 출력
  - 1등: 6개 번호 일치 / 2,000,000,000원
  - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
  - 3등: 5개 번호 일치 / 1,500,000원
  - 4등: 4개 번호 일치 / 50,000원
  - 5등: 3개 번호 일치 / 5,000원
- [ ] 총 수익률 출력
  - [ ] 둘째 자리에서 반올림

### 프로세스
- [ ] 구매한 로또 번호와 당첨 번호 비교
- [ ] 수익률 계산

### 예외
- [x] 잘못된 값을 입력할 경우 `IllegalArgumentException` 발생
  - `[ERROR]` 로 시작하는 에러 메시지 출력 후 그 부분부터 입력을 다시 받음
  - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리
- [x] 로또 구입금액
  - [x] 로또 구입 금액이 숫자가 아닌 경우
  - [x] 로또 구입 금액이 음수인 경우
  - [x] 로또 구입 금액이 1000원으로 나누어 떨어지지 않을 경우
  - [x] 로또 구입 금액 한도가 넘어가는 경우
- [X] 로또 당첨 번호
  - [x] 당첨 번호가 1~45 범위가 아닌 경우
  - [x] 당첨 번호가 숫자가 아닌 경우
  - [x] 당첨 번호가 6개가 아닌 경우
  - [x] 당첨 번호가 중복된 경우
  - [X] 보너스 번호가 1~45 범위가 아닌 경우
  - [x] 보너스 번호가 1개가 아닌 경우
  - [x] 보너스 번호가 문자인 경우

- [x] 입력 값이 문자, 공백, 소수, 음수, 0, 다른 구분자, 일정 금액(ex. int형 범위)을 벗어난 경우

## 파일 구조
```text
🎫 lotto
├── 🚀 Application.kt
│   └── 🔹 main()
├── 📂 controller
│   ├── 🎛️ LottoController.kt
│   │   ├── ⚙️ start()
│   │   ├── 🔍 getVaildPurchaseAmount()
│   │   ├── 🔍 getVaildWinningNumbers()
│   │   └── 🔍 getValidBonusNumber()
├── 🗂️ model
│   ├── 🎲 Lotto.kt
│   │   ├── 🔄 ComparisonOfWinningNumbers()
│   │   ├── 🔄 ComparisonOfBonusNumber()
│   │   └── 🎲 generate()
│   ├── 🏅 LottoRank.kt
│   │   ├── 📜 Enum: LottoRank
│   │   └── 🧩 getRank()
│   ├── 🎟️ LottoTicket.kt
│   │   └── 📜 Data Class: LottoTicket
│   └── 🛡️ InputValidator.kt
│       ├── ✔️ validatePurchaseAmount()
│       └── ✔️ validateBonusNumber()
├── 🗂️ view
│   ├── 📝 InputView.kt
│   │   ├── 🧾 getPurchaseAmount()
│   │   ├── 🧾 getWinningNumbers()
│   │   └── 🧾 getBonusNumber()
│   └── 📊 OutputView.kt
│       ├── 📈 showPurchasedLottoCount()
│       ├── 📊 showWinningStatistics()
│       └── 💰 showTotalReturnRate()
└── 🛠️ utils
    ├── 📍 Constants.kt
    ├── 🚫 ErrorConstants.kt
    └── 📑 ViewConstants.kt


```
