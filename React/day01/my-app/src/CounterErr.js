import React, { Component } from 'react';

const ErrorObject = () => {
  throw (new Error('에러 발생'));
}

class Counter extends Component {
  state = {
    count: 0,
    error: false
  }
  
  componentDidCatch(error, info) {
    this.setState({
      error: true
    });
  }

 get
  handleIncrease = () => {
    this.setState({
      count: this.state.count + 1
    });
  }  

  handleDecrease = () => {
    this.setState({
      count: this.state.count - 1
    });
  }  

  render() {
    if(this.state.error) return (<h1>에러가 발생되었습니다.</h1>);

    return (
      <div>
        <h1>Counter</h1>
        <h2>{this.state.count}</h2>
        {this.state.count == 3 && <ErrorObject />}
        <button onClick={this.handleIncrease}>+</button>
        <button onClick={this.handleDecrease}>-</button>
        <button onClick={this.handleChangeInfo}>Change info name</button>
      </div>
    );
  }
}

export default Counter;