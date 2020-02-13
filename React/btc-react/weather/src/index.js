import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import { createStore, applyMiddleware } from 'redux';

import ReduxPromise from 'redux-promise';

import App from './App';

import reducers from './reducers';

// make a store 

ReactDOM.render(
    <App />
  , document.getElementById('root'));
