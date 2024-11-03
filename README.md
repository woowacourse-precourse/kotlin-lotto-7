# kotlin-lotto-precourse
## 기능 목록

1. 로또 구입 금액, 당첨 번호, 보너스 번호 입력 및 구입한 로또 수량과 거스름돈 구하는 기능 구현
    - 로또 한 장의 가격은 1,000원이다.
    - 로또 구입 가격이 1,000원으로 나누어 떨어지지 않을 때, 거스름돈을 따로 저장해 놓는다.
    - 구입 금액은 음수가 될 수 없다.

2. 로또 기능 구현
    - 당첨 번호는 기본 번호 6개와 보너스 번호 1개로 이루어져 있고, 이 7개는 중복되지 않는 숫자이다.
    - 숫자 범위는 1 ~ 45
    - enum 클래스 작성하여 당첨 순위와 당첨금 표현

3. 당첨 확인 기능, 당첨 내역과 수익률 출력 구현
    - 수익률은 소숫점 둘째 자리에서 반올림한다.