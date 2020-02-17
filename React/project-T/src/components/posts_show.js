import React, { Component } from 'react';
import { connect } from 'react-redux';
import { Link } from 'react-router-dom';
import { fetchPost, deletePost } from '../actions';

class PostsShow extends Component {
  componentDidMount(){
    // if(!this.props.post){
    const {id} = this.props.match.params
    this.props.fetchPost(id);
    // }
  }
  onDeleteClick(){
    const {id} = this.props.match.params
    this.props.deletePost(id, ()=> {
     this.props.history.push('/');
    });
  }
  render() {
    const {post} = this.props;
    console.log("post",post)
    if(!post){
      return <div>loding</div>
    }
    return (
      <div>
        <Link to="/"> Back To Index</Link>
        <button className='btn btn-danger pull-xs-right' 
        onClick={this.onDeleteClick.bind(this)}>Delect Post</button>
       <h3>{post.title}</h3> 
       <h6>category : {post.category}</h6>
       <p>{post.contents}</p>
      </div>
    );
  }
}

function mapStateToProps(state){
  // console.log(state.posts.blog)
  return {post : state.posts.blog } ;
}
export default connect(mapStateToProps, {fetchPost,deletePost})(PostsShow);