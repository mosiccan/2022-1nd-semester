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