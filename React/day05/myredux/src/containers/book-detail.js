import React, { Component } from 'react';
import { connect } from 'react-redux';

class BookDetail extends Component {
    render() {
        if(!this.props.book){
            return <div>select a book to get started</div>
        }
        return (
            <div>
                <h3>BookDetail for:</h3>
                <div>title : {this.props.book.title}</div>
            </div>
        );
    }
}

function mapStateToProps(state) {
    return {
        books : state.activeBook
    }
}
export default connect(mapStateToProps)(BookDetail)