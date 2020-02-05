import React, { Component } from 'react';
import PhoneForm from './phone_form';

class PhoneItem extends Component{
    state ={
        editable: false,
        name: '',
        phone: ''
    }
    componentDidUpdate(preprops, preState){
        const{ info, update} = this.props;
        console.log(info.name + "/"+info.phone);
        console.log(update);
        console.log(preState.editable + "/" + this.state.editable);
        //upate 화면에 데이터 보임 
        if(!preState.editable && this.state.editable){
            this.setState({
                name: info.name,
                phone: info.phone
            })
        }
        //update 저장 
        if(preState.editable && !this.state.editable){
            update(info.id, {name: this.state.name, phone: this.state.phone})
        }
    }
    handelRemove = () => {
        const {info, onRemove } = this.props;
        onRemove(info.id);
    }
    handelupdate = ()=> {
        const {editable} = this.state;
        this.setState({
            editable : !editable
        });
    }

    handelChange = (e) => {
        const {name, value} = e.target;
        this.setState({
            [name] : value
        });
    }
    render(){
        const css ={ 
            border : '1px solid black', 
            padding : ' 8px',
            margin : '5px'
        }
        const{ editable} = this.state;
        if(editable){
            return(
                <div style={css}>
                    <div>
                    <input value={this.state.name} name='name' placeholder="이름을 입력하세요" onChange= {this.handelChange}></input>
                    </div>
                    <div>
                    <input value={this.state.phone} name='phone' placeholder="번호를 입력하세요" onChange={this.handelChange}></input>
                    </div>
                    <button onClick={this.handelRemove}>삭제</button>
                    <button onClick={this.handelupdate}>적용</button>
                </div>
            );
        }

        const{ name, phone, id} = this.props.info;
        
        console.log(id);
        return(
            <div style={css}>
                <div><b>{name}</b></div>
                <div>{phone}</div>
                <button onClick={this.handelRemove}>삭제</button>
                <button onClick={this.handelupdate}>수정</button>
            </div>
        );
    }
}

export default PhoneItem;