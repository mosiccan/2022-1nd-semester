# JAVA 09

## File I/O

## 스트림
- 입력을 키보드로 받든 파일로 받든 상관없이 스트림이 처리
- 입출력 스트림 기본단위 : 바이트
- 텍스트 기반,

### 바이트 입출력 스트림과 문자 입출력 스트림
- 문자 입출력 스트림
  - 문자의 흐름으로 처리
  - 해당 운영체제의 기본 인코딩 방식에 맞춰서 자동으로 문자가 인코딩되어 처리되도록 함
  - 문자가 아닌 바이너리 데이터는 스트림에서 처리하지 못함
  - 정수, 실수, 문자열 같은 기본 데이터 처리
- 바이트 입출력 스트림
  - 단순 바이트의 흐름으로만 처리
  - 인스턴스를 통째로 입출력 할 경우 사용
  - 예) 바이너리 파일을 읽는 입력 스트림

- 파일에 쓰기
  - 사용할 객체
``` java
  - BufferedWriter(new FileWriter(“textfile.txt”))
  - ```BufferedWriter(new FileWriter(“textfile.txt”, true))
```
- 기존 파일 내용 뒤에 이어서 저장
- BufferedWriter를 통해 파일에 쓰기
``` java 
  - void write(String s) throws IOException
  - void newline() throws IOException
  - void close() throws IOException
```
- 파일 읽기 


- 개행 
1. ``` \r\n ```
2. ```out.newLine();```
3. ```System.lineSeparator()```

## 스레드

### 프로세스
- 실행 중인 프로그램, 자원(memory space)과 쓰레드로 구성
- 각 프로세스는 독립된 자원을 가짐
- 공장
- 프로세스는 프로세스 끼리 공유하는 자원이 없음
### 쓰레드
- 프로세스 내에서 실제 작업을 수행
- 모든 프로세스는 하나 이상의 쓰레드를 가짐
- 동일 프로세스 내 쓰레드는 공유하는 자원(Shared memory space)을 가짐
- ```main``` 메소드를 호출하는 것도 프로세스 생성시 함께 생성되는 main 쓰레드를 통해서
이뤄짐
- 일꾼

<br><br>

- 일반적으로 **“하나의 새로운 프로세스를 생성하는 것보다 하나의 새로운 쓰레드를 생성하는 것이 더 적은 비용이 든다.”**

<br><br>

### GUI에서 사용자 키보드 입력을 받으려면?
- Key Listeners 이용
  - 예전부터 사용되던 방법
  - 키 입력을 low-level로 다룰 수 있음
  - focus가 있는 component에만 사용할 수 있음
- Key Bindings 이용
  - JDK 8 이후부터 사용 가능
  - 좀 더 효율적인 방법
  - focus가 없는 component에도 사용할 수 있음

<br><br>
- TBU