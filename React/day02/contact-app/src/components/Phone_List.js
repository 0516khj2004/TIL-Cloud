import React,{Component} from 'react'

class PhoneLIst extends Component{
    render(){

        const {data} = this.props;

        const list = data.map( value =>
           <div key={value.id}>{value.name} / {value.phone} </div>
        );
        return(
            <div>
               {list}
            </div>
        );
    }
}

export default PhoneLIst;