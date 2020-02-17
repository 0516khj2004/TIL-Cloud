import React from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import Home from "./routes/Home";
import About from "./routes/About";
import Header from './component/Header';
import Posts from './routes/Posts';
import Myprofile from './routes/Myprofile';
import Login from './routes/Login';
import Search from './routes/Search';
import NotFound from './component/NotFound';
const App = () => {
  return (
    <div>
      <Router>
           <Header />
           <Switch>
            <Route exact path = "/" component = {Home} />
            <Route path = "/about/:userid" component = {About} />
            <Route path = "/posts" component= {Posts}/>
            <Route path = "/mypofile" component = { Myprofile} />
            <Route path = "/login" component={Login} />
            <Route path = "/search" component={Search} />
            <Route component={NotFound}/>
           </Switch>
       </Router>
    </div>
  );
};

export default App;