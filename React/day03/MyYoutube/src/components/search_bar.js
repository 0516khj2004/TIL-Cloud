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
            term : e.target.value 
        })
        // this.props.search(e.target.value)

    }
    
    onVideoSearch = (e) => {
        e.preventDefault()
        console.log(this.props)

        this.props.search(this.state.term)
    } 
    render() {
        return(
            <div className='search-bar'>
                <form onSubmit={this.onVideoSearch}>
                    <input 
                        name = 'term'
                        onChange={this.onInputChange}
                    />
                    <button type='submit'>검색</button>
                </form>
            </div>
            //<input onChange={event => console.log(event.target.value)}
            
        )
    }
}


export default SearchBar;