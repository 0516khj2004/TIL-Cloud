import React, { Component } from 'react';
import TodoListTemplate from './components/TodoListTemplate';
import Form from './components/Form';
import TodoItemList from './components/TodoItemList';

// const initialTodos = new Array(500).fill(0).map(
//     (item, idx) => ({ id: idx, text: `일정 ${idx}`, checked: true })
//     )

class App extends Component {
    render() {
        return (
            <TodoListTemplate form={<Form />}>
               <TodoItemList />
            </TodoListTemplate>
        );
    }
}
export default App;