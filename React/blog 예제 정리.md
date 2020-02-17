# blog 예제 정리 

### 라이브러리

-  redux-form
  - export default reduxForm({ form : 'PostNewForm'})(PostsNew)

### 구조

- action -> 명령어  type, payload 
- container / Comnent => connect ( )
  - export default connect( 상태 관리 함수, 액션관리 함수)( 연결 컴포넌트 );
- reducer -> 작업 내용 / 함수 
  - store 