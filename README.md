# kotlin-lotto-precourse

# 로또


## 기능 목록

1. 입력
    - 구입 금액 입력
    - 당첨 번호 입력
    - 당첨 번호 쉼표 기준 분리
    - 보너스 번호 입력
2. 로또
    - 중복되지 않는 6개의 숫자 뽑아서 로또 발행
    - 번호 일치 개수 확인
    - 5개 일치하는 경우, 보너스 번호 일치하는지 확인
    - 수익 계산
    - 수익률 계산 (소수점 둘째 자리 반올림)
3. 출력 내용
    - 당첨 내역 출력
    - 수익률 출력
    - 에러 문구 출력
4. 예외처리
    - 가격에 양수가 아닌 다른 값이 있을 때
    - 가격이 천원으로 나누어 떨어지지 않을 때
    - 당첨 번호 중 1~45가 아닌 숫자가 있을 때
    - 보너스 번호 중 1~45가 아닌 숫자가 있을 때
5. 확인 사항
   - indent depth가 2 이하인가
   - 함수의 길이가 15라인을 넘지 않는가
   - else를 사용하지 않았는가
   - Enum 클래스를 사용했는가
   
---

## 실행 결과 예시
구입금액을 입력해 주세요.

>8000

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

>1,2,3,4,5,6

보너스 번호를 입력해 주세요.

>7

당첨 통계

3개 일치 (5,000원) - 1개

4개 일치 (50,000원) - 0개

5개 일치 (1,500,000원) - 0개

5개 일치, 보너스 볼 일치 (30,000,000원) - 0개

6개 일치 (2,000,000,000원) - 0개

총 수익률은 62.5%입니다.