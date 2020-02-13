import React, { Component } from 'react';
import { connect } from 'react-redux';
import Chart from '../components/chart';

class WeatherList extends Component {

  render() {
    return (
      <table>
        <thead>
          <tr>
            <th>City</th>
            <th>Temperature</th>
            <th>Pressure</th>
            <th>Humidity</th>
          </tr>
        </thead>
        <tbody>
          {this.props.weather}
        </tbody>
      </table>
    );
  }
}

// mapSrtateToProps funciton

function mapSrtateToProps(state){
  return{ weather: this.state.weather};
}

// connect mapping
export default connect(mapSrtateToProps)(WeatherList)