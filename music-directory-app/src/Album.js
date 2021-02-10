import React from 'react';
import style from "./album.module.css";

const Album = ({name, year, image}) => {
    return(
        <div className={style.album}>
            <h1>{name}</h1>
            <img className={style.image} src={image} alt=""/>
            <p>{year}</p>
        </div>
    );
}

export default Album;