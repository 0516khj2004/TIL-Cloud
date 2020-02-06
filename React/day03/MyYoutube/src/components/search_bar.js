import React, { Component } from 'react';

class SearchBar extends Component{
    
    constructor(props){
        super(props);
        this.state = {
            term : ''
        }
    }
    
    onInputChange = (e) => {
        this.setState({
            [e.target.name] : e.target.value 
        })
        console.log(this.state)
    }
    render() {
        return(
            <div>
            <input 
            name = 'term'
            onChange={this.onInputChange}
            />
            <div>Value of the input : {this.state.term}</div>
            </div>
            //<input onChange={event => console.log(event.target.value)}
            
        )
    }
}


export default SearchBar;