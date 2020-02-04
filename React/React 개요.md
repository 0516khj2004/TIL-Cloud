# React 개요

### 1. 웹 개발의 변화

> npm <-> npx (현재 프로젝트가 사라지면 프로그램이 같이 사라진다. 

Ajax(비동기화-서버에서 데이터를 가지고 오지 않아도 다음 작업을 진행을 할 수 있다-필요할 때마다 데이터 요청) 

-> SPA(MVC - 모델, 뷰 , 컨트롤러(사용자 정의))

- 단일 페이지 웹 에플리케이션 
  - Ajax요청을 통해 변경되는 부분에 필요한 데이터만 받아와 해당 부분만 렌더링을 함 - 속도 향상 
  - 모바일 에플리케이션 

### 2. 언어

> 라이브러리  /  프레임워크 (개발 환경까지)  --> DOM(html)관리 상태 값 업데이트              

- jS -> 구현의 어려움, 언어의 모호성, cross Browsing 한계
- JQuery -> js라이브러리, js의 dom처리의 어려움 cross Browsing처리 해결 
- html5 -> 정형성 , 확장성 이 좋지 않다 
- node.js -> 자바스크립트 실행 가능한 서버
- Angular -> google , http 클라이언트, 라우터 기본 제공 ,사용하기는 어렵다 
- react ->facebook, component , http 클라이언트, 라우터, 상태관리 등의 기능이 내장되어 있지 않기 때문에, 자유롭게 사용가능하며, 직접 라이브러리 용이
- vue.js -> html을 템플릿처럼 사용 가능 

### 3. React 

- 양방향 바인딩 모델 (MVC, MVVM, MVW)

- 데이터의 Mutation 

  특정 이벤트 -> 모델 변화 -> DOM에 데이터 반영 

- 높은 자유도 -> 자율적인 3rd party library사용 가능 

- Yarn -> 패키지 매니저 

- Webpack  - 리액트 프로젝트는 컴포넌트를 여러가지 파일로 분리해서 저장 ->JSX문법( 여러가지 파일을 하나로 결합하기 위한 도구)

- Babel - 최신 사영의 자바스크립트를 IE나 구형 브라우저에서도 동작하는 Ess이하의 코드로 변환 

- creat-react-app -> 템플릿 

### 4. 설치 

```shell
> npx create-react-app my-app
> cd my-app
> npm start
```



