import React, { Component, Fragment } from 'react';
import { connect } from 'react-redux';
import axios from "axios";
const ROOT_URL = `http://localhost:8800/api/blogs`;

class WeatherList extends Component {
 
  constructor(props){
    super(props);
    this.state = { blogs: [], ajaxCalled: false };
  }

  async componentDidMount() {
    const { data: blogs } = axios.get(ROOT_URL)
      .then(value => {
        this.lsitingPost(value.data.blogs)
      });
  }

  lsitingPost = (data) => {
    this.setState({ ajaxCalled: true, blogs: data });
  }

  handleListHtml = (post) => {
    console.log(post)
    return(
      <Fragment>
        <p>{post.id}</p>
        <p>{post.title}</p>
        <p>{post.author}</p>
        <p>{post.contents}</p>
        <p>{post.cdate}</p>
      </Fragment>
    )
  }

  render() {
    const { ajaxCalled, blogs } = this.state;
    console.log(">>>", blogs);
    if(!ajaxCalled){
      return(<div>loading...</div>)
    }
    return (
      <Fragment>
        {blogs.map(value => this.handleListHtml(value))}
      </Fragment>
    )
  }
}

export default WeatherList;

// mapSrtateToProps funciton
//function mapSrtateToProps(state){
 // return{ weather: state.weather};
//}

// connect mapping
//export default connect(mapSrtateToProps)(WeatherList);