# 2016.02.03

## 참여인원
하성일, 임형태, 김성우, 신원, 이정윤

## 참여일정
* 장소 : SK PLANET 804호 회의실
* 일시 : 18:00 ~ 21:00

## 예외를 이용하지 않는 오류 처리

### 예외의 장단점
- 예외는 참조 투명성을 위반하고 문맥 의존성을 도입
- 예외는 형식에 안전하지 않음
- 오류 처리 논리의 통합과 중앙집중화 가능

### 예외의 가능한 대안들
- 부분 함수(Partial function)을 이용
 - 오류가 소리 없이 전파 될 수 있음
 - 실수의 여지가 많음
 - 타형적 코드에는 적용이 불가
 - 호출 규약을 요구

### Option 자료 형식

#### Option의 사용 패턴
- Option에 대한 기본적인 함수 
- 용레

#### 예외 지향적 API의 Option 합성과 승급 감싸기
- life 를 이용한 승급

```
    def life[A,B](f: A => B): Option[A] => Option[B] = _ map f
```

### _Either 자료 형식_


## Java 8 Lambda & Stream Overview

## Programming in scala 계획 
- 1 ~ 7장까지 개별 학습
- 8장부터 시작
- 하루에 2 ~ 3 Chapter 진행

### Java 8 in Action 참조하여 진행

