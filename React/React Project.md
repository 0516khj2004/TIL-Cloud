# React Project 

- class  App  extents Component{

  render(){

  return(

  );

  }

  }        // 함수를 많이 사용 할 때 

- function  App() {}

- const App = function(){ }

### 1. JSX 

- 항상 <> </> 로 끝나야 한다. - >혹은 <input     />/

- if 문장 사용 못함  

  - 삼항연산자  

    ```
    {
        time < 15 
        ? (<div> Hello, {name}</div>) 
        : (<div> Bye, {name} </div>)
    }
    ```

  - AND 연산자

  - IIFE (더 많은 조건이 있는 경우)

    ```
    {
        (function(){
            if(time <12) return(<div>Good Morning</div>)
            if(time <18) return(<div>Good Afternoon</div>)
            if(time <22) return(<div>Good Evening</div>)
        }) ()
    }
    ```

- 스타일 

  - 내부

    ```
    render(){
        const name = "koo"
        const css = {
        color: 'red',
        background: 'black',
        padding: '2px',
        fontSize: '25px'
    };
    return(
        <div className= 'App-header'>
        <div style={ css }> Hello, {name} </div>
        </div>
        );
    }
    ```

  - 외부 -> 외부 .css파일 import  

    `import './App.css';

- **props** *부모->자식 

  부모 컴포넌트가 자식 컴포넌트에게 전달하는 값 

  자식 컴포넌트에서는 props의 값을 수정할 수 없음 

  props 값은 this. 키워드를 이용하여 사용

  ```
  app.js
  class App extends Component{
    render(){
      const card = {
        name : '구현진',
        email : '0516@naver.com',
        phone : '010-666-666'
      };
      return(
        <MyIntro my= {card} />
      );
    }
  }
  
  MyIntro.js
  return(
      <div style={css}>
          안녕하세요 !<br />
          이름은: <b> {this.props.my.name} </b><br />
          이메일은: <b> {this.props.my.email} </b><br />
          폰 :<b> {this.props.my.phone} </b>
          입니다.
      </div>
  );
  ```

  

- **state** *자기자신

  컴포넌트 내부에 선언하여 사용된느 보관용 데이터 값 

  동적인 데이터 처리

- 전개 연산자 (바꾸고 싶은 데어터 값만 바꾸는 것 )

  - [...myArray.slice(0,2), ...myArray.slice(3,5)] -> [1,2,4,5]
  
  ```
  this.setState({
      info :{
      name: 'koo',
      ...this.state.info   // name은 변경되고 age은 그대로 나옴 
      }
  });
  ```
  
- `<div></div>`

- `<Fragment></Fragment>`

### 2.생명주기 메서드

1. constructor()    --> 초기화 단계 
2. compontDidMount( ) -> render메서드의 첫번째 반환값이 실제 돔에 반영된 직후 호출
3. shouldComponentUpdate() -> 성능 최적화를 위해 존재 
4. componentWillUpdate() -> render 전에 발생 
5. componetDidUpdate() - >업데이트 단계에서 마지막으로 호출
6. componentWillUnmount()-> 소멸단계에서 호출되는 유일한 생명 주기 메서드

7. componentDidCatch -> 생명주기 메서드에서 발생한 예외를 처리



### 3. Demo

- 부모 컴포넌트에 저장 전달 

  > ​	부모 컴포넌트의 함수를 자식 컴포넌트에 전달 - > 자식 컴포넌트에서 부모의 함수 호출

  - 부모

    - 자식한테 받은 데이터 쌓기

    ```
    handleCreate =(data) => {
        this.setState({
            constacts: [ 
                ...this.state.constacts,
                {
                id : this.id++,
                ...data
                }
            ]
    
        })
    }
    
    -------------------------------------------------
    handleCreate =(data) => [
        const {constacts} = this.state   // 비구조 할당 
        this.setState({
            constacts: constacts.concat({id: this.id++, ...data})
        })
    }
    
    const {contacts} = this.state
    {JSON.stringify(contacts)}
    ```

    - 비구조 할당 

      - const {contacts} = this.state   => this.state.contacts ?

    - map() - > 반복

      myArray.map(v => v ** 2) -> 제곱

      ```
      render(){
          const {data} = this.props;
              const list = data.map( value =>
                  <div key={value.id}>{value.name} / {value.phone} </div>
              );
              return(
                  <div>
                  {list}
              </div>
          );
      }
      
      APP.js
      <PhoneLIst data = {this.state.contacts}/>
      ```

    - filter()  --> 조건

      myArray.filter(n => n !== 3 ? true : false)

      [1,2,4,5]

      myArray.filter(n => n === 3 ? true : false)
    
      [3]
    
    - 수정
    
      const modifiedArray2 = MyTag.map(v =>v.id === 1 ? ({...v , text:'React'}) : v);
      
      

### 4. React Router

> Reactjs code snippets -rsc / rcc

- SPA에서의 라우팅 문제를 해결하기 위해 사용되는 네비게이션 라이브러리

- 브라우저 내장 객체 사용 가능 

  - location
  - history

- React Router 

  - Web
  - Native
  - react-route-dom 라이브러리 필요 (n)

- Router - > Route 

  <Route>path = "/" component = {Home}Home</Rou

  <Route>path = "/about" component = {About}About </Reout>