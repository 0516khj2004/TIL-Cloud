import React,{Component} from 'react'
import PhoneItem from './phone_Item';

class PhoneLIst extends Component{
    render(){

        const {data, onRemove, update} = this.props;

        

        const list = data.map( value =>
           (
               <PhoneItem 
               key = {value.id} 
               info = {value}
               onRemove = {onRemove}
               update = {update}
                 />
           )
        );
        return(
            <div>
               {list}
            </div>
        );
    }
}

export default PhoneLIst;