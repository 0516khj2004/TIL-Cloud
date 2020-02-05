import React, { Component } from 'react';
import './App.css';
import PhoneForm from './components/phone_form';
import PhoneLIst from './components/Phone_List';

class App extends Component{
  id =1 ;
  state = {
    contacts : [
      {
      id : 0,  
      name : '관리자',
      phone : '010-111-1111'
      }
    ]
  }

  handleCreate =(data) => {
    console.log(data);

    const {contacts} = this.state
    this.setState({
      contacts: contacts.concat({id: this.id++, ...data})
    })
    
  }

  handleRemove = (selected_id) => {
      const {contacts} = this.state;
      
      this.setState({
      contacts: contacts.filter(
        info => info.id !== selected_id )
      });  
  }

  handleUpdate = (selected_id, data) => {
    const {contacts} = this.state;
    this.setState({
      contacts: contacts.map(
        item => item.id === selected_id ? {...item, ...data} : item
      )
    });
}

  render(){
    const {contacts} = this.state
    return (
      <div>
          <PhoneForm 
            onCreate = {this.handleCreate} />
          <PhoneLIst 
          data = {this.state.contacts}
          onRemove = {this.handleRemove}
          update = {this.handleUpdate }/>
      </div>
    );
  }
}

export default App;
