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
    ],
    keyword : ''
  }

  handleCreate = (data) => {
    console.log(data);

    const {contacts} = this.state
    this.setState({
      contacts: contacts.concat({id: this.id++, ...data})
    })
    
  }
  handleSearch = (e) =>{
    this.setState({
      keyword : e.target.value
    });
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
    const {contacts, keyword} = this.state
    const filterContacts = contacts.filter(v => v.name .indexOf(keyword) !== -1 );

    return (
      <div>
          <PhoneForm 
            onCreate = {this.handleCreate} />
          <input 
            placeholder= '검색하세요'
            onChange={this.handleSearch}
            value = {this.state.keyword} />
          <PhoneLIst 
          data = {filterContacts}
          onRemove = {this.handleRemove}
          update = {this.handleUpdate } />
      </div>
    );
  }
}

export default App;
