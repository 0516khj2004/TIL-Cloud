import React, { Component } from 'react';
import './App.css';
import MyIntro from './MyIntro.js';

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

export default App;
 