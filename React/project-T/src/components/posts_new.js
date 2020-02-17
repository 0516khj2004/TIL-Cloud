import React, { Component } from 'react';
import { Field, reduxForm } from 'redux-form';
import { Link } from 'react-router-dom';
import { connect } from 'react-redux';

import { createPost } from '../actions';

class PostsNew extends Component {
  renderField(filed){
    const {meta} = filed;
    const className = `form-group ${meta.touched && meta.error ? 'has-danger' : ''}`
    console.log(meta.touched + "/" + meta.error);

    return (
      <div className= {className}>
        <label>{filed.lable}</label>
        <input className="form-control" type ="text"{...filed.input}></input>
        <div className='text-help'>{meta.error}</div>
      </div>
    )
  }

  onSubmit(values) {
    this.props.createPost(values, () =>{
      this.props.history.push('/');
    } );
    
  }

  render() {
    const {handleSubmit} = this.props;
    return (
      <form onSubmit={handleSubmit(this.onSubmit.bind(this))} >
        <Field lable='Title' name="title" component={this.renderField}></Field>
        <Field lable="Category"name="category" component={this.renderField}></Field>
        <Field lable="Contents"name="contentns" component={this.renderField}></Field>
        <button type="submit" className="btn btn-primary">Submit</button>
        <Link to="" className="btn btn-danger">Cancle</Link>
      </form>
    );
  }
}
function validate(values) {
  const errors = {}

  if(!values.title || values.title.length <3 ){
    errors.title = "제목을 3글자 이상 입력해 주세요"
  }
  if (!values.category){
    errors.category = "카테고리 지정해 주세요"
  }
  if (!values.contentns){
    errors.contentns = "블로그의 내용을 입력해 주세요 "
  }
  return errors;
}

export default reduxForm(
  {
    validate : validate, 
    form : 'PostNewForm'}
)( connect(null, { createPost }) (PostsNew));
