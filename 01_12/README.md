# 2016.01.12
## 참여인원
하성일, 임형태, 김성우, 신원
## 참여일정
* 장소 : SK PLANET 804호 회의실
* 일시 : 19:00 ~ 20:00

## 1장 함수형 프로그래밍이란 무엇인가?

### 순수 함수
부수효과가 없는 함수

### 부수효과란?
그냥 결과를 돌려주는 것 이외의 어떤 일

#### 부수효과가 있는 프로그램 리팩토링,
함수적 해법으로 부수 효과 제거

### (순수)함수란
*절차(Precedure)는 부수 효과과 있을 수도 있는 배매개변수화된 코드 조각을 지칭하는데 '종종' 쓰임*

항상 같은 값을 돌려 준다
* 참조 투명성(as 표현식의 한 속성)

### 참조 투명성과 순수성
만일 모든 프로그램 p에 대해 표현식 e의 모든 출련(occurrence)을 e의 평과 결과로 치환해도 p의 의미에 아무 영향이 미치지 않는다면, 그 표현식 e는 ** 참조에 투명하다(referentially transparent)**. 만일 표현식 f(x)가 참조에 투명한 모든 x에 대해 참조에 투명하면, 함수 f는 ** 순수하다(pure) **.[more](https://github.com/fpinscala/fpinscala)

#### 치환모형
참조 투명성은 함수가 수행하는 모든 것이 함수가 돌려주는 값으로 대표된다는 불변(invariant) 조건을 강제하며 이를 통해 ** 치환 모형(substitution model) **이라고 부르는, 프로그램 평가에 대한 간단하고도 자연스러운 추론 모형이 가능해진다.
 * 등치 대 등치 치환 = 등식적 추론(requational reasoning)
 * 국소 추론
 * 합성 가능

## 2장 스칼라로 함수형 프로그래밍 시작하기

#### object 키워드
object 키워드는 새로운 단일체(singleton) 형식을 만들며 class와 비슷하되 명명된 인스턴스가 단 하나라는 점이 다르다. 그리고 스칼라에서는 object를 모듈(module) 이라고도 한다.
* *like static class of java*

## 고차 함수 : 함수를 ㅎ마수에 전달

#### 값으로서의 함수
다른 함수를 인수로 받는 함수를 지칭(higher-order function)

#### 루포용 보조 함수 관례
go나 loop 같은 이름을 붙임

#### 스칼라의 재귀함수(recursive function)

##### 스칼라의 꼬리 호출 그리고 최적화 (* 추가 정리 필요)
재귀 호출 시 해귀 호출의 값을 그대로 돌려줄 뿐 다른 일을 하지 않는 경우에는 while 구분과 동일하게 컴파일 되며 이는 함수 호출에 대한 Stack 의 효율성을 얻기 위함이며 이를 확인하고자 할때는 tailrec 어노테이션을 재귀함수에 적용하면 된다.

#### 변수 명명 관례
아주 짧은 변수 이름을 사용하는 경향이 있으며 심지어 한글자짜리 이름도 많다. 이는 대체로 고차 함수가 일반적이어서 인수가 실제 수행하는 일에 대해 구체적으로 알지 못하기 때문이다.

## 다형적 함수: 형식에 대한 추상

### 익명 함수로 고차 함수 호출
익명 함수(anonymous funtion) 또는 함수 리터럴(funtion literal)을 지정해서 호출하는 것

#### 스칼라에서 값으로서의 함수
함수 리터럴을 정의할 때 실제로 정의되는 것은 apply라는 메서드를 가진 하나의 개체이다. 스칼라에는 이 메서드 이름에 대한 틀별한 규칙이 존재한다. apply라는 메서드를 가진 객체는 그 자체를 메서드인 것처럼 호출할 수 있다.

## 형식에서 도출된 구현
* 연습문제 풀이


