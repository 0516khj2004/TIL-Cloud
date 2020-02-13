import React, { Component } from 'react';
import { connect } from 'react-redux';
import Chart from '../components/chart';

class WeatherList extends Component {
  renderWeather(cityData){
    console.log(cityData.data)
    //const name = cityData.date;

   // const country = cityData.high;
    const high = cityData.data.map(btn => btn.high);
    const low = cityData.data.map(btn => btn.low);
    const volume = cityData.data.map(btn => btn.volume);
    const quoteVolume = cityData.data.map(btn => btn.quoteVolume);
    
   //  const presures = cityData.list.map(weather => weather.main.pressure);
   //   const humidities = cityData.list.map(weather => weather.main.humidity);

    return(
      <tr key={cityData.currency}>
            <th>{cityData.currency}</th>
            <th><Chart data={high} color="orange"/></th>
            <th><Chart data={low} color="red"/></th>
            <th><Chart data={volume} color="black"/></th>
            <th><Chart data={quoteVolume} color="pink"/></th>
      </tr>
    )
  }

  render() {
    return (
      <table className='table'>
        <thead>
          <tr>
            <th>NAME </th>
            <th>HIGH </th>
            <th>LOW </th>
            <th>VOLUME </th>
            <th>QUOTEVOLUME</th>
          </tr>
        </thead>
        <tbody>
          {this.props.weather.map(this.renderWeather)}
        </tbody>
      </table>
    );
  }
}


// mapSrtateToProps funciton
function mapSrtateToProps(state){
  return{ weather: state.weather};
}

// connect mapping
export default connect(mapSrtateToProps)(WeatherList);