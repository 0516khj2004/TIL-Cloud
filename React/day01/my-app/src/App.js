import React, { Component } from 'react';
import './App.css';
import Counter from './Counter';


class App extends Component{
  render(){
    const counter = 200
    return(
        <Counter counter = {counter}/>
      
    );
  }
}

export default App;
 