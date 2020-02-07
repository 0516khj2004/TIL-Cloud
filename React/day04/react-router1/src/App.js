import React from 'react';
import {BrowserRouter as Router, Route} from 'react-router-dom';
import Page1 from './routes/Page1';
import Page2 from './routes/Page2';
import Page3 from './routes/Page3';
import Header from'./componnents/Header';
const App = () => {
  return (
    <div>
      My NOtES
      <Router>
           <Header />
           <Route path="/mynote1" component={Page1}/>
           <Route path="/mynote2" component={Page2}/>
           <Route path="/mynote3" component={Page3}/>
       </Router>
    </div>
  );
};

export default App;