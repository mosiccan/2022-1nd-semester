# JAVA 06

## Class
- 객체를 생성하기 위헤서는 우선 클래스라는 틀을 만들어야 한다.

``` java
  class FruitSeller
  {
    int numOfApple = 20;
    int myMoney = 0;
    
    public int SaleApple(int money)
    {
      int num = money / 1000;
      return num;
    }
  }
```
### 멤버변수
- 상태를 저장할 멤버 변수를 선언  
- 멤버 변수(member variable) 혹은 필드(field)라고 함  
### 멤버함수
- 객체의 행위를 구현
- 메소드는 함수이며 함수 만드는 방법과 동일하게 작성
- 모든 메소드는 반드시 클래스 안에 있어야함
- 멤버 함수(member function) 혹은 메소드(method)라고도 함

### primitive 변수와 reference 변수
- primitive 변수
  - ``` byte x = 3```
  - 3이라는 값이 변수에 저장됨
- reference 변수
  - ```Dog theDog = new Dog();```
  - Dog 객체를 가리키는 **주소(reference)** 가 변수에 저장됨

- 레퍼런스는 객체가 저장된 메모리의 주소 값을 저장한다.
- 따라서 아래와 같이 seller에 저장된 주소 값을 seller2에 저장할 수도 있다.
``` java
  FruitSeller seller1 = new FruitSeller();
  FruitSeller seller2 = seller1;  // seller1과 2는 같은 공간을 가리킴

  int a = 3;
  int b = a;  // a의 값과 b의 값은 같지만 같은 공간은 아님
``` 

## this 레퍼런스
- this의 기초 개념
  - 현재 객체 자기 자신을 가리킴
    - 자기 자신에 대한 레퍼런스
    - 같은 클래스 내에서 클래스 멤버, 변수를 접근할 때 객체 이름이 없으면 묵시적으로 this로 가정
- this의 필요성
  - 객체의 멤버 변수와 메소드 변수의 이름이 같은 경우
  - 객체 자신에 대한 참조를 메소드에 전달 또는 반환할 때