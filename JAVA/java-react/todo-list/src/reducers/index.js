import { FETCH_TODOS, ADD_TODOS, REMOVE_TODOS, TOGGLE_TODOS } from "../actions"

const initalState = {
    todos: [
        {
            id : 0, 
            text : '',
            checked : false
        }
    ]
}

//reducer 함수 
export const toDoReucer = (state = initalState, action) => {
    switch(action.type){
        case FETCH_TODOS:
        case ADD_TODOS:
        case REMOVE_TODOS:
        case TOGGLE_TODOS:
            return Object.assign({}, state, {todos: action.payload});
        default:
            return state
    }
}