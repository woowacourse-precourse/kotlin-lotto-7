# kotlin-lotto-precourse
## [로또 판매기]
1) 로또 번호의 숫자 범위는 1~45
2) 1개의 로또를 발행 할 때 중복X 6개 숫자
3) 당첨 번호 추첨 시 중복X 6개 숫자 + 보너스 번호 1개
4) 1등부터 5등가지 추첨
- 1등: 6개 일치 > 2,000,000,000
- 2등: 5개 일치 + 보너스번호 > 30,000,000
- 3등: 5개 일치 > 1,500,000
- 4등: 4개 일치 > 50,000
- 5등: 3개 일치 > 5,000
5) 로또 구입 금액 만큼 발행 > 1장당 1,000
6) 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료

## [구현할 기능]
1) 사용자로부터 로또를 구매할 가격을 입력
- 1,000원 단위로 입력 받으며 단위가 맞지 않을 시 예외 처리하고 다시 입력

2) 구입한 로또의 개수를 출력
- 로또를 구매할 가격을 1,000으로 나눠서 개수 출력
- 개수만큼 중복되지 않은 6개의 숫자로 이루어진 로또 발행
- 로또는 1~45범위로 발행

3) 당첨번호 입력
- 중복되지 않는 6개의 숫자 입력
- ,를 이용해서 숫자를 구별
- 1~45의 범위에 없는 숫자는 예외 처리하며 다시 입력
- 중복되는 수가 있는 경우 예외 처리하며 다시 입력
- 6개를 전부 입력하지 않거나 공백이 있는 경우 예외 처리하며 다시 입력

4) 보너스 번호를 입력
- 당첨 번호와 중복되는 수 일 경우 예외 처리하며 다시 입력
- 1~45의 범위에 없는 숫자는 예외 처리하며 다시 입력
- 공백이 있는 경우 예외 처리하며 다시 입력

5) 입력한 당첨 번호와 발행 된 로또 번호들을 비교하는 검증 로직 구현 및 결과 출력
- 보너스볼 일치 여부 확인
- 5등부터 결과 출력
- 당첨된 개수 출력

6) 수익률 계산 및 출력
- 등수에 따른 금액 환산
- 로또를 구매한 가격과 수익을 비교해 수익률 환산 