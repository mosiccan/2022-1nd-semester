# JAVA 07

## 캡슐화 (encapsulation)
- information hiding : 다른이가 함부로 멤버변수를 바꾸는 것을 방지
- 함수의 순서, 순서상 오류 등의 실수를 방지

### private, public
- private : 클래스 내부에서만 접근 가능
- public : 어디서든 접근 가능(접근을 제한 하지 않음)
- default(아무것도 안 썼을 경우) : 동일 패키지에서 접근 가능
<br><br>

### 변수의 종류 3가지
- Instance Variable
  - 멤버 변수이나 static은 아닌 변수
  - 객체 생성 시 생성, 객체 소멸 시 소멸

- Local Variable
  - 함수 안에 정의된 변수
  - 함수가 호출되면 생성되고 리턴되면 소멸

- Static Class Variable
  - 멤버 변수이며 static인 변수
  - 프로그램 실행 시 생성되고 프로그램 종료 시 소멸

<br><br>

### static 변수
- 동일한 클래스의 인스턴스 사이에서 데이터 공유가 필요할 때 static 변수를 사용한다. 
- static 변수는 프로그램 시작 시 초기화 된다.
- static 변수를 생성자를 통해 초기화하는 실수를 범하는 안 된다.
<br><br>

- 초기화 하는 방법
1. 선언과 동시에 초기화
2. static block 사용하기
    ```java
    class StaticExample {
        static String strarr[] = new String[3];static {
            strarr[0] = "abc";
            strarr[1] = "def";
            strarr[2] = "ghi";
        }
    }
    class Test {
        public static void main(String[] args) {
            for (String str : StaticExample.strarr)
            System.out.println(str);
        }
    }
    ```

### static 메소드
- 인스턴스를 생성하지 않아도 static 메소드는 호출 가능
- this 키워드를 사용할 수 없음
