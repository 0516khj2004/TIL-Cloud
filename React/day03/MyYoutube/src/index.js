import React, { Component } from 'react';
import ReactDom from 'react-dom';
import YTSearch from 'youtube-api-search';
import SearchBar from './components/search_bar';
import VideoList from './components/video_List';
import VideoDetail from './components/video_detail'

const API_KEY = 'AIzaSyCRMw_OQDTOoBxbsxOV4esXu-GyTOKPQrw';

class App extends Component {
 
  constructor(props){
    super(props); //부모의 생성자 함수를 호출 
    this.state ={
      videos : [],
      selectedvideo : null 
    }

    this.videoSearch('아마두')
  }

  videoSearch = (term) => {
    console.log(term);
    YTSearch({
      key : API_KEY ,term : term }, (data) => {
      this.setState({
        videos : data,
        selectedvideo : data[0]
      });
    })
  }

  handelSelect = (selectedvideo) => {
    this.setState({
      selectedvideo //: selectedvideo :사이로 둘다 이름이 같으면 궅이 : 뒤로 안써도 된다
    })
  }
  
  render(){
    return(
      <div> 
        <SearchBar search ={this.videoSearch}/>
        <VideoDetail video = { this.state.selectedvideo} />
        <VideoList 
          videos= {this.state.videos} 
          onVideoSelect={this.handelSelect}/>
      </div>
    )
  }
}

ReactDom.render(<App />, document.querySelector('.container'));