import axios from 'axios';

//const API_KEY = '3ab6be6c58fdbe263c7d3dee8c8adc23';
//const ROOT_URL = `https://api.openweathermap.org/data/2.5/forecast?appid=${API_KEY}`;
const ROOT_URL = `http://localhost:8800/api/blogs`;
export const FETCH_WEATHER = 'FETCH_WEATHER';

//redux action
// tyoe(mandatory)
// payload(optional, data?)
export async function fetchWeather(usdt) {
    const url = `${ROOT_URL}`;
    const request = await axios.get(url)
  
    return{
        type: FETCH_WEATHER,
        payload: request,
        currency: usdt
    }
}