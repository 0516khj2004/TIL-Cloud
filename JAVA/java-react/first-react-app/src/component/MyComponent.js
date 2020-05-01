import React, { Component } from 'react';
import propTypes from 'prop-types';
import '../index.css';

class MyComponent extends Component {
    static defaultProps = {
        name : '자바default'
    }
    static propTypes = {
        name: propTypes.string,
        age : propTypes.number.isRequired
    }
    //state 
    state = {
        number:0 , 
        message: '',
        messages: ['Angular','React','Vue','Ember']
    }

    //number 값을 감소시키는 함수 
    handleDecrease = (e) =>{
        console.log(e.target.value);
        this.setState({ 
            number : this.state.number -1
            }); 
    };

    //handlechange
    handleChange= (e) => {
        this.setState({
            message : e.target.value
        });
    }
    //onhandleInsert
    handleInsert = () => {
        const {message, messages} = this.state;
        this.setState({
            messages : messages.concat(message),
            message: ''
        });
    }
    //handleEnter
    handleEnter = (e) =>{
        // //문자로 비교
        // if(e.key === 'Enter'){
        //     this.handleInsert();
        // }

        //코드로 비교
        if(e.keyCode ===13){
            this.handleInsert();
        }
    }

    //hanndleRemove - 더블클릭시 삭제 이벤트 
    handleRemove = (index) => {
        const{messages} = this.state;
        this.setState({
            messages : messages.filter((item,i) => i !== index)
        })
    }
    render() {
        const {name,age} =  this.props;
        const{number, message, messages } = this.state; 
        const{handleDecrease, handleChange, handleInsert, handleEnter,handleRemove } = this;
        const msgList = messages.map( (msg,index) => (
            <li key={index} onDoubleClick= { ()=> {
                handleRemove(index)
            }}>{msg}</li>
        ));
        return (
            <div>
                Hello {name} , {age}
                <p> number 값은 : {number} </p>
                <button onClick={() => (this.setState(
                        {number : number +1}
                ))}>증가</button>
                <button onClick= {handleDecrease} value="-">감소</button>
                <br/>
                <button onClick={
                    () => (this.mymessage.focus())
                }>포커스주기 </button><br/>  
                <input type="text" value={message} onChange={handleChange}
                ref={(ref) => this.mymessage=ref}  
                // onKeyPress={handleEnter}
                onKeyDown={handleEnter}
                />
                <button onClick={() => {
                    this.setState({message : ''})
                }}>초기화</button>
                <button onClick={handleInsert}>리스트 추가</button>
                <ul>
                    {msgList}
                </ul>
            </div>
        );
    }
}

// MyComponent.defaultProps = {
//     name : '자바'
// };
// MyComponent.propTypes = {
//     name: propTypes.string
// };

export default MyComponent;