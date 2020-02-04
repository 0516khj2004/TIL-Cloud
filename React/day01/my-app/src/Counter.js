import React, { Component } from 'react';

class Counter extends Component{
    
    state = {
        count : 0,
        info : {
            name: 'React',
            age: 10
        }
    }

    constructor(props){
        super(props);
        this.state.count = this.props.counter;
        console.log('call contructor');
    }
    componentDidMount(){
        console.log('componentDidMount');
    }

    shouldComponentUpdate(nextProps, nextState){
        //5의 배수라면 리렌더링 하지 않음 
        console.log('shouldComponentUpdate');
        if(nextState.count % 5 ===0) return false;
        return true;
    }
    componentWillUpdate(nextProps, nextState){
        console.log('componentWillUpdate');
    }
    componentDidUpdate(prevProps, prevState){
        console.log('componentDidUpdate');
    }


        
    
    handlePlus = () => {
        this.setState({
        count : this.state.count + 1
        });
    }
    handleM = () => {
        this.setState({
            count : this.state.count - 1
        }); 

    }
    handleChangeInfo = () => {
        this.setState({
            info :{
                ...this.state.info,
                name: 'koo'
            }
        });
    }

    render(){
        return(
            <div>
                <h1>Counter</h1>
                <h2>{this.state.count}</h2>
                <button onClick={this.handlePlus}>+</button>
                <button onClick={this.handleM}>-</button>
                <button onClick={this.handleChangeInfo}>change</button>
                {this.state.info.name} / {this.state.info.age}
            </div>
        );
    }
}


export default Counter;