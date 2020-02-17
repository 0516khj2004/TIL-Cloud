import {FETCH_POSTS, CREATE_POST,FETCH_POST,DELETE_POST} from '../actions';

export default function (state = {}, action) {
    switch(action.type) {
        case FETCH_POSTS:
           return action.payload.data.blogs
        case FETCH_POST:
            const post = action.payload.data;
            console.log(post)

            return  action.payload.data
       default:
            return state;
    }
}