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

## 객체도 배열로 만들 수 있다.
### 객체를 생성한게 아닌 경우
```java
  Dog pets[];
  pets = new Dog[5];
```
  - 객체가 5개 생성되는게 아님
  - 5개의 레퍼런스가 생성되는 것!
<br><br>

### 올바른 예시
```java
  Dog pets[];
  pets[0] = new Dog();  // 객체가 생성됨
  pets[1] = new Dog();
  pets[0].size = 21;
```
###

```java
public static void main(String [] args) { 
  Person[] pa;
  pa = new Person[10];  // 10개의 레퍼런스 생성
  for (int i=0;i<pa.length;i++) { 
    pa[i] = new Person(); 
    pa[i].age = 30 + i;
  }

  for (int i=0;i<pa.length;i++) 
    System.out.print(pa[i].age+” “);
}

30 31 32 33 34 35 36 37 38 39
```

## 생성자 (constructor)
- 생성자는 함수와 비슷하게 생겼지만 함수가 아님
- 생성자 이름은 클래스 이름과 동일 해야함
- 생성자는 리턴 타입이 없음
- 생성자는 new를 통해 객체를 생성할 때만 호출됨
- 생성된 객체가 레퍼런스에 할당되기 전에 호출됨
- 생성자 내에서는 **final 멤버 변수의 초기화**가 가능하다!
- 생성자는 반드시 하나 이상 선언되어야 함
  - 개발자가 생성자를 정의하지 않으면 자동으로 기본 생성자가 정의됨
    - 컴파일러에 의해 자동 생성 (= 디폴트 생성자 라고도 함)
```java
  class Number
  {
    int num;
    public Number() // 생성자
    {
      num = 10;
      System.out.println("생성자 호출");
    }
  }
```
```java
  Number num = new Number();
            // 인스턴스 생성 
            // Number() 생성자 호출 
```
### 디폴트 생성자
- 클래스에 생성자가 하나도 선언되지 않은 경우 컴파일러에 의해 자동으로 생성됨.
- 디폴트 생성자는 인자가 없으며 바디가 비어있다.
- 코드에서는 보이지 않음.

### 생성자를 써야하는 이유
- 클래스의 초기 값을 입력을 해주어야만 객체를 사용할 수 있기 때문에,,,?
- TBU