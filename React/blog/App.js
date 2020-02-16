import React, { Component } from 'react';
import './App.css';

//import SearchBar from './containers/search_bar';
//import WeatherList from './containers/weather_list';
import Users from './component/users';
import Add from './component/Add';

export default class App extends Component {
 
  render() {
    return (
      <div>
        <Add/>
        <Users/>
      </div>
    );
  }
}
