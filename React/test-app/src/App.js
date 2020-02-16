import React, { Component } from 'react';
import Form from './components/Form';
import List from './components/List';

class App extends Component {
  id =1;
  state = {
    contacts : [
      {
        id : "",
        todo : ''
      }
    ],
  }
  handleCreate = (data) => {
    const { contacts } = this.state;
    this.setState({
      contacts: contacts.concat({id: this.id++, ...data})
    })
  } 
  handleRemove = (id) => {
    const { contacts } = this.state;

    this.setState({
      contacts: contacts.filter(
        info => info.id !== id
      )
    });
  }
  render() {
    
    return ( 
      <div className="App-header">
        <Form 
          onCreate = {this.handleCreate}
        />

        <List
          data = {this.state.contacts}
          onRemove = {this.handleRemove}  
        />
      </div>
    );
  }
}

export default App;