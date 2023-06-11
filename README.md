# MyToyMvc 
- todo toy project 
- 목표 : JavaScript Thymleaf Springboot 를 활용한 페이지네이션 todo 

# Spring boot 프로젝트 설정

## 빌드 플러그인
- `java`: Java 플러그인을 사용하여 프로젝트에 Java 컴파일 기능을 추가합니다.
- `org.springframework.boot`: Spring Boot 기능을 프로젝트에 추가하는데 사용됩니다. 이 플러그인의 버전은 3.1.0으로 설정되어 있습니다.
- `io.spring.dependency-management`: Spring의 의존성 관리 기능을 프로젝트에 추가합니다. 버전은 1.1.0입니다.

## 프로젝트 정보
- `group`: 프로젝트의 그룹 ID를 'my'로 설정합니다.
- `version`: 프로젝트의 버전을 '0.0.1-SNAPSHOT'으로 설정합니다.
- `sourceCompatibility`: 프로젝트의 Java 버전을 Java 17로 설정합니다.

## 의존성 설정
- `org.springframework.boot:spring-boot-starter-web`: Spring Boot 웹 어플리케이션 개발에 필요한 기본적인 의존성을 추가합니다.
- `org.mybatis.spring.boot:mybatis-spring-boot-starter`: MyBatis 통합을 위한 Spring Boot 스타터를 추가합니다.
- `org.springframework.boot:spring-boot-devtools`: 애플리케이션 개발 시 유용한 추가 도구를 제공하는 Spring Boot DevTools를 추가합니다.
- `com.mysql:mysql-connector-j`: MySQL 데이터베이스와 연결하는 JDBC 드라이버를 추가합니다.
- `org.projectlombok:lombok`: 코드 생성을 간소화하는 Lombok 라이브러리를 추가합니다.
- `org.springframework.boot:spring-boot-starter-test`: Spring Boot 기반 애플리케이션 테스트를 위한 의존성을 추가합니다.
- `org.springframework.security:spring-security-test`: Spring Security와 함께 사용할 수 있는 테스트 유틸리티를 추가합니다.
- `org.springframework.boot:spring-boot-starter-security`: Spring Security를 쉽게 사용할 수 있도록 도와주는 Spring Boot 스타터를 추가합니다.
- `org.springframework.boot:spring-boot-starter-thymeleaf`: Thymeleaf 템플릿 엔진을 Spring Boot 프로젝트에 통합하는데 필요한 기본적인 의존성을 제공합니다. Thymeleaf는 HTML, XML, JavaScript, CSS 등과 같은 텍스트 기반 템플릿을 처리하는데 사용됩니다. Spring Boot와 함께 사용할 때, Thymeleaf는 웹 페이지를 구성하는데 유용한 방법을 제공하며, 서버 사이드에서 Java 객체를 HTML로 쉽게 렌더링 할 수 있습니다.
- `nz.net.ultraq.thymeleaf:thymeleaf-layout-dialect:3.1.0`: Thymeleaf Layout Dialect는 Thymeleaf 템플릿 엔진에 레이아웃 기능을 추가하는 라이브러리입니다. 이를 사용하여 템플릿을 재사용하고, 웹 페이지의 중복된 부분(예: 헤더, 푸터)을 효율적으로 관리할 수 있습니다. Layout Dialect를 사용하면, 웹 애플리케이션의 유지 보수가 더 쉬워집니다.

## 태스크 설정
- `test` 태스크가 JUnit Platform을 사용하도록 설정되어 있습니다.

## 저장소
- 프로젝트는 Maven 중앙 저장소에서 의존성을 검색합니다.

## How can you using this project ? 
- 프로젝트 build 후 RunApplication 후
- /todo/list 검색 

## Use bootStrap 
- https://adminlte.io/
