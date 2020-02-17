import React from 'react';
import {NavLink} from 'react-router-dom';
import './Header.css'

const Header = () => {
    return (
        <div className='header'>
            <NavLink exact to="/" className='item'>Home</NavLink>
            <NavLink to="/about/koo" className='item'>About</NavLink>
            <NavLink to="/posts" className='item'>posts</NavLink>
            <NavLink to="/mypofile" className='item'>mypofile</NavLink>
            <NavLink to="/login" className='item'>login</NavLink>
            <NavLink to="/search" className='item'>search</NavLink>
        </div>
    );
};

export default Header;