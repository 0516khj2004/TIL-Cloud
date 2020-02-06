import React from 'react';
import VideoListItem from './video_Listt_Item';

const VideoList = (props) => {

    const videoItems = props.videos.map((v) =>{
        return(
            <VideoListItem
                onVideoSelect = {props.onVideoSelect}
                key = {v.etag} 
                video={v}/>
      )
    });
    console.log(props.videos);
    return(
        <ul className='col-md-4 list-group'>
           {videoItems};
        </ul>
    )
}

export default VideoList