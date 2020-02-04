import React, { Component } from 'react';

class MyIntro extends Component{
    render(){
        const css = {
            color : 'blue',
            fontSize: '40px'
        }
        return(
            <div style={css}>
                안녕하세요 !<br />
                이름은: <b> {this.props.my.name} </b><br />
                이메일은: <b> {this.props.my.email} </b><br />
                폰 :<b> {this.props.my.phone} </b>
                 입니다.
            </div>
        );
    }
}

export default MyIntro;