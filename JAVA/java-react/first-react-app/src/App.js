import React, { Component } from 'react';
import MyComponent from './component/MyComponent';
import MyComponentFunc from './component/MyComponentFunc';

class App extends Component {
  render() {
    return (
      <React.Fragment>
          <MyComponent name="리엑트" age={10} />
          <MyComponent age= {20} />
          {/* <MyComponent name={300} /> */}
          <MyComponentFunc name="함수형 컨포넌트" age={30} />
     </React.Fragment>
    );
  }
}


export default App;
