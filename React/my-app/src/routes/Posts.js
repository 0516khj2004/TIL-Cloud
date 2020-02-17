import React from 'react';
import {BrowserRouter as Router, Route} from 'react-router-dom';
import {Link} from 'react-router-dom';

const Post = ({match}) => {
    return (
        <h3>{match.params.title}</h3>
    )
}
const Posts = () => {
    return (
        <div>
            <h2>Posts</h2>
            <ul>
                <li><Link to="/posts/java"> JAVA Programing</Link></li>
                <li><Link to="/posts/react"> React Programing</Link></li>
                <li><Link to="/posts/js"> JAVAScript Programing</Link></li>
            </ul>
            
            <Route path="/posts/:title" component= {Post}></Route>
        </div>
    );
};

export default Posts;