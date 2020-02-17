import React from 'react';

const About = ({match}) => {
    return (
        <div>
            {match.params.userid} 's About
        </div>
    );
};

export default About;