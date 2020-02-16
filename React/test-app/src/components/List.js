import React, { Component } from 'react';
import Item from './Item';

class List extends Component {
    // shouldComponentUpdate(nextProps, nextState){
    //     return nextProps.data !== this.props.data;
    // }
    
    render() {
        const {data, onRemove} = this.props;
        const list = data.map(
            info => (
                <Item
                    key = {info.id}
                    info = {info}
                    onRemove ={onRemove}
                />
               

            )
        )
        return (
            <div>
                {list}
            </div>
        );
    }
}

export default List;