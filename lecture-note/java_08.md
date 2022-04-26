# JAVA 08

## 메소드 오버로딩(overloading)
- 리턴타입, 함수이름은 똑같은데 **인자만** 다르게 만드는 것

- 리턴타입이 다르면 컴파일 오류가 난다
  - TBU

- 생성자도 오버로딩 가능
  - 하나의 클래스로 다양한 형태의 인스턴스 생성을 가능하게 한다. 

### this(), 생성자에서 다른 생성자 호출
- ```this```를 이용하면 생성자 내에서 같은 클래스 내 다른 생성자를 호출할 수 있다.
- 생성자마다 중복되는 초기화 코드의 중복을 피할 수 있다.
- 생성자 내에서만 사용 가능하다.
- 다른 메소드에서는 사용 불가하다.
- 반드시 생성자 코드의 제일 첫줄에 호출해야 한다.

```java
    public Person(int perID, int milID, int bYear, int bMonth, int bDay){
        this.perID=perID;
        this.milID=milID;
        birthYear=bYear;
        birthMonth=bMonth;
        birthDay=bDay;
    }
    public Person(int pID, int bYear, int bMonth, int bDay){ 
        this(pID, 0, bYear, bMonth, bDay);
    }

```

## String 클래스의 인스턴스 생성
- 인스턴스 생성을 위해서는 new를 사용해야 한다.
- String은 큰 따옴표만으로 인스턴스 생성이 가능하다.

### String 인스턴스는 상 수 형태의 인스턴스이다
- String 인스턴스에 저장된 문자열의 내용은 변경이 불가능하다.
  - 이는 동일한 문자열의 인스턴스를 하나만 생성해서 공유하기 위함이다.
  - 문자열 변경이 불가능하기 때문에 둘 이상의 참조변수가 동시에 참조를 해도 문제가 발생하지 않는다!
  - (Stirng 클래스의 구조가 그런가보다.)

- ```=``` 서로가리키는 대상이 같은가? (메모리에 있는 객체)
- ```equals``` 문자가 서로 같은가?

### String 클래스의 특징
- String인스턴스의 내용은 바꿀 수 없다.(immutable)
```java
    String a = "a";
    String b = "b";
    a = a + b;  // 3개의 공간이 생성됨 a가 바뀌는게 아님
```
- 같은 글자를 new로 생성하면 다른 공간에 생성함
  - equals로 비교해보면 같기때문에 true임

## +연산과 += 연산
- ```+``` 연산은 내부적으로 concat 연산으로 변환된다.
- ```+=``` 연산은 내부적으로 StringBuilder를 이용한 연산으로 변환된다
- ```b2.delete(0, 6);``` // inclusive
- 0~5까지만 지움 // exclusive 

## StringBuilder 클래스
- String클래스와 달리 내용을 변경할 수 있다.(mutable)
- String클래스와 달리 equals()를 사용하여 값을 비교할 수 없다