import axios from "axios";

//Action 타입 변수
export const FETCH_TODOS =  "FETCH_TODOS";
export const ADD_TODOS =  "ADD_TODOS";
export const REMOVE_TODOS =  "REMOVE_TODOS";
export const TOGGLE_TODOS =  "TOGGLE_TODOS";


//server URL 
const apiUrl = process.env.REACT_APP_APIURL;

//todo목록 
export const fetchAllTodos = () => {
    return(dispatch) => {
        axios.get(apiUrl)
            .then(res => {
                dispatch({
                    type: FETCH_TODOS,
                    payload: res.data
            })
            })
            .catch(err => {
                console.error(err);
                throw (err);
            })
    }
}
//todo 등록 
export const addTodo = (todo) => {
    return(dispatch) => {
        axios.post(apiUrl,todo)
            .then(res => {
                dispatch({
                    type: ADD_TODOS,
                    payload: res.data
            })
            })
            .catch(err => {
                console.error(err);
                throw (err);
            })
    }
}

//todo 삭제
export const removeTodo = id => {
    return(dispatch) => {
        axios.delete(`${apiUrl}/${id}`)
            .then(res => {
                dispatch({
                    type: REMOVE_TODOS,
                    payload: res.data
            })
            })
            .catch(err => {
                console.error(err);
                throw (err);
            })
    }
}
//toggle
export const toggleTodo = (todo) => {
    return(dispatch) => {
        axios.put(`${apiUrl}/${todo.id}`, todo)
            .then(res => {
                dispatch({
                    type: TOGGLE_TODOS,
                    payload: res.data
            })
            })
            .catch(err => {
                console.error(err);
                throw (err);
            })
    }
}

