import { FETCH_WEATHER } from "../actions";

//biz logic
//src/reducers/reducer_weather.js
//action.type(FETCH_WEATHER) , action.payload(weather.json)
export default function(state = [], action) {
    switch(action.type){
        case FETCH_WEATHER:
            // (x)return state.push(action.payload.data); 
            return[{currency: action.currency , data: action.payload.data},...state ];
        default:
            return state;
    }
}