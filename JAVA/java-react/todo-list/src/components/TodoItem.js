import React, { Component } from 'react';
import './TodoItem.css';
import {removeTodo, toggleTodo} from '../actions'
import { connect } from 'react-redux';

class TodoItem extends Component {
    handelRemove = (id) =>{
        this.props.removeTodo(id); //action함수에 있는 remove함수 call 
    };
    handleToggle= (todo) => {
        this.props.toggleTodo(todo);
    }
        
    //render() 메서드의 호출을 줄 일 수 있다.
    shouldComponentUpdate(nextProps, nextState) {
        return this.props.checked !== nextProps.checked;
        }

    render() {
        const { todoText, checked, id} = this.props;
        return (
            <div className="todo-item" onClick={() => {
                const todo= { id, text : todoText, checked };
                todo.checked= !todo.checked;
                this.handleToggle(todo)
                }}>
                <div className="remove" onClick={(e) => {
                    //버플업(이벤트가 전파) 방지
                    e.stopPropagation();
                    this.handelRemove(id)
                }}>
                    &times;
                </div>
                <div className={`todo-text ${checked && 'checked'}`}>
                    <div>{todoText}</div>
                </div>
                {
                    checked && (<div className="check-mark">✓</div>)
                    }
            </div>
        );
    }
}

export default connect(null, {removeTodo, toggleTodo})(TodoItem);