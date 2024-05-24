import React from "react";
import './testo.scss'

interface testo {
    text: string;
}

const Testo : React.FC <testo>= ({text}) => {
    
    return (
        <p className="testo">{text}</p>
    )
}

export default Testo;