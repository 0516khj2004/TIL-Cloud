import React from 'react';
import {Redirect} from 'react-router-dom';

const isLogged = false;


const Myprofile = () => {
    return (
        <div>
            {!isLogged && <Redirect to="/login" />}
            Myprofile
        </div>
    );
};

export default Myprofile;