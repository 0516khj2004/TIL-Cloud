# DevOPs

- CLAMS 프레임워크 
  - 문화
  - 자동화
  - 린
  - 측정
  - 공유
- DEV -> QA -> OPS
- CI/CD : 수동 배포가 아닌 여러 환경과 수십대의 서버에 배포해야 하는 경우 



# Microservice

- 작은 서비스 - 독립된 서비스 
  - 다른 서비스 결합이 없는 서비스 
  - 구현, 배포실해으 장애에 대한 영향을 받지 않음 
- 응집된 서비스 
  - 하나의 서비스는 기능적으로 응집
  - 같이 묶을 수 있는 서비스 -> 단순명확, 오류 최소화
- 자율적 서비스 
  - 서비스의 기획, 개발,테스트 , 배포 및 서비스의 운영까지 담당 조직이 독립적으로 의사 결정 -> ownership 



- 용어 

  - http://localhost:8080/ users 

    users -> endpoint    결과-> payload



- 고려 사항 
  - 조직의 구성 
  - Agile (방법론) / DevOps      ->무한 반복 
    - 2주 사이클 
    - todolist -> 원데이 list 
  - cloud native 기술환경
    - ci/cd
    - devops
    - microservices 
    - containers -도커 



# MSA 기반 기술

- Gateway 
  - zuul
- service mesh 
  - MSA인프라 -> 미들웨어 
    - 인증, 권한 처리 ,암호화 ,서비스 검색, 요청 라우팅, 로드 밴런싱,서비스 디스커버리  
    - 자가 치유 복구 서비스
  - 서비스간의 통신과 관련된 기능을 자동화 
- runtime platform
- backing service 
- telemetry
  - 시각화 
  - 모니터링 
- ci/cd autometion
  - source -> 형상관리
  - build (단일화)-> 소스코드 빌드, 이미지빌드 (ex, docker dockerfile)
  - Test -> 단위 테스트 , 소스 정적분석 
  - Artifact Storage-> 도커이미지 저장 
  - Deploy
  - Monitor 
  - 프로그램 -> ex) Jenking



- CI의 목적?
  - 

