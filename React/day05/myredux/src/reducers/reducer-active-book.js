export default function(state = null , action){
    switch(action.type){
        case 'BOOK_SELETED' : 
            return action.payload;
        default:
            return state;
    }
}