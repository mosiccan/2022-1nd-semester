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