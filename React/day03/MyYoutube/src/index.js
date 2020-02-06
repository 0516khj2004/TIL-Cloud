import React from 'react';
import ReactDom from 'react-dom';
import YTSearch from 'youtube-api-search';
import SearchBar from './components/search_bar';

const API_KEY = 'AIzaSyCRMw_OQDTOoBxbsxOV4esXu-GyTOKPQrw';
YTSearch({
  key : API_KEY ,term : 'java'}, function(data){
  console.log(data);
});

const App = function (){
  return(
    <div>
      
      <SearchBar />
    </div>
  )
}

ReactDom.render(<App />, document.querySelector('.container'));