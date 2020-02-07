import React from 'react';
import {Link } from 'react-router-dom';

const Header = () => {
    return (
        <div>
            <ul>
                <li><Link to='/mynote1'>page1</Link></li>
                <li><Link to='/mynote2'>page2</Link></li>
                <li><Link to='/mynote3'>page3</Link></li>
            </ul>
        </div>
    );
};

export default Header;
