# 프록시 패턴과 데코레이터 패턴
## 구현
* v1 : 인터페이스와 구현 클래스 스프링빈으로 수동 등록
* v2 : 인터페이스 없이 구체 클래스-스프링빈으로 수동 등록
* v3 : 컴포넌트 스캔으로 스프링빈 자동 등록

## 요구사항
* `원본코드를 전혀 수정하지 않고 로그 추적기를 적용`
* 특정 메서드는 로그를 출력하지 않는 기능
* v1, v2, v3 대상도 적용 가능하도록 

## 프록시(Proxy)란
* 클라이언서버라는 큰 개념안에서 자연스럽게 발생
* 

## 프록시 주요 기능
* 접근제어
    - 권한에 따른 접근 차단
    - 캐싱 
    - 지연 로딩
* 부가 기능 추가
    - 원래서버가 제공하는 기능에 더해서 부가 기능 수행
    - 요청 값이나 응답 감을 중간에 변형
    - 실행시간을 측정해서 추가 로그 남김
* 