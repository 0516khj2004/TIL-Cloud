import React from 'react';

const MyIntro2 = function({my}){
    const css = {
        color : 'red',
        fontSize: '40px'
    }
    return(
        
        <div style={css}>
                안녕하세요 !<br />
                이름은: <b> {my.name} </b><br />
                이메일은: <b> {my.email} </b><br />
                폰 :<b> {my.phone} </b>
                 입니다.
            </div>
    );
}
export default MyIntro2;