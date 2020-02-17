import React from 'react';

const Search = ({location}) => {
    return (
        <div>
            {/*Search keyword: {location.search}*/}
            Search keyword : {new URLSearchParams(location.search).get("keyword")}
        </div>
    );
};

export default Search;