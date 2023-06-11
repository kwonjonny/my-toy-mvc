# MyToyMvc
- 프로젝트 유형: Todo Toy Project
- 목표: JavaScript, Thymeleaf, Spring Boot를 활용하여 페이지네이션 기능이 포함된 Todo 애플리케이션 개발

## Spring Boot 프로젝트 설정

### 빌드 플러그인
- `java`: Java 플러그인을 사용하여 프로젝트에 Java 컴파일 기능을 추가합니다.
- `org.springframework.boot`: Spring Boot 기능을 프로젝트에 추가합니다. 버전은 3.1.0으로 설정됩니다.
- `io.spring.dependency-management`: Spring의 의존성 관리 기능을 추가합니다. 버전은 1.1.0입니다.

### 프로젝트 정보
- `group`: 프로젝트 그룹 ID를 'my'로 설정합니다.
- `version`: 프로젝트 버전을 '0.0.1-SNAPSHOT'으로 설정합니다.
- `sourceCompatibility`: 프로젝트 Java 버전을 17로 설정합니다.

### 의존성
- `org.springframework.boot:spring-boot-starter-web`: Spring Boot 웹 응용 프로그램 개발에 필요한 기본 의존성입니다.
- `org.mybatis.spring.boot:mybatis-spring-boot-starter`: MyBatis와 Spring Boot를 통합하는 데 사용됩니다.
- `org.springframework.boot:spring-boot-devtools`: 개발 시 유용한 추가 도구를 제공합니다.
- `com.mysql:mysql-connector-j`: MySQL 데이터베이스와 연결하는 JDBC 드라이버입니다.
- `org.projectlombok:lombok`: 코드 간소화를 위한 라이브러리입니다.
- `org.springframework.boot:spring-boot-starter-test`: 테스트를 위한 의존성입니다.
- `org.springframework.security:spring-security-test`: Spring Security 테스트 유틸리티입니다.
- `org.springframework.boot:spring-boot-starter-security`: Spring Security를 쉽게 사용하도록 도와줍니다.
- `org.springframework.boot:spring-boot-starter-thymeleaf`: Thymeleaf 템플릿 엔진을 통합합니다.
- `nz.net.ultraq.thymeleaf:thymeleaf-layout-dialect:3.1.0`: Thymeleaf 레이아웃 기능을 추가합니다.

### 태스크 설정
- `test`: JUnit Platform을 사용하도록 설정합니다.

### 저장소
- Maven 중앙 저장소에서 의존성을 가져옵니다.

## 프로젝트 사용 방법
1. 프로젝트를 빌드합니다.
2. Run Application을 실행합니다.
3. 웹 브라우저에서 `/todo/list`로 이동합니다.

## 부트스트랩 사용
- [AdminLTE](https://adminlte.io/) 템플릿을 사용합니다.

## MyToyMvc: Todo Toy Project 소개 

### 주요 기능
- Todo 항목 생성, 조회, 수정, 삭제
- 페이지네이션 지원
- Todo 항목 필터링 및 정렬 기능
- Bootstrap을 이용한 반응형 웹 디자인

## 시작하기

### 사전 요구 사항
- Java 17
- MySQL
- 웹 브라우저

### 데이터베이스 설정
프로젝트를 실행하기 전에 MySQL 데이터베이스를 설정하고 `application.properties` 파일에서 데이터베이스 연결 속성을 구성하세요.

### 빌드 및 실행 방법
1. 이 저장소를 복제하거나 다운로드합니다: `git clone [repository_url]`
2. 프로젝트 디렉토리로 이동합니다: `cd MyToyMvc`
3. 프로젝트를 빌드합니다: `./gradlew build`
4. 애플리케이션을 실행합니다: `./gradlew bootRun`
5. 웹 브라우저에서 애플리케이션에 접속합니다: `http://localhost:8080/todo/list`

## 부트스트랩 사용
이 프로젝트는 부트스트랩 템플릿을 사용하여 사용자 인터페이스를 구성합니다. 템플릿에 대한 자세한 정보는 [AdminLTE](https://adminlte.io/)를 참조하세요.

## 지원 및 기타 문의
프로젝트 사용 중 문제가 발생하거나 기타 문의사항이 있는 경우, GitHub 이슈 트래커를 통해 보고할 수 있습니다.

## 라이선스
이 프로젝트는 MIT 라이선스에 따라 배포됩니다. 자세한 내용은 `LICENSE` 파일을 참조하세요.

## 개발자 정보
- 이름: [권성준]
- 이메일: [thistrik@gmail.com]
- 이메일: [thistrik@naver.com]

## 데이터베이스 테이블 정보

### Todo 테이블 (`tbl_todo`)

| 컬럼명   | 데이터 타입     | 설명                                       |
|----------|----------------|--------------------------------------------|
| tno      | INT            | Todo 항목의 고유 식별자 (Primary Key, 자동 증가) |
| title    | VARCHAR(500)   | Todo 항목의 제목 (null이 아님)                |
| content  | VARCHAR(1000)  | Todo 항목의 상세 내용 (null이 아님)           |
| writer   | VARCHAR(100)   | Todo 항목을 생성한 사용자명 (null이 아님)     |
| complete | TINYINT        | Todo 항목의 상태 (기본값 0, 완료 시 1)          |
| dueDate  | DATE           | Todo 항목의 마감 날짜                        |

SQL 스키마:

```sql
CREATE TABLE tbl_todo(
    tno INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(500) NOT NULL,
    content VARCHAR(1000) NOT NULL,
    writer VARCHAR(100) NOT NULL,
    complete TINYINT DEFAULT 0,
    dueDate DATE
);

## TMI 
- 반박시 your 말이 맞음 

