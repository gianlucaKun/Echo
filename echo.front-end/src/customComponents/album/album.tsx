import React from "react";
import './album.scss'
import Testo from "../testo/testo";
import ButtonIcon from "../buttonIcon/buttonIcon";
import AddCircleOutlineIcon from '@mui/icons-material/AddCircleOutline';
import ShareIcon from '@mui/icons-material/Share';

interface album {
    image?: string;
    event?: () => void;
}

const Album : React.FC<album> = () => {
    return (
        <>
            <div className="contenitore">
                <div className="immagine"/>
                <div className="data">
                    <Testo text={"Mika & more"}/>
                    <div className="contenitoreBottoni">
                        <ButtonIcon icon={<AddCircleOutlineIcon/>}/>
                        <ButtonIcon icon={<ShareIcon/>}/>                        
                    </div>
                </div>
                
            </div>
        </>
    )
}

export default Album;