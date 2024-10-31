# kotlin-lotto-precourse

## TDD 로 프로젝트를 진행해봅니다.

### feature 1: 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
1-1 "구입금액을 입력해 주세요." 을 출력하고 로또 구입 금액을 입력받는다.

1-2 "8000"을 입력했을 경우 8000원을 반환한다.

1-3 구입 금액에 1000으로 나누어 떨어지지 않는 값을 입력했다면 "[ERROR] 구매할 수 있는 금액은 1000으로 나누어 떨어져야 합니다." 라는 IllegalArgumentException 을 표시한다.

1-4 구입 금액에 1000으로 나누어서 해당하는 만큼 로또를 발행한다.

### feature 2: 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
2-1 "당첨 번호를 입력해 주세요." 을 출력하고 당첨 번호를 입력받는다.

2-2 입력한 값이 6개가 아니라면 "[ERROR] 당첨 번호는 6개의 숫자여야 합니다." 라는 익셉션이 발생한다. 입력한 숫자들이 1~45의 숫자가 아니라면 "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다." 라는 익셉션이 발생한다.

2-3 "보너스 번호를 입력해 주세요." 을 출력하고 보너스 번호를 입력받는다.

2-4 입력한 값이 1개가 아니라면 "[ERROR] 보너스 번호는 1개의 숫자여야 합니다." 라는 익셉션이 발생한다. 입력한 숫자들이 1~45의 숫자가 아니라면 "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다." 라는 익셉션이 발생한다.

### feature 3: 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
3-1 발행된 로또는 1~45 중에 중복되지 않은 6개의 숫자를 가지고 있는다.

3-2 당첨 내역을 확인한다.

3-3 수익률을 계산한다.

3-4 오름차순으로 로또 번호를 정렬한다.

### feature 4: 형식에 맞춰서 출력한다.
4-1 구매한 로또 갯수와 구매한 로또 번호를 출력한다.

8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]

4-2 당첨 통계를 출력한다.

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.

5-4 반복 횟수에 "a"을 입력했을 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료된다.
