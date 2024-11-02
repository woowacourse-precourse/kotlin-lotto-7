# kotlin-lotto-precourse

<hr style="border: 1.5px solid white;">

## 🧑‍💻 프로젝트 정의와 주요기능

### LOTTO Project
- 로또 발매기와 로또 당첨 확인 프로세스를 구현하는 프로젝트

### 주요 기능
- 로또 발매 기능
- 당첨 번호 추첨
- 당첨 확인 및 통계 출력

## 📋 기능 구현 목록

### 🙋 입력

- [X]  로또 구입 금액을 입력받을 수 있도록 메시지를 출력한다.
- [X]  로또 구입 금액을 입력받는다.
    - [ ]  숫자로 변환한다.
- [X]  당첨 번호를 입력받을 수 있도록 메시지를 출력한다.
- [X]  당첨 번호를 입력받는다.
    - [ ]  구분자 쉼표를 기준으로 숫자를 분리한다.
    - [ ]  숫자로 변환한다.
- [X]  보너스 번호를 입력받을 수 있도록 메시지를 출력한다.
- [X]  보너스 번호를 입력받는다.
    - [ ]  숫자로 변환한다.

### 🖥 출력

- [ ]  로또 수량을 출력한다.
- [ ]  발행한 번호를 오름차순으로 출력한다.
- [ ]  담첨 내역을 출력한다.
- [ ]  수익률을 출력한다.

### 🌈 로직

- [ ]  발행할 수 있는 로또의 수량을 계산한다.
- [X]  발행할 수 있는 로또의 수량만큼 로또 번호를 뽑는다.
    - [X]  이 때, 숫자는 1~45 사이이다.
    - [X]  중복된 숫자는 불가능하다.
- [ ]  발행한 로또 번호와 입력한 로또 당첨 번호를 비교한다.
- [ ]  당첨 내역을 계산한다.
- [ ]  수익률을 계산한다.


<hr style="border: 1px solid white;">

## 🚫 예외 상황
<table>
   <tr>
      <td>대상</td>
      <td>구현 여부</td>
      <td>상황</td>
   </tr>
    <tr>
      <td rowspan="6">로또 구입 금액</td>
      <td><input type="checkbox" checked></td>
      <td>빈 경우</td>
    </tr>
    <tr>
      <td><input type="checkbox" checked></td>
      <td>양의 정수가 아닌 경우</td>
    </tr>
<tr>
      <td><input type="checkbox" checked></td>
      <td>소수인 경우</td>
    </tr>
   <tr>
      <td><input type="checkbox" checked></td>
      <td>0인 경우</td>
    </tr>
   <tr>
      <td><input type="checkbox" checked></td>
      <td>1000원 이하인 경우</td>
    </tr>
   <tr>
      <td><input type="checkbox" checked></td>
      <td>1000원 단위로 끝나지 않는 경우</td>
   </tr>
    <tr>
      <td rowspan="8">당첨 번호</td>
      <td><input type="checkbox" checked></td>
      <td>빈 경우</td>
    </tr>
<tr>
      <td><input type="checkbox" checked></td>
      <td>구분자 쉼표(,)가 없는 경우</td>
    </tr>
    <tr>
      <td><input type="checkbox" checked></td>
      <td>구분자만 들어오는 경우</td>
    </tr>
   <tr>
      <td><input type="checkbox" checked></td>
      <td>숫자가 아닌 경우</td>
    </tr>
   <tr>
      <td><input type="checkbox" checked></td>
      <td>숫자가 1~45사이가 아닌 경우</td>
   </tr>
 <tr>
      <td><input type="checkbox" checked></td>
      <td>당첨 번호 개수가 6개가 아닌 경우</td>
   </tr>

 <tr>
      <td><input type="checkbox" checked></td>
      <td>중복된 숫자가 들어오는 경우</td>
   </tr>
 <tr>
      <td><input type="checkbox" checked></td>
      <td>소수가 들어오는 경우 </td>
   </tr>
      <td rowspan="5">보너스 번호</td>
      <td><input type="checkbox" checked></td>
      <td>빈 경우</td>
    </tr>
   <tr>
      <td><input type="checkbox" checked></td>
      <td>숫자가 아닌 경우</td>
    </tr>
   <tr>
      <td><input type="checkbox" checked></td>
      <td>숫자가 1~45사이가 아닌 경우</td>
   </tr>
 <tr>
      <td><input type="checkbox" checked></td>
      <td>중복된 숫자가 들어오는 경우</td>
   </tr>
 <tr>
      <td><input type="checkbox" checked></td>
      <td>소수가 들어오는 경우 </td>
   </tr>
</table>


<hr style="border: 1px solid white;">

## 📌 프로그래밍 요구사항

- [ ]  `build.gradle.kts` 파일은 변경할 수 없으며, **제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.**
- [ ]  프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [ ]  indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- [ ]  함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [ ]  JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
- [ ]  함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- [ ]  Enum 클래스를 적용하여 프로그램을 구현한다.
- [ ]  구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, [System.in](http://system.in/), Scanner) 로직은 제외한다.
- [ ]  `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
   - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.
   - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.