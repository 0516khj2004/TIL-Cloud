import React, { Component } from 'react';

class Item extends Component {
    state = {
        todo : ''
    }
    handelRemove= ()=>{
        const{info, onRemove} = this.props;
        onRemove(info.id);

    }
    render() {
        const css = {
            border: '1px solid black',
            padding: '8px',
            margin: '5px'
          };
        const {todo} = this.props.info
        return (
            <div style={css}>
                <div><b>{todo}</b></div>
                <button onClick={this.handelRemove}>삭제</button>
            </div>
        );
    }
}

export default Item;