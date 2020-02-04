import React, { Component } from 'react';
import './App.css';
import Counter from './Counter';
import CounterErr from './CounterErr';


class App extends Component{
  render(){
    const counter = 200
    return(
        <CounterErr counter = {counter}/>
      
    );
  }
}

export default App;
 