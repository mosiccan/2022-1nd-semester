# JAVA 04

## switch

- ```switch```문에서 아래와 같이 구성도 가능
``` java
    switch(n)
    {
        case 1 : case 2 :
            System.oyt.println("Java");
            break;
        case 3 : case 4 :
            System.oyt.println("Next Java");
            break;
    }
```
- case 1 과 case 2, case 3과 4를 묶음

  
### String 타입을 비교하는 방법
  - string 타입은 ```==``` 기호로 비교할 수 없음.
  - 항상 ```equals()``` 함수를 사용해서 비교해야함.
  - ```==```는 주소값이 같은지 아닌지 비교하는 것이고, 
  - ```equals()```연산도 내부적으로 주소값을 비교하지만 String클래스에서는 비교하고자 하는 두개의 대상의 값 자체를 비교한다.
<br><br>

## loop

### labeled continue, labeled break
- loop가 2개 이상 있을 경우 외부 loop로 continue/break 하고 싶을 때 사용
``` java

    String serchMe = "ABCs su Sub sub su suu";
    Srting substring = "sub";
    boolean isFound = false;
    int max = searchMe.length() - substring.length();

    test: for(int i = 0; i <= max; i++){
                for (int j = 0; j < substring.length(); j++){
                    if(searchMe.charAt(i + j) != substring.charAt(j)){
                        continue test;  // 바깥쪽 for문으로 넘어감
                    }
                }
                isFound = true;
                break;
            }
            System.out.println(isFound ? "Found it at " +i : "Didn't find it")
            // Found it at 12
```
<br><br>

### 이클립스 단축키
- 자동 줄 맞춤
  - Windows : ```ctrl + shift + f```
  - macOS : ```command + shift + f```
- 전체 주석 
    > 원하는 영역 지정 후 
  - Windows : ```ctrl + /```
  - macOS : ```command + /```
- 한 줄 복사
    > 복사하고자 하는 줄에 커서를 두고
    - Windows : ```alt + control + (⬇️/⬆️)```
    - macOS : ```command + option + (⬇️/⬆️)```
- 폰트 변경
    - Window → Preferences General 
    - → Appearance → Colors and Fonts
    - Basic 탭 안에 Text Font → Edit
    - 확인 → Apply and Close
