import React, { Component } from 'react';

class Counter extends Component{
    
    state = {
        count : 0
    }
    handelP = () => {
        this.setState({
        count : this.state.count + 1
        });
    }
    handelM = () => {
        this.setState({
            count : this.state.count - 1
        }); 

    }

    render(){
        return(
            <div>
                <h1>Counter</h1>
                <h2>{this.state.count}</h2>
                <button onClick={this.handelP}>+</button>
                <button onClick={this.handelM}>-</button>
            </div>
        );
    }
}


export default Counter;