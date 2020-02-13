import React, { Component } from 'react';
import { connect } from 'react-redux'
import { bindActionCreators } from 'redux';
import { fetchWeather } from '../actions/index';

class SearchBar extends Component {
  constructor(props) {
    super(props);

  }

  onInputChange(event) {
    this.setState({
      term : event.target.value
    })
  }

  onFormSubmit(event) {
    event.preventDefault();
    this.props.fetchWeather(this.state.term);
    this.setState( { term : ''});
  }

  render() {
    return (
      <form onSubmit={this.onFormSubmit} className="input-group">
        <input 
          placeholder = 'get a five-day forecast in yout favorite cities'
          className='form-control'
          value={this.state.term}
          onChange={this.onInputChange}
          />
        <span className="input-group-btn">
          <button type="submit" className="btn btn-secondary">Submit</button>
        </span>
      </form>
    );
  }
}

// mapDispatchToProps function

function mapDispatchToProps(dispatch){
  return bindActionCreators({ fetchWeather}, dispatch);
}

// connect mapping
export default connect(null, mapDispatchToProps)(SearchBar);