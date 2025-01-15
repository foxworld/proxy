# 프록시 패턴과 데코레이터 패턴
## 1.구현
* v1 : 인터페이스와 구현 클래스 스프링빈으로 수동 등록
* v2 : 인터페이스 없이 구체 클래스-스프링빈으로 수동 등록
* v3 : 컴포넌트 스캔으로 스프링빈 자동 등록

## 2.요구사항
* `원본코드를 전혀 수정하지 않고 로그 추적기를 적용`
* 특정 메서드는 로그를 출력하지 않는 기능
* v1, v2, v3 대상도 적용 가능하도록 

## 3.프록시(Proxy)란
* 클라이언 서버라는 큰 개념안에서 자연스럽게 발생
* 프록시는 객체안에서의 개념도 있고, 웹서버에서의 프록시도 있다 객체안에서 개체로 구현되어있는가, 웹 서버로 구현되어 있는가 처럼 규모의 차이가 있을 뿐 근본적인 역할은 같다
* 클라이언트가 서버에 요청할때 대리자(프록시)에게 요청하여 서버에 요청
* 대리자는 자신이 가지고 있으면 클라이언트에 바로 응답을 주고 없으면 서버에 요청해서 응답
* 클라이언트가 요청시 응답+부가기능(**`decorator`**)도 응답 할 있다

## 4.프록시 주요 기능
* 접근제어
  - 권한에 따른 접근 차단
  - 캐싱 (동일한 응답 시 서버 접근하지 않고 응답)
  - 지연 로딩
* 부가 기능 추가
  - 원래서버가 제공하는 기능에 더해서 부가 기능 수행
  - 요청 값이나 응답 감을 중간에 변형
  - 실행시간을 측정해서 추가 로그 남김 
* 프록시패턴과 데코레이터 패턴
  - 프록시패턴과 데코레이터 패턴은 비슷하다
  - 구분하기 위해서는 의도(**`intent`**)로 구분
  - 프록시 패턴 의도 : 다른 개체에 대한 **접근을 제어** 하기 위해 대리자를 제공
  - 데코레이터 패턴 의도 : **객체에 추가 책임(기능)을 동적으로 추가** 하고, 기능 확장을 위한 유연한 대안 제공

## 5.동적프록시
* 리플렉션(**`Refection`**)
  - 자바가 기본으로 제공하는 JDK 동적 프록시 기술이안 CGLIB 같은 프록시 생성 오픈소스 기술을 활용하여 동적으로 생성
  - 리플렉션 기술을 사용하면 클래스나 메서드의 메타정보를 동적으로 획득하고 코드도 동적으로 호출 할수 있음
  - 주의 리플렉션기술은 컴파일 시점에서 오류를 잡을수 없다
  - 일반적으로 공통처리가 필요할때 사용 권장
* **`InvocationHandler`** 를 이용한 동적 프록시 생성

## 6.포인트컷, 어드바이스, 어드바이저
* **포인트컷(`Pointcut`):** 어디에 부가 기능을 적용할지, 어디에 부가기능을 적용하지 않을지 판단하는 필터링 로직. 주로 클래스와 메서드 이름으로 필터링 적용, 이름 그대로 어떤 포인트(Point)에 기능을 적용할지 하지 않을지 잘라서(cut) 구분
* **어드바이스(`Advice`):** 프록시가 호출하는 부가 기능, 단순하게 프록시 로직임
* **어드바이저(`Advisor`):** 단순하게 하나의 포인트컷과 하나의 어드바이스를 가지고 있는것을 말함 **포인트컷1+어드바이스1**
* 포인트컷으로 어디에 적용할지 선택하고, 어드바이스로 어떤 로직에 적용할지 선택

## 7.빈후처리기(BeanPostProcessor)
* 스프링이 빈 저장소에 등록할 목적으로 생성한 객체를 빈 저장소에 등록하기 직전에 조작하고 싶다면 빈 후처리기를 사용
* BeanPostProcessor

